package pl.konsultacje.child;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.konsultacje.parent.Parent;
import pl.konsultacje.parent.ParentRepo;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class ChildServiceImpl implements ChildService {

    private ChildRepo childRepo;

    private ChildMapper childMapper;
    private ParentRepo parentRepo;



    @Override
    public List<Child> findAllChildren() {
        return childRepo.findAll();
    }


    //TODO
    @Override
    public Optional<List<Child>> findChildrenByParentsAge(Integer age) {
        return Optional.empty();
    }

    @Override
    public Optional<Child> findByChildId(Long id) {
        return childRepo.findById(id);
    }

    @Override
    public Child updateByChildId(ChildDto childDto, Long id) {

        Child childEntity = childRepo.findById(id).orElseThrow(() -> new RuntimeException("Child doesnt exists"));

        Child child = childMapper.mapToEntity(childDto);
        System.out.println("map to entity = " + child.getParent());

        childEntity.setId(child.getId())
                .setFirstName(child.getFirstName())
                .setLastName(child.getLastName())
                .setAge(child.getAge())
                .setParent(child.getParent());

        Child response = saveChild(childMapper.childDto(childEntity));
        return response;
    }

    @Override
    public Child saveChild(ChildDto childDto) {
        Child child = childMapper.mapToEntity(childDto);
        childRepo.saveAndFlush(child);
        Parent parent = child.getParent();
        parent.setChildSet(Set.of());
        parentRepo.save(parent);
        return child;

    }

    @Override
    public void deleteChild(Long id) {
        childRepo.deleteById(id);

    }
}
