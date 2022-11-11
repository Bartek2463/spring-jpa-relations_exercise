package pl.konsultacje.child;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import pl.konsultacje.parent.Parent;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "child")
@Accessors(chain = true)
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "FIRST_NAME")
    private String firstName;
    @Column(nullable = false, name = "LAST_NAME")
    private String lastName;
    @Column(nullable = false, name = "AGE")
    private Integer age;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "parent_id",referencedColumnName = "id")
   @ToString.Exclude
    private Parent parent;

}
