package com.cafe_kiosk.kiosk_user.controller;

import com.cafe_kiosk.kiosk_user.dto.CategoryDTO;
import com.cafe_kiosk.kiosk_user.dto.MenuDTO;
import com.cafe_kiosk.kiosk_user.dto.MenuOptionDTO;
import com.cafe_kiosk.kiosk_user.service.CartService;
import com.cafe_kiosk.kiosk_user.service.CategoryService;
import com.cafe_kiosk.kiosk_user.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")  // React 앱 주소 허용
@RequestMapping("/api/menus")
public class MenuController {
    private final MenuService menuService;
    private final CategoryService categoryService;

    @Operation(summary = "카테고리")
    @GetMapping(value = "/category")
    public List<CategoryDTO> getCategories() {
        log.info("getCategories");
        List<CategoryDTO> categories = categoryService.getAllCategories();
        return categories;
    }
    @Operation(summary = "모든 메뉴")
    @GetMapping(value="/all")
    public Map<String, Object> findAll() {
        log.info("findAll");
        List<MenuDTO> menus = menuService.allMenus();
        List<MenuOptionDTO> options = menuService.getOptionsNotDeleted();

        Map<String, Object> result = new HashMap<>();
        result.put("menus", menus);
        result.put("options", options);

        return result;
    }

    @Operation(summary = "메뉴 상세옵션")
    @GetMapping(value = "/{category_id}")
    public List<MenuOptionDTO> getMenuOption(@PathVariable Long category_id) {
        List<MenuOptionDTO> optionDTOS = menuService.getOptions(category_id);
        return optionDTOS;
    }
    // 메뉴 재고 조회 API
    @GetMapping("/{menuId}/stock")
    public ResponseEntity<Map<String, Object>> getMenuStock(@PathVariable Long menuId) {
        int stock = menuService.getMenuStockById(menuId);
        Map<String, Object> response = new HashMap<>();
        response.put("menuId", menuId);
        response.put("stock", stock);
        return ResponseEntity.ok(response);
    }

}
