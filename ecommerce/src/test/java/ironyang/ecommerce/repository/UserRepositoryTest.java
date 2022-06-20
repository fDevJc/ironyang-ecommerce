package ironyang.ecommerce.repository;

import ironyang.ecommerce.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.util.ReflectionTestUtils;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Commit
class UserRepositoryTest {
    @Autowired
    EntityManager em;

    Long savedUserId;

    @BeforeEach
    void setUp() {
        User user = User.builder()
                .email("email@email.com")
                .password("password")
                .build();
        em.persist(user);
        savedUserId = user.getId();
    }

    @Test
    void baseEntityCreatedDateTest() {
        //given
        User foundUser = em.find(User.class, savedUserId);

        //when && then
        assertThat(foundUser.getCreatedDate()).isBefore(LocalDateTime.now());
    }

    @Test
    void baseEntityModifiedDateTest() {
        //given
        //when
        User updateUser = em.find(User.class, savedUserId);
        String changeEmail = "change@email.com";
        ReflectionTestUtils.setField(updateUser, "email", changeEmail);

        em.flush();
        em.clear();

        //then
        User foundUser = em.find(User.class, savedUserId);
        assertThat(foundUser.getEmail()).isEqualTo(changeEmail);
        assertThat(foundUser.getUpdatedDate()).isNotEqualTo(foundUser.getCreatedDate());
    }

}