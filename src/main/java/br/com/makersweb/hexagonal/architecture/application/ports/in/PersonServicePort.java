package br.com.makersweb.hexagonal.architecture.application.ports.in;

import br.com.makersweb.hexagonal.architecture.application.core.domain.PageInfo;
import br.com.makersweb.hexagonal.architecture.application.core.domain.Person;
import org.springframework.data.domain.Page;

import java.util.UUID;

/**
 * @author aaristides
 */
public interface PersonServicePort {

    Page<Person> find(PageInfo pageInfo);

    Person getById(UUID id);

    Person create(Person person);

    Person update(UUID id, Person person);

    void delete(UUID id);

}
