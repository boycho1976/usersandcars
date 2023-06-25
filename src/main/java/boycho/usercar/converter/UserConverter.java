package boycho.usercar.converter;

import boycho.usercar.dto.UserRequest;
import boycho.usercar.dto.UserResponse;
import boycho.usercar.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public User toUser(UserRequest request){
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }
    public UserResponse toResponse(User user){
        return UserResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }

}
