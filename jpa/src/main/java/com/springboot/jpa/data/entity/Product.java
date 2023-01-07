package com.springboot.jpa.data.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "name")
@EqualsAndHashCode(callSuper = false)
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    public String toString(){
        return "Product(number=" + this.getNumber() + ", name =" + this.getName() + ", price = " +
                this.getPrice() + ", stock=" + this.getStock() + ", createdAt=" + this.getCreateAt() + ", updateAt=" + this.getUpdateAt() + ")";
    }


}
