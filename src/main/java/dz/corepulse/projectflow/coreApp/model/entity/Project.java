package dz.corepulse.projectflow.coreApp.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CurrentTimestamp;

@Data
@Entity
@Table(name = "project" ,schema = "core_app")
@SuperBuilder
@AllArgsConstructor @NoArgsConstructor
public class Project extends AbstractEntity {

    @OneToMany(mappedBy = "project" ,fetch = FetchType.LAZY)
    private List<Epic> epicList ;

    @OneToMany(mappedBy = "project" ,fetch = FetchType.LAZY)
    private  List<Sprint> sprintList ;

    @Column(name = "start_date")
    @CurrentTimestamp
    private LocalDateTime startDate;

    @Column(name = "end_date")
    @CurrentTimestamp
    private LocalDateTime endDate;
}
