package hellospringcloud.ratingservice;

import hellospringcloud.bookservice.BookController;
import hellospringcloud.ratingservice.caching.BookServiceCacheable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    private Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookServiceCacheable bookServiceCacheable;

    @GetMapping("")
    public List<RatedBook> findAllRatings() {
        log.info("findAllRatings");
        Random rnd = new Random();
        List<RatedBook> books = bookServiceCacheable.findAllBooks()
                .stream()
                .map(b->new RatedBook(b, rnd.nextInt(100)))
                .collect(Collectors.toList());
        return books;
    }
}
