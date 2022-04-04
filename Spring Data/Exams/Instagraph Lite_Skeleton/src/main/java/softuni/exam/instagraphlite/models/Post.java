package softuni.exam.instagraphlite.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity{

    @Column(nullable = false)
    private String caption;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "picture_id", referencedColumnName = "id", nullable = false)
    private Picture picture;

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getCaption() {
        return caption;
    }

    public User getUser() {
        return user;
    }

    public Picture getPicture() {
        return picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return user.equals(post.user) && picture.equals(post.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, picture);
    }
}
