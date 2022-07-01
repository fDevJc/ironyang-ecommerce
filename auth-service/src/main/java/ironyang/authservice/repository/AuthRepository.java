package ironyang.authservice.repository;

import ironyang.authservice.domain.User;

import java.util.Optional;

//public interface AuthRepository extends JpaRepository<User, Long> {
public interface AuthRepository {

    Optional<User> findByEmail(String email);
}
