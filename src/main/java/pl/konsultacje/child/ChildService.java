package pl.konsultacje.child;

import java.util.List;
import java.util.Optional;

public interface ChildService {

    List<Child> findAllChildren();

    Optional<List<Child>> findChildrenByParentsAge(Integer age);

    Optional<Child> findByChildId(Long id);

    Child updateByChildId(ChildDto childDto, Long id);

    Child saveChild(ChildDto childDto);

    void deleteChild(Long id);

}
