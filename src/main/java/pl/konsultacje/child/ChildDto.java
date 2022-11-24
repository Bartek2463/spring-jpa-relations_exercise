package pl.konsultacje.child;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ChildDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Long parentId;
}
