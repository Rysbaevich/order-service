package kg.orderservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @SequenceGenerator(name = "order_gen", sequenceName = "order_seq",
            allocationSize = 1, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_gen")
    private Long id;
    private String whereFrom;
    private String whereTo;
}
