package com.cafe_kiosk.kiosk_user.dto;

import com.cafe_kiosk.kiosk_user.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Long categoryId;
    private String name;
    private String description;

    public static CategoryDTO entityToDto(Category entity) {
        return CategoryDTO.builder()
                .categoryId(entity.getCategoryId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }

    public Category dtoToEntity() {
        return Category.builder()
                .categoryId(categoryId)
                .name(name)
                .description(description)
                .build();
    }
}