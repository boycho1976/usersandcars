package boycho.usercar.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserResponse {
    private String firstName;
    private String lastName;
    private String email;
}
