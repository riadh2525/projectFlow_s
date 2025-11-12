package dz.corepulse.projectflow.coreApp.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "Story" ,schema = "core_app")
@SuperBuilder
@Getter

public class Story extends AbstractEntity{

    @ManyToOne  // FK epic
    private Epic epic ;
//    private Long idEpic ;

    @ManyToOne   //FK sprint
    private Sprint  sprint ;
//     private Long idSprint ;

    @OneToMany(mappedBy = "story" ,fetch = FetchType.LAZY )
    private List<Story> taskList ;


}
