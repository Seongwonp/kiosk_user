package com.cafe_kiosk.kiosk_user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends BaseEntity{

    @Id
    @Column(length = 20)
    private String adminId;

    @Column(length = 100)
    private String adminPw;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private AdminRole adminRole;
}
