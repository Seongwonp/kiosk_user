package com.cafe_kiosk.kiosk_user.dto;


import com.cafe_kiosk.kiosk_user.domain.Menu;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MenuDTO {

    private Long menuId;
    private CategoryDTO category;
    private String name;
    private Long price;
    private String imageUrl;
    private Long stock = 0L;
    private Boolean isSoldOut = false;
    private LocalDateTime createdAt;

    public static MenuDTO entityToDto(Menu menu) {
        return MenuDTO.builder()
                .menuId(menu.getMenuId())
                .category(CategoryDTO.entityToDto(menu.getCategory())) // Category → CategoryDTO
                .name(menu.getName())
                .price(menu.getPrice())
                .imageUrl(menu.getImageUrl())
                .stock(menu.getStock())
                .isSoldOut(menu.getIsSoldOut())
                .createdAt(menu.getCreatedAt())
                .build();
    }

    public Menu dtoToEntity() {
        return Menu.builder()
                .menuId(menuId)
                .category(category.dtoToEntity())
                .name(name)
                .price(price)
                .imageUrl(imageUrl)
                .stock(stock)
                .isSoldOut(isSoldOut)
                .build();
    }
}
