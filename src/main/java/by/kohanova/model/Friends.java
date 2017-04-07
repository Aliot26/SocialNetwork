package by.kohanova.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "friends")
public class Friends implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "friend1_id")
    public User user1;

    @ManyToOne
    @JoinColumn(name = "friend2_id")
    public User user2;

    @Column
    public boolean status;

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Friends))
            return false;
        Friends other = (Friends) obj;
        return id == null ? false : id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
}
