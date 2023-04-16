package br.com.makersweb.hexagonal.architecture.adapter.db.repository;

import br.com.makersweb.hexagonal.architecture.adapter.db.entity.PersonEntity;
import br.com.makersweb.hexagonal.architecture.application.core.domain.PageInfo;
import br.com.makersweb.hexagonal.architecture.application.core.domain.Person;
import br.com.makersweb.hexagonal.architecture.application.core.exception.ResourceNotFoundException;
import br.com.makersweb.hexagonal.architecture.application.ports.out.PersonDatabasePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static br.com.makersweb.hexagonal.architecture.adapter.db.mapper.PersonPersistenceMapper.INSTANCE;
import static java.lang.String.format;

/**
 * @author aaristides
 */
@Component
@Primary
@Slf4j
public class PostegresPersonDatabase implements PersonDatabasePort {

    private final PersonRepository personRepository;

    public PostegresPersonDatabase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    @Override
    public Page<Person> find(PageInfo pageInfo) {
        log.info("Init method find persons.");
        Pageable pageable = PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize());
        Page<PersonEntity> page = this.personRepository.findAll(pageable);
        return INSTANCE.toPageDomain(page);
    }

    @Transactional
    @Override
    public Optional<Person> findById(UUID id) {
        log.info("Init method find person by id - {}", id.toString());
        return Optional.of(this.exist(id));
    }

    @Transactional
    @Override
    public Person exist(UUID id) {
        log.info("Init method exist person by id - {}", id.toString());
        var personEntity = this.personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(format("Not found regitstry with code %d", id)));

        return INSTANCE.toDomain(personEntity);
    }

    @Transactional
    @Override
    public Person create(Person person) {
        log.info("Init method create person by name - {}", person.getName());
        return INSTANCE.toDomain(this.personRepository.save(INSTANCE.toEntity(person)));
    }

    @Transactional
    @Override
    public Person update(UUID id, Person person) {
        log.info("Init method update person by id - {}", id.toString());
        var personSaved = this.exist(id);
        BeanUtils.copyProperties(person, personSaved, "id");
        return INSTANCE.toDomain(this.personRepository.save(INSTANCE.toEntity(personSaved)));
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        log.info("Init method delete person by id - {}", id.toString());
        var personSaved = this.exist(id);
        this.personRepository.delete(INSTANCE.toEntity(personSaved));
    }
}
