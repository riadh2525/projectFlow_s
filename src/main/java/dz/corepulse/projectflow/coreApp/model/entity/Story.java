package dz.corepulse.projectflow.coreApp.model.entity;

import dz.corepulse.projectflow.coreApp.model.entity.Task;
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

    @ManyToOne  // FK epic
    private Epic epic ;
//    private Long idEpic ;

    @ManyToOne   //FK sprint
    private Sprint  sprint ;

    @OneToMany(mappedBy = "story" ,fetch = FetchType.LAZY )
    private List<Task> taskList ;
}
