package dz.corepulse.projectflow.coreApp.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CurrentTimestamp;


@Entity
@Table(name = "project" ,schema = "core_app")
@SuperBuilder
public class Project extends AbstractEntity {

    @OneToMany(mappedBy = "project" ,fetch = FetchType.LAZY)
    private List<Long> epicList ;

    @OneToMany(mappedBy = "project" ,fetch = FetchType.LAZY)
    private  List<Long> sprintList ;

    @CurrentTimestamp
    private LocalDateTime startDate;

    @CurrentTimestamp
    private LocalDateTime endDate;
}
