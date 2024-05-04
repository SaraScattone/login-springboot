package it.marconi.domains;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {
    
    @NotEmpty
    @Size(max = 30)
    private String nickname;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(max = 18)
    private String password;
}
