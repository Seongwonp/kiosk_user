package com.cafe_kiosk.kiosk_user.service;

import jakarta.annotation.PostConstruct;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    private DefaultMessageService messageService;
    @Value("${com.tjfgusdh.nurigo.apiKey}")
    private String apiKey;
    @Value("${com.tjfgusdh.nurigo.apiSecretKey}")
    private String apiSecretKey;
    @Value("${com.tjfgusdh.nurigo.domain}")
    private String domain;
    @Value("${com.tjfgusdh.nurigo.from}")
    private String from;

    // 초기화 메서드
    @PostConstruct
    public void init() {
        this.messageService = new DefaultMessageService(apiKey, apiSecretKey, domain);
    }

    // 메시지 전송 메서드
    public SingleMessageSentResponse sendSms(String to, String text) {
        Message message = new Message();
        message.setFrom(from); // 발신자 번호
        message.setTo(to);     // 수신자 번호
        message.setText(text); // 메시지 내용

        return this.messageService.sendOne(new SingleMessageSendingRequest(message));
    }
}
