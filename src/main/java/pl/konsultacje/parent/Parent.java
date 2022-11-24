package pl.konsultacje.parent;


import lombok.Data;
import pl.konsultacje.child.Child;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "parent")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "FIRST_NAME")
    private String firstName;
    @Column(nullable = false, name = "LAST_NAME")
    private String lastName;
    @Column(nullable = false, name = "AGE")
    private Integer age;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    @Transient
    Set<Child> childSet = new HashSet<>();
}
