package kg.orderservice.dto.request;

import kg.orderservice.enums.LorryBodyType;

import java.time.LocalDate;

public record DeliveryByLorryRequest (
        String whereFrom,
        String where,
        LocalDate dispatchDate,
        LocalDate arrivalDate,
        LorryBodyType bodyType,
        Double length,
        Double height,
        Double width,
        String description
){
}
