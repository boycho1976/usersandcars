package boycho.usercar.service.impl;

import boycho.usercar.converter.CarConverter;
import boycho.usercar.dto.CarRequest;
import boycho.usercar.entity.Car;
import boycho.usercar.repository.CarRepository;
import boycho.usercar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarConverter carConverter;
    @Autowired
    public CarServiceImpl(CarRepository carRepository, CarConverter carConverter) {
        this.carRepository = carRepository;
        this.carConverter = carConverter;
    }


    @Override
    public Car addCar(CarRequest request) {
        Car car =carConverter.toCar(request);
        return carRepository.save(car);
    }

    @Override
    public Car getCar(Long id) {
        return carRepository.findById(id).get();
    }

    @Override
    public String deleteCar(Long id) {
        carRepository.deleteById(id);
        return "Deleted car with id " + id;
    }
}
