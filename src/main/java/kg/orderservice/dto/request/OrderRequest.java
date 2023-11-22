package kg.orderservice.dto.request;

import java.time.LocalDate;

public record OrderRequest (
       String whereFrom,
       String where,
       LocalDate shippingDate,
       LocalDate arriveDate,
       DeliveryRequest deliveryRequest
       ){
}
