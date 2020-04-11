package gra.gao.gra;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.SchemaOutputResolver;
import java.util.UUID;

@SpringBootTest
class GraApplicationTests {

    @Test
    void testPirnt(){
        System.out.println("\"{");
    }


    @Test
    void contextLoads() {
        String uuid= UUID.randomUUID().toString();
        System.out.println(uuid.length());
    }

    @Test
    void zeroDivide(){
        System.out.println(-1/10);
    }
}
