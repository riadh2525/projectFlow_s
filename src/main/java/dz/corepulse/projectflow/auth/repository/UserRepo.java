package dz.corepulse.projectflow.auth.repository;

import dz.corepulse.projectflow.auth.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
