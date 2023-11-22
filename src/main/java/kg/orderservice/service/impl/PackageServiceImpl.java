package kg.orderservice.service.impl;

import kg.orderservice.dto.request.PackageRequest;
import kg.orderservice.entities.Package;
import kg.orderservice.enums.PackageType;
import kg.orderservice.repository.PackageRepository;
import kg.orderservice.service.PackageService;
import org.springframework.stereotype.Service;

@Service
public class PackageServiceImpl implements PackageService {

    private final PackageRepository packageRepository;

    public PackageServiceImpl(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    @Override
    public Package save(PackageRequest packageRequest) {
        if (packageRequest.packageType().equals(PackageType.BOX)){
            return createBox(packageRequest);
        } else if (packageRequest.packageType().equals(PackageType.ENVELOP)){
            return createEnvelop(packageRequest);
        } else if (packageRequest.packageType().equals(PackageType.BAG)){
            return createBag(packageRequest);
        } return createOther(packageRequest);
    }

    private Package createBox(PackageRequest packageRequest){
        Package aPackage = new Package();
        aPackage.setPackageType(PackageType.BOX);
        aPackage.setSize(packageRequest.size());
        aPackage.setWeight(packageRequest.weight());
        packageRepository.save(aPackage);
        return aPackage;
    }

    private Package createEnvelop(PackageRequest packageRequest){
        Package aPackage = new Package();
        aPackage.setPackageType(PackageType.ENVELOP);
        aPackage.setFormat(packageRequest.format());
        aPackage.setWeight(packageRequest.weight());
        packageRepository.save(aPackage);
        return aPackage;
    }

    private Package createBag(PackageRequest packageRequest){
        Package aPackage = new Package();
        aPackage.setPackageType(PackageType.BAG);
        aPackage.setWeight(packageRequest.weight());
        packageRepository.save(aPackage);
        return aPackage;
    }

    private Package createOther(PackageRequest packageRequest){
        Package aPackage = new Package();
        aPackage.setPackageType(PackageType.OTHER);
        aPackage.setOther(packageRequest.other());
        packageRepository.save(aPackage);
        return aPackage;
    }
}
