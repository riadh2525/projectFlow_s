package dz.corepulse.projectflow.coreApp.repository;

import dz.corepulse.projectflow.coreApp.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo  extends JpaRepository<Task, Long> {
    //
}
