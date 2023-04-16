package br.com.makersweb.hexagonal.architecture.adapter.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aaristides
 */
@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("POC - Ports And Adapters Architecture")
                        .version("1.0.0")
                        .description("Projeto aplicando conceitos de Arquitetura Hexagonal")
                        .termsOfService("http://www.termsofservice.url")
                        .contact(descriptionContact())
                        .license(descriptionLincense()));
    }

    private Contact descriptionContact() {
        return new Contact()
                .name("Anderson Orione Aristides")
                .email("aoaristides@gmail.com")
                .url("https://www.makersweb.com.br");
    }

    private License descriptionLincense() {
        return new License()
                .name("License")
                .url("http://www.license.url");
    }

}
