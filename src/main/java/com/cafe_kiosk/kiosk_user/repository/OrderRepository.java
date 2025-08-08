package com.cafe_kiosk.kiosk_user.repository;

import com.cafe_kiosk.kiosk_user.domain.OrderStatus;
import com.cafe_kiosk.kiosk_user.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.net.ssl.SSLSession;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<Orders, Long> {
    // 주문 상태 변경, 결제키 업데이트는 직접 쿼리로 처리
    @Modifying
    @Transactional
    @Query("UPDATE Orders o SET o.paymentKey = :paymentKey WHERE o.orderId = :orderId")
    void updatePaymentKey(@Param("orderId") Long orderId, @Param("paymentKey") String paymentKey);

    @Modifying
    @Transactional
    @Query("UPDATE Orders o SET o.status = :status WHERE o.orderId = :orderId")
    void updateOrderStatus(@Param("orderId") Long orderId, @Param("status") OrderStatus status);
    Orders findByOrderId(Long orderId);

    Optional<Orders> findByTossOrderId(String tossOrderId);

}