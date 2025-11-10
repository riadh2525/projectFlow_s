package dz.corepulse.projectflow.model.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "epic" ,schema="pfe")
@SuperBuilder
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Epic extends AbstractEntity {

    @OneToMany(mappedBy = "epic", fetch = FetchType.LAZY) // nom du champ su la table correspondante
    private List<Long> storyList ;

    @ManyToOne
//    private  Project project;
    private Long idProject ;

}
