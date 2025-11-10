package dz.corepulse.projectflow.coreApp.model.entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;

public class Sprint extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Long projectId;

    private String goal;

    @CurrentTimestamp
    private LocalDateTime startDate;
    @CurrentTimestamp
    private LocalDateTime endDate;

    private int capacity;
}
