package boycho.usercar.controller;

import boycho.usercar.dto.UpdateUserRequwst;
import boycho.usercar.dto.UserRequest;
import boycho.usercar.dto.UserResponse;
import boycho.usercar.entity.Car;
import boycho.usercar.entity.User;
import boycho.usercar.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserRequest request){
        UserResponse response = userService.saveUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findUserById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.getUser(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.deleteUser(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id,
                                                   @RequestBody UpdateUserRequwst request){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateUser(id,request));
    }
}
