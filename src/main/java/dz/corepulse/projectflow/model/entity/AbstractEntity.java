package dz.corepulse.projectflow.model.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;


@Data
@SuperBuilder
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor

public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    @Column(name ="name")
    private String name ;

    @Column(name ="description")
    private String description ;

    @Column(name ="status")
    private String status ;

    @Column(name ="priority")
    private String priority ;

    @Column(name ="progress")
    private int progress ;

    @CurrentTimestamp
    private LocalDateTime dateDebut ;

    @CurrentTimestamp
    private LocalDateTime dateFin;

    @Column(name = "time_left")
    private int timeLeft;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name ="created_at")
    private LocalDateTime createdAt ;
}
