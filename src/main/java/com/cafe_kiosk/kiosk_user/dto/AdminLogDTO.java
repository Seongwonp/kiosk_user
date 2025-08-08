package com.cafe_kiosk.kiosk_user.dto;

import com.cafe_kiosk.kiosk_user.domain.AdminLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminLogDTO extends BaseEntityDTO {
    private Long logId;
    private AdminDTO admin;
    private String actionType;
    private String targetTable;
    private String targetId;

    public static AdminLogDTO entityToDto(AdminLog adminLog) {
        return AdminLogDTO.builder()
                .logId(adminLog.getLogId())
                .admin(AdminDTO.entityToDto(adminLog.getAdmin()))
                .actionType(adminLog.getActionType())
                .targetTable(adminLog.getTargetTable())
                .targetId(adminLog.getTargetId())
                .build();
    }

    public AdminLog dtoToEntity() {
        return AdminLog.builder()
                .logId(logId)
                .admin(admin.dtoToEntity())
                .actionType(actionType)
                .targetTable(targetTable)
                .targetId(targetId)
                .build();
    }

}
