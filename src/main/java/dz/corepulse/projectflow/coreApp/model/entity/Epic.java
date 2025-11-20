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

}
