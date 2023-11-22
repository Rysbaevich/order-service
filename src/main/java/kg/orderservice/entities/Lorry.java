package kg.orderservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import kg.orderservice.enums.LorryBodyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lorry extends Delivery {
    @Enumerated(EnumType.STRING)
    private LorryBodyType lorryBodyType;
    private String description;
    private Double length;
    private Double height;
    private Double width;
}
