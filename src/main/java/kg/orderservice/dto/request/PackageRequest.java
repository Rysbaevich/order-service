package kg.orderservice.dto.request;

import kg.orderservice.enums.PackageType;

public record PackageRequest (
        PackageType packageType,
        Double weight,
        String size,
        String format,
        String other
){
}
