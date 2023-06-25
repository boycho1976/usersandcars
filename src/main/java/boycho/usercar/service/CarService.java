package boycho.usercar.service;

import boycho.usercar.dto.CarRequest;
import boycho.usercar.entity.Car;
import org.springframework.stereotype.Service;

@Service
public interface CarService {
    Car addCar(CarRequest request);
    Car getCar(Long id);
    String deleteCar(Long id);
}
