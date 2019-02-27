package hellospringcloud.ratingservice;

import hellospringcloud.bookservice.Book;
import hellospringcloud.ratingservice.caching.BookServiceCacheable;
import java.util.List;

public class BookServiceFallback implements BookServiceFeignClient {

    private final BookServiceCacheable bookServiceCacheable;

    public BookServiceFallback(BookServiceCacheable bookServiceCacheable) {
        this.bookServiceCacheable = bookServiceCacheable;
    }

    @Override
    public List<Book> findAllBooks() {
        return bookServiceCacheable.getCachedBooks();
    }

    @Override
    public Book findBook(Long bookId) {
        return null;
    }
}
