package boycho.usercar.service.impl;

import boycho.usercar.converter.UserConverter;
import boycho.usercar.dto.UpdateUserRequwst;
import boycho.usercar.dto.UserRequest;
import boycho.usercar.dto.UserResponse;
import boycho.usercar.entity.User;
import boycho.usercar.repository.UserRepository;
import boycho.usercar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConverter userConverter;

    @Override
    public UserResponse saveUser(UserRequest request) {
        User user = userConverter.toUser(request);
        User saveduser = userRepository.save(user);
        return userConverter.toResponse(saveduser);
    }

    @Override
    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id).get();
        return userConverter.toResponse(user);
    }

    @Override
    public String deleteUser(long id) {
        userRepository.deleteById(id);
        return "Deleted user with id " + id;
    }

    @Override
    public UserResponse updateUser(Long id, UpdateUserRequwst request) {
        User user = userRepository.findById(id).get();

        if (request.getEmail() != null &&!request.getEmail().isBlank()) {
            user.setEmail(request.getEmail());
        }
        if (request.getPassword() != null &&!request.getPassword().isBlank()) {
            user.setPassword(request.getPassword());
        }

        return userConverter.toResponse(userRepository.save(user));
    }
}
