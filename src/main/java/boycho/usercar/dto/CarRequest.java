package boycho.usercar.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarRequest {
    @NotBlank
    private Long userId;
    @NotBlank
    private String made;
    @NotBlank
    private String model;
    @NotBlank
    private String vin;
    @NotBlank
    private String number;
}
