package kg.orderservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq",
            allocationSize = 1, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    private Long userId;
    private Long orderId;
}
