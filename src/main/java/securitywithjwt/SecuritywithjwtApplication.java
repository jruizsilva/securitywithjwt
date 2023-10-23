package securitywithjwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SecuritywithjwtApplication {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SecuritywithjwtApplication.class,
                              args);
    }

    /*@Bean
    public CommandLineRunner createPasswordsCommand() {
        return args -> {
            System.out.println(passwordEncoder.encode("user"));
            System.out.println(passwordEncoder.encode("admin"));
        };
    }*/
}
