package dev.siqueira.financecontrol_sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FinanceControlSbApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceControlSbApplication.class, args);
    }

}
