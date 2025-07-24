package userapi.models.rest;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDTO {
    @NotBlank
    private String fio;
    @NotBlank
    private String phoneNumber;
    private String avatar;
    @NotBlank
    private String roleName;
}

