package br.com.makersweb.hexagonal.architecture.application.ports.out;

import br.com.makersweb.hexagonal.architecture.application.core.domain.PageInfo;
import br.com.makersweb.hexagonal.architecture.application.core.domain.Person;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

/**
 * @author aaristides
 */
public interface PersonDatabasePort {

    Page<Person> find(PageInfo pageInfo);

    Optional<Person> findById(UUID id);

    Person exist(UUID id);

    Person create(Person person);

    Person update(UUID id, Person person);

    void delete(UUID id);

}
