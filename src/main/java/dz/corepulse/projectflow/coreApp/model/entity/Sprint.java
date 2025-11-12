package dz.corepulse.projectflow.coreApp.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sprint" ,schema="core_app")
@SuperBuilder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Sprint extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @OneToMany(mappedBy = "epic", fetch = FetchType.LAZY)
    private List<Story> storyList ;

    private String goal;

    @CurrentTimestamp
    private LocalDateTime startDate;
    @CurrentTimestamp
    private LocalDateTime endDate;

    private int capacity;
}
