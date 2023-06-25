package boycho.usercar.converter;

import boycho.usercar.dto.CarRequest;
import boycho.usercar.dto.UserResponse;
import boycho.usercar.entity.Car;
import boycho.usercar.entity.User;
import boycho.usercar.repository.CarRepository;
import boycho.usercar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {
    @Autowired
    UserRepository userRepository;
    public Car toCar(CarRequest request){
        User user = userRepository.findById(request.getUserId()).get();
        return Car.builder()
                .user(user)
                .model(request.getModel())
                .made(request.getMade())
                .vin(request.getVin())
                .number(request.getNumber())
                .build();


    }
}
