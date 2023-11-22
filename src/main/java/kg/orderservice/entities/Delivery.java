package kg.orderservice.entities;

import jakarta.persistence.*;
import kg.orderservice.enums.DeliveryType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "deliveries")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Delivery {
    @Id
    @SequenceGenerator(name = "delivery_gen", sequenceName = "delivery_seq",
            allocationSize = 1, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_gen")
    private Long id;
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders;

    public void addOrder (Order order){
        if (orders == null){
            orders = new ArrayList<>();
            orders.add(order);
        } else orders.add(order);
    }
}
