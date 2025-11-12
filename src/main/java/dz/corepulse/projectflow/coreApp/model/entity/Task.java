package dz.corepulse.projectflow.coreApp.model.entity;

import dz.corepulse.projectflow.coreApp.model.entity.AbstractEntity;
import dz.corepulse.projectflow.coreApp.model.entity.Story;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

    @ManyToOne
    private Story story ;


}
