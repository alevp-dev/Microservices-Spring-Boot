package storeOnline.SpringBoot.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI storeOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Tienda Online")
                        .description("API REST para gestionar una tienda online")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Tu Nombre")
                                .email("tu@email.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}