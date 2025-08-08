package com.cafe_kiosk.kiosk_user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class messageDTO {
    private String from;
    private String to;
    private String text;

}
