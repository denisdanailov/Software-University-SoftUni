package usersystem.entities;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @Column(name = "background_color")
    private String backgroundColor;

    @Column(name = "is_public")
    private Boolean isPublic;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany
    @JoinTable(name = "albums_photos",
        joinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "photo_id", referencedColumnName = "id"))
    private Set<Photo> photos;

    public Album() {
    }

    public Album(String name, String backgroundColor, Boolean isPublic, User user, Set<Photo> photos) {
        this.name = name;
        this.backgroundColor = backgroundColor;
        this.isPublic = isPublic;
        this.user = user;
        this.photos = photos;
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

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Photo> getPhotos() {
        return Collections.unmodifiableSet(photos);
    }

    public void addPhoto(Photo photo) {
        this.photos.add(photo);
    }
}
