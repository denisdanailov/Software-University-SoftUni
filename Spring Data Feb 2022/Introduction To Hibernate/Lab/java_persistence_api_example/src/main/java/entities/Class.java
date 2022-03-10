package entities;

import javax.persistence.*;

@Entity
@Table(name = "classes")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 50)
    private String subject;
    @Column(name = "room_number", nullable = false)
    private int roomNumber;
    @Column(nullable = true)
    private int capacity;

    public Class() {
    }

    public Class(String subject, int roomNumber) {
        this.subject = subject;
        this.roomNumber = roomNumber;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setId(int id) {
        this.id = id;
    }
}
