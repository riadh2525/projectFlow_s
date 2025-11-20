package dz.corepulse.projectflow.coreApp.repository;

import dz.corepulse.projectflow.coreApp.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {
    //
}
