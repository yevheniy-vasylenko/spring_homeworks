package hellospringcloud.ratingservice.caching;

import hellospringcloud.bookservice.Book;
import hellospringcloud.ratingservice.BookServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BookServiceCacheable {
    @Autowired
    private BookServiceFeignClient bookService;

    @Cacheable(value = CacheConfig.CACHE_NAME, key = CacheConfig.FIND_ALL_BOOKS_KEY)
    public List<Book> getCachedBooks() {
        return Arrays.asList();
    }

    @CachePut(value = CacheConfig.CACHE_NAME, key = CacheConfig.FIND_ALL_BOOKS_KEY)
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }
}
