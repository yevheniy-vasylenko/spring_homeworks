package hellospringcloud.ratingservice;

import feign.hystrix.FallbackFactory;
import hellospringcloud.ratingservice.caching.BookServiceCacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookServiceFallbackFactory implements FallbackFactory<BookServiceFeignClient> {

    @Autowired
    BookServiceCacheable bookServiceCacheable;

    @Override
    public BookServiceFeignClient create(Throwable throwable) {
        return new BookServiceFallback(bookServiceCacheable);
    }
}
