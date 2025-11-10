package dz.corepulse.projectflow.coreApp.repository;


import dz.corepulse.projectflow.coreApp.model.entity.Epic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpicRepo extends JpaRepository<Epic,Long > {
}

