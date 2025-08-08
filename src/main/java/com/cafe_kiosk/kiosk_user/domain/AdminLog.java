package com.cafe_kiosk.kiosk_user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name = "admin_log")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminLog{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adminId", nullable = false)
    private Admin admin;

    @Column(length = 50)
    private String actionType;

    @Column(length = 50)
    private String targetTable;
    @Column(length = 50)
    private String targetId;

    private String description;

    private LocalDateTime createdAt;
}
