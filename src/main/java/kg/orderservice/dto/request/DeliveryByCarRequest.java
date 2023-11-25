package kg.orderservice.dto.request;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record DeliveryByCarRequest(
        String whereFrom,
        String where,
        LocalDate dispatchDate,
        LocalDate arrivalDate,
        PackageRequest packageRequest


) {
}
