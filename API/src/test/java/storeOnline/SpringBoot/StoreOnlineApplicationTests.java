package storeOnline.SpringBoot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class StoreOnlineApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        assertNotNull(applicationContext, "El contexto de la aplicación no debería ser nulo");
    }

    @Test
    void mainMethodShouldLoadWithoutError() {
        StoreOnlineApplication.main(new String[] {});
    }
}
