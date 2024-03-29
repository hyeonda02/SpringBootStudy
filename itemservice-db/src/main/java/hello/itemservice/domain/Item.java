package hello.itemservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity //테이블이랑 같이 매핑이 되서 관리됨
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="item_name",length=10) //DB item_name 컬럼이랑 매핑됨
    private String itemName; //컬럼 명이 객체 명이랑 같다면 생략 가능
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
