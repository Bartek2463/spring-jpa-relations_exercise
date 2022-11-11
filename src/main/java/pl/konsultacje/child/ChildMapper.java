package pl.konsultacje.child;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.konsultacje.parent.Parent;
import pl.konsultacje.parent.ParentRepo;

@Component
@Slf4j
public class ChildMapper {
    @Autowired
     private ParentRepo parentRepo;

    public Child maptoEntity(ChildDto childDto){

//        Long parentId = childDto.getParentId();
//        System.out.println("Parent id = "+parentId);

        Parent parent = parentRepo.findById(childDto.getId()).orElseThrow(() -> new RuntimeException());

        Child child = new Child()
               .setId(childDto.getId())
               .setFirstName(childDto.getFirstName())
               .setLastName(childDto.getLastName())
               .setAge(childDto.getAge())
               .setParent(parent);
        return child;
    }


    public ChildDto childDto(Child child){

        ChildDto childDto = new ChildDto()
                .setId(child.getId())
                .setFirstName(child.getFirstName())
                .setLastName(child.getLastName())
                .setAge(child.getAge())
                .setParentId(child.getParent().getId());
        return childDto;
    }



}
