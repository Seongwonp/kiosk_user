package com.cafe_kiosk.kiosk_user.service;

import com.cafe_kiosk.kiosk_user.dto.*;
import com.cafe_kiosk.kiosk_user.repository.CartRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Log4j2
@SpringBootTest
class MainServiceImplTest {
    @Autowired
    private MenuService menuService;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CartRepository cartRepository;

    @Test
    void getAllCategories() {
        List<CategoryDTO> categoryDTOs = categoryService.getAllCategories();
        categoryDTOs.forEach(System.out::println);
    }
    @Test
    void getMenusByCategory() {
        Long categoryId = 1L;  // 테스트용 카테고리 ID를 넣으세요.
        List<MenuDTO> menuDTOs = menuService.getMenusByCategory(categoryId);
        menuDTOs.forEach(System.out::println);
    }
    @Test
    void getMenuDetail() {
        Long menuId = 1L;  // 실제 DB에 존재하는 메뉴 ID
        MenuDTO menuDTO = menuService.getMenu(menuId);
        System.out.println(menuDTO);
    }
    @Test
    void getOptionsForMenu() {
        Long categoryId = 1L; // 실제 존재하는 메뉴 ID
        List<MenuOptionDTO> options = menuService.getOptions(categoryId);
        options.forEach(System.out::println);
    }

    @Test
    void addToCartTest() {
            AddCartRequest request = new AddCartRequest();
            request.setMenuId(3L);
            request.setQuantity(1L);

            // 1. 옵션 없는 경우
            request.setOptions(null); // 또는 new String[0]
            CartDTO noOptionAdd = cartService.addToCart(request);
            System.out.println("옵션 없음 추가: " + noOptionAdd);

            // 2. 옵션이 있는 경우
        String[] options = {"1","2"};
            request.setOptions(options);
            request.setQuantity(2L);

            // 이 부분도 List<CartDTO>로 바꾸는 게 적절
            CartDTO withOptionAdd = cartService.addToCart(request);
            System.out.println("옵션 있음 추가: " + withOptionAdd);
    }

    @Test
    void getCartItemsTest() {
        List<CartDTO> cartDTOS = cartService.getCartItems();
        cartDTOS.forEach(System.out::println);
    }

    @Test
    void removeCartItemTest() {
        Long cartId = 5L;
        cartService.removeCartItem(cartId);
    }

    @Test
    void clearCartTest() {
        cartService.clearCart();
    }

    @Test
    void getOrdersTest() {
        Long orderId = 1L;
        OrdersDTO ordersDTO = orderService.getOrder(orderId);
    }

    @Test
    void getUsersTest() {
        String phone = "01011112222";
        log.info(userService.getUser(phone));
    }
}