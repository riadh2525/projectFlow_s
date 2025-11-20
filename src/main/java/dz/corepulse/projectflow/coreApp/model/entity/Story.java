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
}
