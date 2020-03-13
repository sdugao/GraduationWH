package gra.gao.gra;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class GraApplicationTests {

    @Test
    void contextLoads() {
        String uuid= UUID.randomUUID().toString();
        System.out.println(uuid.length());
    }

}
