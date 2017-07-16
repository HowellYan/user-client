package cm.com.alien.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Root on 2017/7/16.
 */
@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "Starting......";
    }

    @RequestMapping("/health")
    public String health() {
        return "{\"description\":\"Spring Cloud Consul Discovery Client\",\"status\":\"UP\"}";
    }
}
