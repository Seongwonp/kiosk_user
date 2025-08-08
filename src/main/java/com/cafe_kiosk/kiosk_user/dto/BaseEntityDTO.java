package com.cafe_kiosk.kiosk_user.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class BaseEntityDTO {
    private LocalDateTime modifiedAt;
    private LocalDateTime createdAt;
}
