package br.com.makersweb.hexagonal.architecture.application.core.service;

import br.com.makersweb.hexagonal.architecture.application.core.domain.PageInfo;
import br.com.makersweb.hexagonal.architecture.application.core.domain.Person;
import br.com.makersweb.hexagonal.architecture.application.ports.in.PersonServicePort;
import br.com.makersweb.hexagonal.architecture.application.ports.out.PersonDatabasePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;

import java.util.UUID;

/**
 * @author aaristides
 */
@Slf4j
public class PersonServiceImpl implements PersonServicePort {

    private final PersonDatabasePort personDatabasePort;

    public PersonServiceImpl(PersonDatabasePort personDatabasePort) {
        this.personDatabasePort = personDatabasePort;
    }

    @Override
    public Page<Person> find(PageInfo pageInfo) {
        log.info("Init method find to person.");
        return this.personDatabasePort.find(pageInfo);
    }

    @Override
    public Person getById(UUID id) {
        log.info("Init method get person by id - {}", id.toString());
        return this.personDatabasePort.findById(id).orElseThrow();
    }

    @Override
    public Person create(Person person) {
        log.info("Init method create to person - {}", person.getName());
        return this.personDatabasePort.create(person);
    }

    @Override
    public Person update(UUID id, Person person) {
        log.info("Init method update to person by id - {}", id.toString());
        return this.personDatabasePort.update(id, person);
    }

    @Override
    public void delete(UUID id) {
        log.info("Init method delete to person by id - {}", id.toString());
        this.personDatabasePort.delete(id);
    }
}
