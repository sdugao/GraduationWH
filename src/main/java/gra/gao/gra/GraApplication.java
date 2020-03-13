package gra.gao.gra;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("gra.gao.gra.mapper")
@SpringBootApplication
public class GraApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraApplication.class, args);
    }

}
