package _04_HospitalDatabase.entities;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "_04_medications")
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medication_id")
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "medications", targetEntity = Diagnose.class)
    private Set<Diagnose> diagnosis;

    public Medicament() {
    }

    public Medicament(String name) {
        this.name = name;
        this.diagnosis = new LinkedHashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Diagnose> getDiagnosis() {
        return diagnosis;
    }

    public void addDiagnose(Diagnose diagnose) {
        this.diagnosis.add(diagnose);
    }
}
