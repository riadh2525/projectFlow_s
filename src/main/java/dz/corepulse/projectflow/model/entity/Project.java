package dz.corepulse.projectflow.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "project" ,schema = "pfe")
@SuperBuilder

public class Project extends  AbstractEntity{


    @OneToMany(mappedBy = "project" ,fetch = FetchType.LAZY)
    private List<Epic> epicList ;

    @OneToMany(mappedBy = "project" ,fetch = FetchType.LAZY)
    private  List<Sprint> sprintList ;

}
