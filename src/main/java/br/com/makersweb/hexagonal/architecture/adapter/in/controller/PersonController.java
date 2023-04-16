package br.com.makersweb.hexagonal.architecture.adapter.in.controller;

import br.com.makersweb.hexagonal.architecture.adapter.in.event.ResourceCreatedEvent;
import br.com.makersweb.hexagonal.architecture.adapter.in.mapper.PersonHttpMapper;
import br.com.makersweb.hexagonal.architecture.adapter.in.request.PersonRequest;
import br.com.makersweb.hexagonal.architecture.adapter.in.response.PersonResponse;
import br.com.makersweb.hexagonal.architecture.application.core.domain.PageInfo;
import br.com.makersweb.hexagonal.architecture.application.ports.in.PersonServicePort;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.UUID;

/**
 * @author aaristides
 */
@RestController
@RequestMapping("/v1/persons")
public class PersonController {

    private final PersonServicePort personServicePort;
    private final ApplicationEventPublisher publisher;
    private final HttpServletResponse response;

    public PersonController(PersonServicePort personServicePort, ApplicationEventPublisher publisher, HttpServletResponse response) {
        this.personServicePort = personServicePort;
        this.publisher = publisher;
        this.response = response;
    }

    @PostMapping
    public ResponseEntity<PersonResponse> create(@Valid @RequestBody PersonRequest request) throws Exception {
        var person = personServicePort.create(PersonHttpMapper.INSTANCE.toDomain(request));
        publisher.publishEvent(new ResourceCreatedEvent(this, response, person.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(PersonHttpMapper.INSTANCE.toResponse(person));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonResponse> getById(@PathVariable UUID id) {
        var person = personServicePort.getById(id);
        return ResponseEntity.ok().body(PersonHttpMapper.INSTANCE.toResponse(person));
    }

    @GetMapping
    public ResponseEntity<Page<PersonResponse>> find(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable pageable) {
        PageInfo pageInfo = new PageInfo();
        BeanUtils.copyProperties(pageable, pageInfo);
        var page = personServicePort.find(pageInfo);

        return ResponseEntity.ok().body(PersonHttpMapper.INSTANCE.toPageResponse(page));
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<PersonResponse> update(@PathVariable UUID id, @RequestBody PersonRequest request) throws Exception {

        var person = personServicePort.update(id, PersonHttpMapper.INSTANCE.toDomain(request));
        return ResponseEntity.status(HttpStatus.OK).body(PersonHttpMapper.INSTANCE.toResponse(person));
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        personServicePort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
