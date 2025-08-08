package com.cafe_kiosk.kiosk_user.service;

import com.cafe_kiosk.kiosk_user.domain.Cart;
import com.cafe_kiosk.kiosk_user.domain.Menu;
import com.cafe_kiosk.kiosk_user.dto.AddCartRequest;
import com.cafe_kiosk.kiosk_user.dto.CartDTO;
import com.cafe_kiosk.kiosk_user.dto.MenuDTO;
import com.cafe_kiosk.kiosk_user.repository.CartRepository;
import com.cafe_kiosk.kiosk_user.repository.MenuRepository;
import com.cafe_kiosk.kiosk_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final MenuRepository menuRepository;

    public void clearCartBySessionId(String sessionId) {
        cartRepository.deleteBySessionId(sessionId);
    }

    //5. 장바구니 아이템 추가
    public CartDTO addToCart(AddCartRequest request) {
        Menu menu = menuRepository.findById(request.getMenuId())
                .orElseThrow(() -> new RuntimeException("메뉴를 찾을 수 없습니다. ID: " + request.getMenuId()));

        if (request.getQuantity() <= 0) {
            throw new IllegalArgumentException("수량은 1 이상이어야 합니다.");
        }

        Cart cart = new Cart();
        cart.setSessionId(request.getSessionId()); // 추가: sessionId 저장
        cart.setMenu(menu);
        cart.setOptions(request.getOptions());  // String[] 배열 그대로 세팅
        cart.setQuantity(request.getQuantity());
        cart.setItemId(request.getItemId());
        cartRepository.save(cart);

        CartDTO dto = new CartDTO();
        dto.setCartId(cart.getCartId());
        dto.setSessionId(cart.getSessionId());
        dto.setMenu(MenuDTO.entityToDto(menu));
        dto.setOptions(cart.getOptions());
        dto.setQuantity(cart.getQuantity());
        dto.setItemId(cart.getItemId());

        return dto;
    }

    // 6. 장바구니 아이템 리스트 조회
    public List<CartDTO> getCartItems() {
        return cartRepository.findAll()
                .stream()
                .map(CartDTO::entityToDto)
                .collect(Collectors.toList());
    }

    // 7. 장바구니 아이템 수량 변경
    public void updateCartQuantity(String cartItemId, Long newQuantity) {
        if (newQuantity <= 0) {
            throw new IllegalArgumentException("수량은 1 이상이어야 합니다.");
        }
        Cart cartItem = cartRepository.findByItemId((cartItemId))
                .orElseThrow(() -> new IllegalArgumentException("장바구니 아이템을 찾을 수 없습니다."));
        cartItem.setQuantity(newQuantity);

        cartRepository.save(cartItem);
    }
    // 8. 장바구니 아이템 삭제
    public void removeCartItem(String cartItemId) {
        cartRepository.deleteByItemId(cartItemId);
    }

    // 9. 장바구니 전체 비우기
    public void clearCart() {
        cartRepository.deleteAll();
    }

}
