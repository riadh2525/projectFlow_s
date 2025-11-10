package dz.corepulse.projectflow.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "sprint" ,schema="pfe")
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor

public class Sprint extends AbstractEntity {

    @OneToMany(mappedBy = "epic", fetch = FetchType.LAZY) // nom du champ dans la table correspondante
//    private List<Story> storyList ;
    private List<Long> storyList ;

    @ManyToOne
    private Long idProject ;

}
