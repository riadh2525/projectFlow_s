package dz.corepulse.projectflow.coreApp.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sprint" ,schema="pfe")
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
public class Sprint extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Long projectId;

    @OneToMany(mappedBy = "epic", fetch = FetchType.LAZY)
    private List<Long> storyList ;

    private String goal;

    @CurrentTimestamp
    private LocalDateTime startDate;
    @CurrentTimestamp
    private LocalDateTime endDate;

    private int capacity;
}
