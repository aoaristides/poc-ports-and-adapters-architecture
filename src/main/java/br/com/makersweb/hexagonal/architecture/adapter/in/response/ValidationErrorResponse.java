package br.com.makersweb.hexagonal.architecture.adapter.in.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
public class ValidationErrorResponse extends ErrorResponse {

    private List<FieldErroMessage> erros = new ArrayList<>();

    public List<FieldErroMessage> getErros() {
        return erros;
    }

    public void addError(String fieldName, String message, String messageDeveloper) {
        erros.add(new FieldErroMessage(fieldName, message, messageDeveloper));
    }

}
