package kg.orderservice.service;

import kg.orderservice.dto.request.OrderRequest;
import kg.orderservice.dto.response.SimpleResponse;

public interface OrderService {
    SimpleResponse save(OrderRequest orderRequest);
}
