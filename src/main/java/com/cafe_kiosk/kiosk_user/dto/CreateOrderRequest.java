package com.cafe_kiosk.kiosk_user.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {
    private String phone;
    private List<CartDTO> cartItems;
    private String orderMethod; // 예: "kiosk", "app" 등
}

