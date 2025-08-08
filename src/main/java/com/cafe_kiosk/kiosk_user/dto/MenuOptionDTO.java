package com.cafe_kiosk.kiosk_user.dto;

import com.cafe_kiosk.kiosk_user.domain.MenuOption;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuOptionDTO {

    private Long optionId;
    private CategoryDTO category;
    private String optionName;
    private Long optionPrice;
    private String optionType;

    // Entity → DTO
    public static MenuOptionDTO entityToDto(MenuOption menuOption) {
        return MenuOptionDTO.builder()
                .optionId(menuOption.getOptionId())
                .category(CategoryDTO.entityToDto(menuOption.getCategory()))
                .optionName(menuOption.getOptionName())
                .optionPrice(menuOption.getOptionPrice())
                .optionType(menuOption.getOptionType())
                .build();
    }

    // DTO → Entity
    public MenuOption dtoToEntity() {
        return MenuOption.builder()
                .optionId(optionId)
                .category(category.dtoToEntity())
                .optionName(optionName)
                .optionPrice(optionPrice)
                .optionType(optionType)
                .build();
    }
}