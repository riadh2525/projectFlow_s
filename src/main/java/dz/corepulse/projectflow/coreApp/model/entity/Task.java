package dz.corepulse.projectflow.coreApp.model.entity;

import dz.corepulse.projectflow.coreApp.model.enums.statuses.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Table(name = "task" ,schema = "core_app")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task extends AbstractEntity {

    @Column(name ="status")
    private TaskStatus status ;

    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story ;

    //Helper Methods
    public Boolean isSame(Task task) {
        if(!this.getName().equals(task.getName())) return false;
        if(!this.getDescription().equals(task.getDescription())) return false;
        if(this.getProgress() != task.getProgress()) return false;
        if(!this.getStatus().equals(task.getStatus())) return false;
        if(this.getStory().equals(task.getStory())) return false;
        return true;
    }
}
