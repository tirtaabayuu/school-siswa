package com.schoolsiswa.schoolsiswa.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConfigSwagger {
    @Value("${tirtabayu.openapi.dev-url}")
    private String devUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("tirta_bayu_teknokrat.ac.id");
        contact.setName("Tirta Bayu Nugroho");


        Info info = new Info()
                .title("School Siswa API")
                .version("1.0")
                .contact(contact)
                .description("OpenAPI for School Siswa RESTful API");

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
