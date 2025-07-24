package userapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "userapi" })
@EnableJpaRepositories(basePackages = { "userapi" })
@EnableCaching
public class UserApi {
    public static void main(String[] args) {
        SpringApplication.run(UserApi.class, args);
    }

    //Мало настроект, поэтому не выносили конфигурацию в отдельный файл
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("users");
    }
}
