package dz.corepulse.projectflow.repository;


import dz.corepulse.projectflow.model.entity.Epic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpicRepo extends JpaRepository<Epic,Long > {
}

