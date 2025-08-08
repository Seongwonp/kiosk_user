package com.cafe_kiosk.kiosk_user.dto;

import com.cafe_kiosk.kiosk_user.domain.PointHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointHistoryDTO extends BaseEntityDTO {

    private Long pointHistoryId;
    private UserDTO user;
    private String phone;
    private OrdersDTO order;
    private Long amount;
    private String pointType;

    // Entity → DTO
    public static PointHistoryDTO entityToDto(PointHistory pointHistory) {
        return PointHistoryDTO.builder()
                .pointHistoryId(pointHistory.getPointHistoryId())
                .user(pointHistory.getUser() != null ? UserDTO.entityToDto(pointHistory.getUser()) : null)
                .phone(pointHistory.getPhone())
                .order(pointHistory.getOrder() != null ? OrdersDTO.entityToDto(pointHistory.getOrder()) : null)
                .amount(pointHistory.getAmount())
                .pointType(pointHistory.getPointType())
                .build();
    }

    // DTO → Entity
    public PointHistory dtoToEntity() {
        return PointHistory.builder()
                .pointHistoryId(pointHistoryId)
                .user(user != null ? user.dtoToEntity() : null)
                .phone(phone)
                .order(order != null ? order.dtoToEntity() : null)
                .amount(amount)
                .pointType(pointType)
                .build();
    }
}
