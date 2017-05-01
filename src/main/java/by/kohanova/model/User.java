package by.kohanova.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable, Comparator<User> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column
    public String username;

    @Column
    public String password;

    @Column
    public String firstname;

    @Column
    public String surname;

    @Column
    public String photo;

    @OneToMany(mappedBy = "user")
    private List<News> news;

    @OneToMany(mappedBy = "userAlfa")
    private List<Friends> friends;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_role",
            joinColumns = {@JoinColumn(name = "users_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    public List<Role> roles = new ArrayList<>();

    @Override
    public int compare(User o1, User o2) {
        return o1.username.compareToIgnoreCase(o2.username);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
}