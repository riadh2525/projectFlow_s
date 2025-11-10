package dz.corepulse.projectflow.coreApp.model.entity;

import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;

public class Project extends AbstractEntity {

    @CurrentTimestamp
    private LocalDateTime startDate;
    @CurrentTimestamp
    private LocalDateTime endDate;
}
