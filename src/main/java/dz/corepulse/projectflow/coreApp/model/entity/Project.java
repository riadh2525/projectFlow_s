package dz.corepulse.projectflow.coreApp.model.entity;

import dz.corepulse.projectflow.coreApp.model.enums.statuses.ProjectStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CurrentTimestamp;

@Data
@Entity
@Table(name = "project" ,schema = "core_app")
@SuperBuilder
@AllArgsConstructor @NoArgsConstructor
public class Project extends AbstractEntity {

    @Column(name ="status")
    private ProjectStatus status ;

    @OneToMany(mappedBy = "project" ,fetch = FetchType.LAZY)
    private List<Epic> epicList ;

    @OneToMany(mappedBy = "project" ,fetch = FetchType.LAZY)
    private  List<Sprint> sprintList ;

    @Column(name = "start_date")
    @CurrentTimestamp
    private LocalDateTime startDate;

    @Column(name = "end_date")
    @CurrentTimestamp
    private LocalDateTime endDate;

    //Helper Methods
    public Boolean isSame(Project project) {
        if(!this.getName().equals(project.getName())) return false;
        if(!this.getDescription().equals(project.getDescription())) return false;
        if(this.getProgress() != project.getProgress()) return false;
        if(!this.getStatus().equals(project.getStatus())) return false;
        if(!this.getEpicList().equals(project.getEpicList())) return false;
        if(!this.getSprintList().equals(project.getSprintList())) return false;
        if(!this.getStartDate().equals(project.getStartDate())) return false;
        if(!this.getEndDate().equals(project.getEndDate())) return false;
        return true;
    }
}
