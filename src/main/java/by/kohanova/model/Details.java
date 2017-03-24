package by.kohanova.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "details")
public class Details implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    public User user;

    @Column
    public String firstname;

    @Column
    public String surname;

    @Column
    public String photo;
}

