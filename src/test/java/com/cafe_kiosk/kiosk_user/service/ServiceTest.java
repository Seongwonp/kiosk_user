package com.cafe_kiosk.kiosk_user.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
class ServiceTest {
    @Autowired
    private SmsService messageService;

    @Test
    void sendMessage() {
        messageService.sendSms("01033392545", "Hello World");
    }

}