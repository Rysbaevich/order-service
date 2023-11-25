package kg.orderservice.controller;

import kg.orderservice.dto.request.DeliveryByCarRequest;
import kg.orderservice.dto.request.DeliveryByLorryRequest;
import kg.orderservice.dto.request.DeliveryByPlaneRequest;
import kg.orderservice.dto.response.SimpleResponse;
import kg.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/delivery_car")
    public SimpleResponse save(@RequestBody DeliveryByCarRequest deliveryByCarRequest){
        return orderService.save(deliveryByCarRequest);
    }
    @PostMapping("/delivery_plane")
    public SimpleResponse save(@RequestBody DeliveryByPlaneRequest deliveryByPlaneRequest){
        return orderService.save(deliveryByPlaneRequest);
    }
    @PostMapping("/delivery_lorry")
    public SimpleResponse save(@RequestBody DeliveryByLorryRequest deliveryByLorryRequest){
        return orderService.save(deliveryByLorryRequest);
    }

}
