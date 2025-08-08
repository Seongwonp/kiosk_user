package com.cafe_kiosk.kiosk_user.controller;

import com.cafe_kiosk.kiosk_user.domain.OrderItem;
import com.cafe_kiosk.kiosk_user.domain.OrderStatus;
import com.cafe_kiosk.kiosk_user.domain.Orders;
import com.cafe_kiosk.kiosk_user.dto.CartDTO;
import com.cafe_kiosk.kiosk_user.dto.OrderItemDTO;
import com.cafe_kiosk.kiosk_user.dto.OrdersDTO;
import com.cafe_kiosk.kiosk_user.dto.UserDTO;
import com.cafe_kiosk.kiosk_user.repository.OrderItemRepository;
import com.cafe_kiosk.kiosk_user.service.CartService;
import com.cafe_kiosk.kiosk_user.service.MenuService;
import com.cafe_kiosk.kiosk_user.service.OrderService;
import com.cafe_kiosk.kiosk_user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;
    private final CartService cartService;
    private final OrderItemRepository orderItemRepository;
    private final MenuService menuService;


    @PostMapping("/")
    public ResponseEntity<Map<String,Object>> createOrder(@RequestBody OrdersDTO ordersDTO){
        String orderId = UUID.randomUUID().toString();// toss 전용 주문번호 생성
        // 1) 전화번호로 유저 조회 또는 생성
        UserDTO userDTO = userService.findOrCreateUserByPhone(ordersDTO.getPhone());

        Long totalAmount = ordersDTO.getTotalAmount();
        if (totalAmount == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "totalAmount is required"));
        }
        long earnedPoint = (long)(totalAmount * 0.05);
        ordersDTO.setTossOrderId(orderId);

        List<CartDTO> carts = cartService.getCartItems();
        List<OrderItemDTO> orderItems = new ArrayList<>();

        userService.userSave(userDTO);

        ordersDTO.setStatus(OrderStatus.WAITING);
        Orders savedOrder = orderService.orderSave(ordersDTO); // 엔티티 저장 및 반환

        carts.forEach(cart -> {
            OrderItemDTO item = new OrderItemDTO();
            item.setOrder(OrdersDTO.entityToDto(savedOrder)); // 엔티티 넣기! DTO 아님!
            item.setQuantity(cart.getQuantity());
            item.setMenu(cart.getMenu());
            item.setOption(cart.getOption());
            String[] intOptions = cart.getOptions();
            String a;
            if (intOptions == null || intOptions.length == 0) {
                a = "";
            } else {
                a = String.join(",", intOptions);
            }

            item.setPrice(savedOrder.getTotalAmount());
            item.setOptions(a);
            OrderItem entity = item.dtoToEntity(); // now it's safe
            orderItemRepository.save(entity);      // DB 저장 OK
        });

        // 제대로 저장

        Map<String,Object> response = new HashMap<>();
        response.put("orderId", orderId);


        System.out.println("DTO 값: " + ordersDTO);
        System.out.println("DTO 값: " + userDTO);
        System.out.println("earnedPoint 계산 값: " + (ordersDTO.getTotalAmount() * 0.05));
        System.out.println("orderStatus: " + ordersDTO.getStatus());

        return ResponseEntity.ok(response);
    }


    @GetMapping("/points")
    public ResponseEntity<Map<String, Object>> getUserPoints(@RequestParam String phone) {
        UserDTO userDTO = userService.findOrCreateUserByPhone(phone);

        if (userDTO != null) {
            return ResponseEntity.ok(Map.of("points", userDTO.getPoints()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("points", 0));
        }
    }

}
