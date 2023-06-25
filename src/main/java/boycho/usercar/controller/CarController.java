package boycho.usercar.controller;

import boycho.usercar.dto.CarRequest;
import boycho.usercar.entity.Car;
import boycho.usercar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/car")
public class CarController {
    @Autowired
    CarService carService;
    @PostMapping("/register")
    public ResponseEntity<Car> registerCar( @RequestBody CarRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.addCar(request));

    }
    @GetMapping("/{id}")
    public ResponseEntity<Car> findCarByID(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(carService.getCar(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(carService.deleteCar(id));
    }
}
