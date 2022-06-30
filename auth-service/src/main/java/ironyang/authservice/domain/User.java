package ironyang.authservice.domain;

import lombok.Data;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.persistence.Entity;

@Entity
@Data
public class User {
    private String email;
    private String password;
}
