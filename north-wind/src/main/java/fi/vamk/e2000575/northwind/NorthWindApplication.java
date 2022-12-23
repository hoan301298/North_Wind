package fi.vamk.e2000575.northwind;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class NorthWindApplication {
	public static void main(String[] args) {
		SpringApplication.run(NorthWindApplication.class, args);
	}
}
