package _04_HospitalDatabase.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "_04_patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String email;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Lob
    private byte[] picture;

    @Column(name = "is_ensured", nullable = false)
    private Boolean isEnsured;

    @OneToMany(mappedBy = "patient", targetEntity = Visitation.class)
    private Set<Visitation> visitations;

    @OneToOne
    @JoinColumn(name = "diagnose_id", referencedColumnName = "diagnose_id")
    private Diagnose diagnose;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String address, String email, LocalDate dateOfBirth, byte[] picture, Boolean isEnsured, Diagnose diagnose) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.picture = picture;
        this.isEnsured = isEnsured;
        this.diagnose = diagnose;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Boolean getEnsured() {
        return isEnsured;
    }

    public void setEnsured(Boolean ensured) {
        isEnsured = ensured;
    }
}
