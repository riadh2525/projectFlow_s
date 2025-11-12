package dz.corepulse.projectflow.coreApp.model.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "epic" ,schema="core_app")
@SuperBuilder
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Epic extends AbstractEntity {

    @OneToMany(mappedBy = "epic", fetch = FetchType.LAZY) // field name in the corresponding table
    private List<Story> storyList ;

    @ManyToOne
    private  Project project;


}
