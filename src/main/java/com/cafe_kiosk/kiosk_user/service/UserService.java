package com.cafe_kiosk.kiosk_user.service;

import com.cafe_kiosk.kiosk_user.domain.User;
import com.cafe_kiosk.kiosk_user.dto.UserDTO;
import com.cafe_kiosk.kiosk_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public UserDTO getUser(String phone) {
        User user = userRepository.findByPhone(phone);
        return UserDTO.entityToDto(user);
    }

    public UserDTO findOrCreateUserByPhone(String phone) {
        User user = userRepository.findByPhone(phone);

        if (user == null) {
            user = new User();
            user.setPhone(phone);
            user.setPoints(100L);
            user = userRepository.save(user);
        }

        return UserDTO.entityToDto(user);
    }

    public void userSave(UserDTO userDTO) {
        User user = User.builder()
                .userId(userDTO.getUserId())
                .phone(userDTO.getPhone())
                .points(userDTO.getPoints())
                .build();
        userRepository.save(user);
    }
}
