package spring.buddy.projects.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.buddy.projects.management.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
