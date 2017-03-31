package by.kohanova.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {
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

    @OneToMany(mappedBy = "author")
    private List<News> news;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_role",
            joinColumns = {@JoinColumn(name = "users_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    public List<Role> roles = new ArrayList<>();
}