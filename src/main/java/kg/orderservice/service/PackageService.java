package kg.orderservice.service;

import kg.orderservice.dto.request.PackageRequest;
import kg.orderservice.entities.Package;

public interface PackageService {
    Package save(PackageRequest packageRequest);
}
