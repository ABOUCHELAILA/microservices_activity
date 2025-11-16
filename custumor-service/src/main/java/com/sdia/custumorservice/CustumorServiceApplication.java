package com.sdia.custumorservice;

import com.sdia.custumorservice.config.CustumorConfigParams;
import com.sdia.custumorservice.entities.custumor;
import com.sdia.custumorservice.repository.custumorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
@EnableConfigurationProperties(CustumorConfigParams.class)
@SpringBootApplication
public class CustumorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustumorServiceApplication.class, args);
    }






    @Bean
    CommandLineRunner init(custumorRepository custumorRepository) {
        return args -> {

            custumorRepository.save(custumor.builder()
                    .name("laila").email("abouchelaila@")
                    .build());


            custumorRepository.save(custumor.builder()
                    .name("ihssane").email("ihssaneab@")
                    .build());

            custumorRepository.save(custumor.builder()
                    .name("mohamed").email("mohamed@")
                    .build());
            custumorRepository.findAll().forEach(c -> {
                System.out.println("____________________");
                System.out.println("name: " + c.getName());
                System.out.println("email: " + c.getEmail());
                System.out.println("____________________");
            });
        };
    }
}
