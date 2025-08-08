package com.cafe_kiosk.kiosk_user.controller;

import com.cafe_kiosk.kiosk_user.service.SmsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final SmsService smsService;

    @GetMapping("/send_sms")
    public void sendSmsGo(String to, String text) {
        log.info("sendSms called");
        smsService.sendSms(to, text);
    }
}
