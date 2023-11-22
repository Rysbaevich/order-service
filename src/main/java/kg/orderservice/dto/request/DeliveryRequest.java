package kg.orderservice.dto.request;

import kg.orderservice.enums.DeliveryType;

public record DeliveryRequest (

        DeliveryType deliveryType,
        String description,
        PackageRequest packageRequest

){
}
