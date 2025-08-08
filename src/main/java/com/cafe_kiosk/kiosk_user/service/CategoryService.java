package com.cafe_kiosk.kiosk_user.service;

import com.cafe_kiosk.kiosk_user.dto.CategoryDTO;
import com.cafe_kiosk.kiosk_user.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    // 1. 카테고리 전체 조회
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDTO::entityToDto)
                .collect(Collectors.toList());
    }
}
