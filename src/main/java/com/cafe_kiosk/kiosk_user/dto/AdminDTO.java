package com.cafe_kiosk.kiosk_user.dto;


import com.cafe_kiosk.kiosk_user.domain.Admin;
import com.cafe_kiosk.kiosk_user.domain.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO extends BaseEntityDTO {

    private String adminId;
    private String adminPw;
    private AdminRole adminRole;
    // 엔티티 → DTO
    public static AdminDTO entityToDto(Admin admin) {
        return AdminDTO.builder()
                .adminId(admin.getAdminId())
                .adminPw(admin.getAdminPw())
                .adminRole(admin.getAdminRole())
                .build();
    }

    // DTO → 엔티티
    public Admin dtoToEntity() {
        return Admin.builder()
                .adminId(adminId)
                .adminPw(adminPw)
                .adminRole(adminRole)
                .build();
    }
}
