package ironyang.ecommerce.repository;

import ironyang.ecommerce.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
