package dz.corepulse.projectflow.coreApp.model.entity;

import dz.corepulse.projectflow.coreApp.model.enums.statuses.SprintStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sprint" ,schema="core_app")
@SuperBuilder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Sprint extends AbstractEntity {

    @Column(name ="status")
    private SprintStatus status ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany(mappedBy = "sprint", fetch = FetchType.LAZY)
    private List<Story> storyList;

    private String goal;

    @CurrentTimestamp
    private LocalDateTime startDate;
    @CurrentTimestamp
    private LocalDateTime endDate;

    private int capacity;

    //Helper Methods
    public Boolean isSame(Sprint sprint) {
        if(!this.getName().equals(sprint.getName())) return false;
        if(!this.getDescription().equals(sprint.getDescription())) return false;
        if(!this.getStatus().equals(sprint.getStatus())) return false;
        if(this.getProgress() != sprint.getProgress())  return false;
        if(!this.getProject().equals(sprint.getProject())) return false;
        if(!this.getStoryList().equals(sprint.getStoryList())) return false;
        if(!this.getGoal().equals(sprint.getGoal())) return false;
        if(this.getCapacity() != sprint.getCapacity()) return false;
        if(this.getStartDate().equals(sprint.getStartDate())) return false;
        if(this.getEndDate().equals(sprint.getEndDate())) return false;
        return true;
    }
}
