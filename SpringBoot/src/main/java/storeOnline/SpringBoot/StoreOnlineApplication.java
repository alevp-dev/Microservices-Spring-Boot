package storeOnline.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "storeOnline.SpringBoot")
public class StoreOnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreOnlineApplication.class, args);
    }

}
