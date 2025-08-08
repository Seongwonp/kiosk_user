package com.cafe_kiosk.kiosk_user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @Column(length = 20)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menuId", nullable = false)
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "optionId")
    private MenuOption option;

    private String options;

    private String itemId;

    public String[] getOptions() {
        if (options == null || options.isEmpty()) {
            return new String[0];
        }
        return options.split(",");
    }

    public void setOptions(String[] optionsArray) {
        if (optionsArray == null || optionsArray.length == 0) {
            this.options = "";
        } else {
            this.options = String.join(",", optionsArray);
        }
    }

    @Column(nullable = false)
    private Long quantity = 1L;

    private String sessionId; //추가
}
