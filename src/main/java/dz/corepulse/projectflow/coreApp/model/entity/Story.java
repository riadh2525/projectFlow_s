package dz.corepulse.projectflow.coreApp.model.entity;

import dz.corepulse.projectflow.coreApp.model.enums.statuses.StoryStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "Story" ,schema = "core_app")
@SuperBuilder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Story extends AbstractEntity{

    @Column(name ="status")
    private StoryStatus status ;

    @ManyToOne
    @JoinColumn(name = "epic_id")
    private Epic epic ;

    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint  sprint ;

    @OneToMany(mappedBy = "story" ,fetch = FetchType.LAZY )
    private List<Task> taskList ;

    //Helper Meothds
    public Boolean isSame(Story story) {
        if(!this.getName().equals(story.getName())) return false;
        if(!this.getDescription().equals(story.getDescription())) return false;
        if(this.getProgress() != story.getProgress()) return false;
        if(this.getStatus() != story.getStatus()) return false;
        if(!this.getEpic().equals(story.getEpic())) return false;
        if(!this.getSprint().equals(story.getSprint())) return false;
        if(!this.getTaskList().equals(story.getTaskList())) return false;
        return true;
    }
}
