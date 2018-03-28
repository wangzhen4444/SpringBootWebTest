package readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private ReadingListRepository girlRepository;
    @GetMapping(value = "/girls")
    public List<Book> girlList() {
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Book girlAdd(@Valid Book girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        girl.setReader(girl.getReader());
        girl.setId(girl.getId());
        girl.setAuthor(girl.getAuthor());
        girl.setDescription(girl.getDescription());
        girl.setTitle(girl.getTitle());
        return girlRepository.save(girl);
    }
}
