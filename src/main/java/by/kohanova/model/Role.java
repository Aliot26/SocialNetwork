package by.kohanova.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "role")
public class Role implements Serializable, GrantedAuthority {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer id;

//    @Column(name = "type")
//    @Enumerated(EnumType.STRING)
//    public RoleEnum role;

    @Column(name = "type")
    public String role;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
//    @JsonManagedReference
    @JsonIgnore
    public List<User> users;

    @Override
    @JsonIgnore
    public String getAuthority() {
        return role;
    }
}
