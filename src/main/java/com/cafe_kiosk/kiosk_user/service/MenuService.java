package com.cafe_kiosk.kiosk_user.service;

import com.cafe_kiosk.kiosk_user.domain.Cart;
import com.cafe_kiosk.kiosk_user.domain.Menu;
import com.cafe_kiosk.kiosk_user.dto.CartDTO;
import com.cafe_kiosk.kiosk_user.dto.MenuDTO;
import com.cafe_kiosk.kiosk_user.dto.MenuOptionDTO;
import com.cafe_kiosk.kiosk_user.repository.MenuOptionRepository;
import com.cafe_kiosk.kiosk_user.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    private final MenuOptionRepository menuOptionRepository;
    private final CartService cartService;

    public List<MenuDTO> allMenus() {
        return menuRepository.findAll()
                .stream()
                .map(MenuDTO::entityToDto)
                .collect(Collectors.toList());
    }
    // 2. 카테고리별 메뉴 조회
    public List<MenuDTO> getMenusByCategory(Long categoryId) {
        return menuRepository.findByCategory_CategoryId(categoryId)
                .stream()
                .map(MenuDTO::entityToDto)
                .collect(Collectors.toList());
    }
    // 3. 메뉴 상세 조회
    public MenuDTO getMenu(Long menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
        return MenuDTO.entityToDto(menu);
    }
    // 4. 메뉴 옵션 조회
    public List<MenuOptionDTO> getOptions(Long categoryId) {
        return menuOptionRepository.findByCategory_CategoryId(categoryId)
                .stream()
                .map(MenuOptionDTO::entityToDto)
                .collect(Collectors.toList());
    }
    public List<MenuOptionDTO> getAllOptions() {
        return menuOptionRepository.findAll()
                .stream()
                .map(MenuOptionDTO::entityToDto)
                .collect(Collectors.toList());
    }
    public List<MenuOptionDTO> getOptionsNotDeleted() {
        return menuOptionRepository.findByIsDeleted(false)
                .stream()
                .map(MenuOptionDTO::entityToDto)
                .collect(Collectors.toList());
    }

    // 주문 완료 시 수량 차감
    public void menuStockMinus() {
        List<CartDTO> cartDTOS = cartService.getCartItems();
        for (CartDTO cartDTO : cartDTOS) {
            Cart cart = cartDTO.dtoToEntity();
            Menu menu = cart.getMenu();
            Long newStock = menu.getStock() - cartDTO.getQuantity();
            menu.setStock(newStock);
            if (menu.getStock() <= 0) {
                menu.setIsSoldOut(true);
            }
            menuRepository.save(menu); // DB에 재고 반영
        }
    }

    public int getMenuStockById(Long menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
        return menu.getStock().intValue();
    }
}