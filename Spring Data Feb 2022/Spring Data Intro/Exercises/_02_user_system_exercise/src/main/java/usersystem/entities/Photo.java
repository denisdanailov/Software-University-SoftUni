package usersystem.entities;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String caption;

    private String path;

    @ManyToMany(mappedBy = "photos")
    private Set<Album> albums;

    public Photo() {
        this.albums = new HashSet<>();
    }

    public Photo(String title, String caption, String path, Set<Album> albums) {
        this.title = title;
        this.caption = caption;
        this.path = path;
        this.albums = albums;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Set<Album> getAlbums() {
        return Collections.unmodifiableSet(albums);
    }

    public void addAlbums(Album album) {
        this.albums.add(album);
    }
}
