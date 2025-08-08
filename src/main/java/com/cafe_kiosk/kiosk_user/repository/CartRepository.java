package com.cafe_kiosk.kiosk_user.repository;

import com.cafe_kiosk.kiosk_user.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByMenu_MenuIdAndOption_OptionId(Long menuId, Long optionId);
    List<Cart> findBySessionId(String sessionId);
    @Transactional
    void deleteBySessionId(String sessionId); //장바구니에 담은 sessionId 삭제

    void deleteByItemId(String cartItemId);

    Optional<Cart> findByItemId(String cartItemId);
}