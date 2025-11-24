package dz.corepulse.projectflow.coreApp.model.entity;


import dz.corepulse.projectflow.coreApp.model.enums.statuses.EpicStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "epic" ,schema="core_app")
@SuperBuilder
@Data
@AllArgsConstructor @NoArgsConstructor
public class Epic extends AbstractEntity {

    @Column(name ="status")
    private EpicStatus status;

    @OneToMany(mappedBy = "epic", fetch = FetchType.LAZY)
    private List<Story> storyList;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    //Helper Methods
    public Boolean isSame(Epic epic) {
        if(!this.getName().equals(epic.getName())) return false;
        if(!this.getDescription().equals(epic.getDescription())) return false;
        if(this.getProgress() != epic.getProgress()) return false;
        if(!this.getStatus().equals(epic.getStatus())) return false;
        if(!this.getProject().equals(epic.getProject())) return false;
        if(!this.getStoryList().equals(epic.getStoryList())) return false;
        return true;
    }
}
