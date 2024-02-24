package hello.itemservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity //테이블이랑 같이 매핑이 되서 관리됨
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="item_name",length=10)
    private String itemName;
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
