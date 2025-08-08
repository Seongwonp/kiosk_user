package com.cafe_kiosk.kiosk_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KioskUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(KioskUserApplication.class, args);
    }

}
