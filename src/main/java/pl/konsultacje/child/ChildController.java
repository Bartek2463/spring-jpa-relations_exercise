package pl.konsultacje.child;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChildController {

    @Autowired
    private ChildService service;

    @GetMapping("/children")
    public List<Child> findAllChildren() {
        return service.findAllChildren();
    }

    @GetMapping("/children/{id}")
    public Child findChildrenById(@PathVariable("id") Long id) {
        return service.findByChildId(id).orElseThrow(() -> new RuntimeException());
    }

    @PostMapping("/children")
    public Child saveChild(@RequestBody ChildDto childDto) {
        return service.saveChild(childDto);
    }

    @PutMapping("/children/{id}")
    public Child updateChild(@PathVariable("id") Long id,
                             @RequestBody ChildDto childDto) {
        return service.updateByChildId(childDto, id);
    }

    @DeleteMapping("/children/{id}")
    public void deleteChild(@PathVariable("id") Long id) {
        service.deleteChild(id);
    }


}
