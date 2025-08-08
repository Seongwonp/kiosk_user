package com.cafe_kiosk.kiosk_user.dto;

import com.cafe_kiosk.kiosk_user.domain.OrderStatus;
import com.cafe_kiosk.kiosk_user.domain.Orders;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrdersDTO {
    private Long orderId; //주문 번호(프라이머리키)
    private String tossOrderId; //주문 번호(Toss 에 넘기는 고유 문자열 ID)
    private String phone;
    private LocalDateTime orderTime;
    private Long totalAmount;
    private OrderStatus status;
    private Long usedPoint = 0L;
    private Long earnedPoint = 0L;
    private String orderMethod;
    private String paymentKey;


    // Entity → DTO
    public static OrdersDTO entityToDto(Orders orders) {
        return OrdersDTO.builder()
                .orderId(orders.getOrderId())
                .tossOrderId(orders.getTossOrderId())
                .phone(orders.getPhone())
                .orderTime(orders.getOrderTime())
                .totalAmount(orders.getTotalAmount())
                .status(orders.getStatus())
                .usedPoint(orders.getUsedPoint())
                .earnedPoint(orders.getEarnedPoint())
                .orderMethod(orders.getOrderMethod())
                .paymentKey(orders.getPaymentKey())
                .build();
    }

    // DTO → Entity
    public Orders dtoToEntity() {
        return Orders.builder()
                .orderId(orderId)
                .tossOrderId(tossOrderId)
                .phone(phone)
                .orderTime(orderTime)
                .totalAmount(totalAmount)
                .status(status)
                .usedPoint(usedPoint)
                .earnedPoint(earnedPoint)
                .orderMethod(orderMethod)
                .paymentKey(paymentKey)
                .build();
    }
}
