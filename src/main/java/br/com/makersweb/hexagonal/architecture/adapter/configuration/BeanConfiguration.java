package br.com.makersweb.hexagonal.architecture.adapter.configuration;

import br.com.makersweb.hexagonal.architecture.PocPortsAndAdaptersArchitectureApplication;
import br.com.makersweb.hexagonal.architecture.application.core.service.PersonServiceImpl;
import br.com.makersweb.hexagonal.architecture.application.ports.out.PersonDatabasePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author aaristides
 */
@Configuration
@ComponentScan(basePackageClasses = PocPortsAndAdaptersArchitectureApplication.class)
public class BeanConfiguration {

    @Bean
    PersonServiceImpl personServiceImpl(PersonDatabasePort personDatabasePort) {
        return new PersonServiceImpl(personDatabasePort);
    }

}
