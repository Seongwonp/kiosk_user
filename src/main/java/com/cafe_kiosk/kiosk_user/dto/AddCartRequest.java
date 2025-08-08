package com.cafe_kiosk.kiosk_user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCartRequest {
    private String phone;
    private Long menuId;       // 메뉴 ID
    private String[] options;  // 옵션 ID 배열 (nullable)
    private Long quantity;      // 수량
    public String sessionId; //추가
    public String itemId;


//    // 콤마로 구분된 옵션 문자열을 배열로 설정
//    public void setOptions(String optionsString) {
//        if (optionsString == null || optionsString.trim().isEmpty()) {
//            this.options = new String[0];
//        } else {
//            this.options = optionsString.split(",");
//        }
//    }
}
