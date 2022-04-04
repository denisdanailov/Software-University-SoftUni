package softuni.exam.instagraphlite.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name ="pictures")
public class Picture extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String path;

    @Column(nullable = false)
    private double size;

    @OneToMany(mappedBy = "profilePicture", targetEntity = User.class)
    private Set<User> users;

    @OneToMany(mappedBy = "picture", targetEntity = Post.class)
    private Set<Post> posts;

    public String getPath() {
        return path;
    }

    public double getSize() {
        return size;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Picture picture = (Picture) o;
        return path.equals(picture.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }
}
