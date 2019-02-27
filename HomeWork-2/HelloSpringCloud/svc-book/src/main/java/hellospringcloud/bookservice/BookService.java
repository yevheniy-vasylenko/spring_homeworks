package hellospringcloud.bookservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/books")
public interface BookService {
    @GetMapping("")
    public List<Book> findAllBooks();

    @GetMapping("/{bookId}")
    public Book findBook(@PathVariable Long bookId);
}
