package userapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "userapi" })
@EnableJpaRepositories(basePackages = { "userapi" })
public class UserApi {
    public static void main(String[] args) {
        SpringApplication.run(UserApi.class, args);
    }
}
