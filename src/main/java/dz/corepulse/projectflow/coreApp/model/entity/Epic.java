package dz.corepulse.projectflow.coreApp.model.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "epic" ,schema="core_app")
@SuperBuilder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Epic extends AbstractEntity {

    @OneToMany(mappedBy = "epic", fetch = FetchType.LAZY)
    private List<Story> storyList ;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project ;

}
