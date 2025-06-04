package edu.bo.uyunicode.template;

import edu.bo.uyunicode.template.infrastructure.adapter.output.persistence.entity.UserEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TemplateApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<UserEntity> entities = Arrays.asList(
                new UserEntity(null, "pruebas", "test", true),
                new UserEntity(null, "pruebas1", "test5", true),
                new UserEntity(null, "pruebas2", "test6", true),
                new UserEntity(null, "pruebas3", "test7Z", true)
        );
    }
}
