package kg.orderservice.service.impl;
import kg.orderservice.dto.request.DeliveryByCarRequest;
import kg.orderservice.dto.request.DeliveryByLorryRequest;
import kg.orderservice.dto.request.DeliveryByPlaneRequest;
import kg.orderservice.dto.response.SimpleResponse;

import kg.orderservice.entities.Car;
import kg.orderservice.entities.Lorry;
import kg.orderservice.entities.Order;
import kg.orderservice.entities.Plane;
import kg.orderservice.enums.DeliveryType;
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

    private Order createOrder(String whereFrom, String where){
        Order order = new Order();
        order.setWhereFrom(whereFrom);
        order.setWhereTo(where);
        orderRepository.save(order);
        return order;
    }

    @Override
    public SimpleResponse save(DeliveryByCarRequest deliveryByCarRequest) { //todo with token
        Car car = new Car();
        car.setDeliveryType(DeliveryType.CAR);
        car.setAPackage(packageService.save(deliveryByCarRequest.packageRequest()));
        car.addOrder(createOrder(deliveryByCarRequest.whereFrom(), deliveryByCarRequest.where()));
        deliveryRepository.save(car);
        return new SimpleResponse(HttpStatus.OK, "Delivery by car successfully created");
    }

    @Override
    public SimpleResponse save(DeliveryByLorryRequest deliveryByLorryRequest) {//todo with token
        Lorry lorry = new Lorry();
        lorry.setDeliveryType(DeliveryType.LORRY);
        lorry.addOrder(createOrder(deliveryByLorryRequest.whereFrom(), deliveryByLorryRequest.where()));
        lorry.setWidth(deliveryByLorryRequest.width());
        lorry.setHeight(deliveryByLorryRequest.height());
        lorry.setLength(deliveryByLorryRequest.length());
        lorry.setLorryBodyType(deliveryByLorryRequest.bodyType());
        lorry.setDescription(deliveryByLorryRequest.description());
        deliveryRepository.save(lorry);
        return new SimpleResponse(HttpStatus.OK, "Delivery by lorry successfully created");
    }

    @Override
    public SimpleResponse save(DeliveryByPlaneRequest deliveryByPlaneRequest) {//todo with token
        Plane plane = new Plane();
        plane.setDeliveryType(DeliveryType.PLANE);
        plane.setDescription(deliveryByPlaneRequest.description());
        plane.addOrder(createOrder(deliveryByPlaneRequest.whereFrom(), deliveryByPlaneRequest.where()));
        deliveryRepository.save(plane);
        return new SimpleResponse(HttpStatus.OK, "Delivery by plane successfully created");
    }
}
