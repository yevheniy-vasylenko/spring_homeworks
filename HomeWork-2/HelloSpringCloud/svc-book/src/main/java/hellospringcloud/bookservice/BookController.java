package hellospringcloud.bookservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController implements BookService {
    private Logger log = LoggerFactory.getLogger(BookController.class);

    private List<Book> bookList = Arrays.asList(
            new Book(1L, "Tim Schimandle", "Baeldung goes to the market"),
            new Book(2L, "Slavisa","Baeldung goes to the park" )
    );

    @Override
    public List<Book> findAllBooks() {
        log.info("findAllBooks");
        return bookList;
    }

    @Override
    public Book findBook(Long bookId) {
        log.info("findBook "+bookId);
        return bookList.stream().filter(b -> b.getId().equals(bookId)).findFirst().orElse(null);
    }
}
