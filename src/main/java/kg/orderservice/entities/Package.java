package kg.orderservice.entities;

import jakarta.persistence.*;
import kg.orderservice.enums.PackageType;
import lombok.*;

@Entity
@Table(name = "packages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Package {
    @Id
    @SequenceGenerator(name = "package_gen", sequenceName = "package_seq",
            allocationSize = 1, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "package_gen")
    private Long id;
    @Enumerated(EnumType.STRING)
    private PackageType packageType;
    private Double weight;
    private String size;
    private String format;
    private String other;

}
