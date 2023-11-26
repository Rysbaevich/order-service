package kg.orderservice.controller;

import kg.orderservice.dto.request.DeliveryByCarRequest;
import kg.orderservice.dto.request.DeliveryByLorryRequest;
import kg.orderservice.dto.request.DeliveryByPlaneRequest;
import kg.orderservice.dto.response.SimpleResponse;
import kg.orderservice.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order/delivery")
public class DeliveryController {
    private final DeliveryService deliveryService;

    @PostMapping("/car")
    public SimpleResponse save(@RequestBody DeliveryByCarRequest deliveryByCarRequest){
        return deliveryService.save(deliveryByCarRequest);
    }
    @PostMapping("/plane")
    public SimpleResponse save(@RequestBody DeliveryByPlaneRequest deliveryByPlaneRequest){
        return deliveryService.save(deliveryByPlaneRequest);
    }
    @PostMapping("/lorry")
    public SimpleResponse save(@RequestBody DeliveryByLorryRequest deliveryByLorryRequest){
        return deliveryService.save(deliveryByLorryRequest);
    }

}
