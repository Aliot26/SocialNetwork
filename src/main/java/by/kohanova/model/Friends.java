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

}
