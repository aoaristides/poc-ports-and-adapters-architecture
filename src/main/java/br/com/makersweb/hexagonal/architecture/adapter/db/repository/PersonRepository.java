package br.com.makersweb.hexagonal.architecture.adapter.db.repository;

import br.com.makersweb.hexagonal.architecture.adapter.db.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author aaristides
 */
public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {
}
