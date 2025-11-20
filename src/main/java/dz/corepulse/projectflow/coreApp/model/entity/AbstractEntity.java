package dz.corepulse.projectflow.coreApp.model.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;


@Data
@SuperBuilder
@MappedSuperclass
@AllArgsConstructor @NoArgsConstructor
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name ="name")
    private String name ;

    @Column(name ="description")
    private String description ;

    @Column(name ="progress")
    private int progress ;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name ="created_at")
    @CurrentTimestamp
    private LocalDateTime createdAt ;

    @Column(name = "updated_at")
    @CurrentTimestamp
    private LocalDateTime updatedAt ;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
