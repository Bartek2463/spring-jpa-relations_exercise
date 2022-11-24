package pl.konsultacje.child;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.konsultacje.parent.Parent;
import pl.konsultacje.parent.ParentRepo;

@Component
@Slf4j
@AllArgsConstructor
public class ChildMapper {

    private ParentRepo parentRepo;

    public  Child mapToEntity(ChildDto childDto){

        Parent parent = parentRepo.findById(childDto.getParentId()).orElseThrow(() ->
                new NoFoundUser("Does not exists")
        );

        Child child = new Child()
                .setId(childDto.getId())
                .setFirstName(childDto.getFirstName())
                .setLastName(childDto.getLastName())
                .setAge(childDto.getAge())
                .setParent(parent);
        return child;
    }

    public  ChildDto childDto(Child child){
        ChildDto childDto = new ChildDto()
                .setId(child.getId())
                .setFirstName(child.getFirstName())
                .setLastName(child.getLastName())
                .setAge(child.getAge())
                .setParentId(child.getParent().getId());

        return  childDto;
    }
}
