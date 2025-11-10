package dz.corepulse.projectflow.repository;

import dz.corepulse.projectflow.model.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepo extends JpaRepository<Story,Long> {
}
