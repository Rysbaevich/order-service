package kg.orderservice.dto.request;

import kg.orderservice.enums.PackageType;
import lombok.Builder;

@Builder
public record PackageRequest (
        Double weight,
        String size,
        String format,
        String other,
        PackageType packageType
){
}
