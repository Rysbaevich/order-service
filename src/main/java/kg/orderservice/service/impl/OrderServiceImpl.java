package kg.orderservice.service.impl;
import kg.orderservice.dto.request.OrderRequest;
import kg.orderservice.dto.response.SimpleResponse;

import kg.orderservice.entities.Car;
import kg.orderservice.entities.Order;
import kg.orderservice.repository.DeliveryRepository;
import kg.orderservice.repository.OrderRepository;
import kg.orderservice.service.OrderService;
import kg.orderservice.service.PackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final DeliveryRepository deliveryRepository;
    private final PackageService packageService;
    private final OrderRepository orderRepository;

    @Override
    public SimpleResponse save(OrderRequest orderRequest) {

        Order order = new Order();
        order.setWhereFrom(orderRequest.whereFrom());
        order.setWhereTo(orderRequest.where());
        orderRepository.save(order);
        deliveryRepository.save(createCar(orderRequest, order));
        return new SimpleResponse(HttpStatus.OK, "order successfully saved!!");
    }

    private Car createCar(OrderRequest orderRequest, Order order){
        Car car = new Car();
        car.setAPackage(packageService.save(orderRequest.deliveryRequest().packageRequest()));
        car.setDeliveryType(orderRequest.deliveryRequest().deliveryType());
        car.addOrder(order);
        return car;
    }
}
