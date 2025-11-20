package dz.corepulse.projectflow.coreApp.model.entity;

import dz.corepulse.projectflow.coreApp.model.enums.statuses.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Table(name = "task" ,schema = "core_app")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task extends AbstractEntity {

    @Column(name ="status")
    private TaskStatus status ;

    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story ;
}
