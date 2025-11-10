package dz.corepulse.projectflow.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Table(name = "task" ,schema = "pfe")
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Task extends AbstractEntity{

    @ManyToOne
    private Long idStory ;


}
