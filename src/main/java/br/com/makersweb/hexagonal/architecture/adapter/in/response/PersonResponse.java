package br.com.makersweb.hexagonal.architecture.adapter.in.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author aaristides
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PersonResponse implements Serializable {

    private UUID id;
    private String name;
    private LocalDate dateOfBirth;
    private String document;
    private String type;
    private String mail;

}
