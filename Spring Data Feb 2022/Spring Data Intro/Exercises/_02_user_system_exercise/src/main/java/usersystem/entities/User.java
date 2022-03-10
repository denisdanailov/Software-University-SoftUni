package usersystem.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30, nullable = false)
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Transient
    private String fullName = firstName + " " + lastName;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(name = "registered_on")
    private LocalDateTime registeredOn;

    @Column(name = "last_time_logged_in")
    private LocalDateTime lastLogInDateTime;

    private int age;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "born_town_id", referencedColumnName = "id")
    private Town bornTown;

    @ManyToOne
    @JoinColumn(name = "current_town_id", referencedColumnName = "id")
    private Town livingTown;

    @ManyToMany
    @JoinTable(name = "users_friends",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    private Set<User> friends;

    @OneToMany(mappedBy = "user")
    private Set<Album> albums;

    public User() {
        this.albums = new HashSet<>();
    }

    public User(String username, String firstName, String lastName, String password, String email, LocalDateTime registeredOn, LocalDateTime lastLogInDateTime,
                int age, Boolean isDeleted, Town bornTown, Town livingTown, Set<User> friends) {
        this();
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.registeredOn = registeredOn;
        this.lastLogInDateTime = lastLogInDateTime;
        this.age = age;
        this.isDeleted = isDeleted;
        this.bornTown = bornTown;
        this.livingTown = livingTown;
        this.friends = friends;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDateTime registeredOn) {
        this.registeredOn = registeredOn;
    }

    public LocalDateTime getLastLogInDateTime() {
        return lastLogInDateTime;
    }

    public void setLastLogInDateTime(LocalDateTime lastLogInDateTime) {
        this.lastLogInDateTime = lastLogInDateTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Town getBornTown() {
        return bornTown;
    }

    public void setBornTown(Town bornTown) {
        this.bornTown = bornTown;
    }

    public Town getLivingTown() {
        return livingTown;
    }

    public void setLivingTown(Town livingTown) {
        this.livingTown = livingTown;
    }

    public Set<User> getFriends() {
        return Collections.unmodifiableSet(friends);
    }

    public void addFriends(User friend) {
        this.friends.add(friend);
    }

    public Set<Album> getAlbums() {
        return Collections.unmodifiableSet(albums);
    }

    public void addAlbum(Album album) {
        this.albums.add(album);
    }
}
