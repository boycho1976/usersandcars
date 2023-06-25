package boycho.usercar.service;

import boycho.usercar.dto.UpdateUserRequwst;
import boycho.usercar.dto.UserRequest;
import boycho.usercar.dto.UserResponse;
import boycho.usercar.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponse saveUser(UserRequest request);
    UserResponse getUser(Long id);

    String deleteUser(long id);

    UserResponse updateUser(Long id, UpdateUserRequwst request);
}
