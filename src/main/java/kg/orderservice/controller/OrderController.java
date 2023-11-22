package kg.orderservice.controller;

import kg.orderservice.dto.request.OrderRequest;
import kg.orderservice.dto.response.SimpleResponse;
import kg.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public SimpleResponse save(@RequestBody OrderRequest orderRequest){
        return orderService.save(orderRequest);
    }

}
