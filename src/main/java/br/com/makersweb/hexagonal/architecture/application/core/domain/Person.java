package br.com.makersweb.hexagonal.architecture.application.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author aaristides
 */
@Setter
@Getter
public class Person implements Serializable {

    private UUID id;
    private String name;
    private String mail;
    private LocalDate dateOfBirth;
    private String document;
    private String type;

}
