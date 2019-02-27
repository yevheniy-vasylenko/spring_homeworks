package hellospringcloud.ratingservice;

import hellospringcloud.bookservice.BookService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="book-service", fallbackFactory=BookServiceFallbackFactory.class)
public interface BookServiceFeignClient extends BookService {
}
