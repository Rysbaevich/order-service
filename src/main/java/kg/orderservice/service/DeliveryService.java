package kg.orderservice.service;

import kg.orderservice.dto.request.DeliveryByCarRequest;
import kg.orderservice.dto.request.DeliveryByLorryRequest;
import kg.orderservice.dto.request.DeliveryByPlaneRequest;
import kg.orderservice.dto.response.SimpleResponse;

public interface DeliveryService {
    SimpleResponse save(DeliveryByCarRequest deliveryByCarRequest);
    SimpleResponse save(DeliveryByLorryRequest deliveryByLorryRequest);
    SimpleResponse save(DeliveryByPlaneRequest deliveryByPlaneRequest);
}
