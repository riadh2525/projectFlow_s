package dz.corepulse.projectflow.coreApp.repository;

import dz.corepulse.projectflow.coreApp.model.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepo extends JpaRepository<Sprint, Long> {
    //
}
