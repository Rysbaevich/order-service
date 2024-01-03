package kg.orderservice.dto.request;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record DeliveryByPlaneRequest(
        String whereFrom,
        String where,
        LocalDate shippingDate,
        LocalDate arriveDate,
        PackageRequest packageRequest,
        String description

) {
}
