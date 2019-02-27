package hellospringcloud.ratingservice.caching;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@EnableCaching
public class CacheConfig {

    public static final String CACHE_NAME = "myCache";
    public static final String FIND_ALL_BOOKS_KEY = "'find_all_books_key'";

    @Bean
    public CacheManager cacheManager() {
        // Use guava cache manager for more configuration options
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
                new ConcurrentMapCache(CACHE_NAME)
        ));
        return cacheManager;
    }
}
