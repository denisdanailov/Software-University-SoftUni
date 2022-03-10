package _04_HospitalDatabase.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "_04_diagnosis")
public class Diagnose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diagnose_id")
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String comments;

    @OneToOne(mappedBy = "diagnose", targetEntity = Patient.class)
    private Patient patient;

    @ManyToMany
    @JoinTable(name = "_04_diagnosis_medications",
            joinColumns = @JoinColumn(name = "diagnose_id", referencedColumnName = "diagnose_id"),
            inverseJoinColumns = @JoinColumn(name = "medication_id", referencedColumnName = "medication_id"))
    private Set<Medicament> medications;

    public Diagnose() {
    }

    public Diagnose(String name, String comments) {
        this.name = name;
        this.comments = comments;
        this.medications = new LinkedHashSet<>();
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Set<Medicament> getMedications() {
        return medications;
    }

    public void addMedicament(Medicament medicament) {
        this.medications.add(medicament);
    }
}
