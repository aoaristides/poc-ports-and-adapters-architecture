package br.com.makersweb.hexagonal.architecture.adapter.in.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

/**
 * @author aaristides
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PersonRequest implements Serializable {

    @Size(min = 10, max = 50)
    @NotBlank
    private String name;
    @Past
    private LocalDate dateOfBirth;
    @Size(min = 11, max = 14)
    private String document;

    @Size(min = 10, max = 11)
    private String type;
    @Email
    @NotBlank
    private String mail;

    private Map<String, String> parametros;


}
