package com.cafe_kiosk.kiosk_user.dto;

import com.cafe_kiosk.kiosk_user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseEntityDTO {

    private Long userId;
    private String phone;
    private Long points;

    // Entity → DTO
    public static UserDTO entityToDto(User user) {
        return UserDTO.builder()
                .userId(user.getUserId())
                .phone(user.getPhone())
                .points(user.getPoints() != null ? user.getPoints() : 0L)
                .build();
    }
    // DTO → Entity
    public User dtoToEntity() {
        return User.builder()
                .userId(userId)
                .phone(phone)
                .points(points)
                .build();
    }


}
