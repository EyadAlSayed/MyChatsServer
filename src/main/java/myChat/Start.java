package myChat;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collections;

@SpringBootApplication
public class Start {

    private static ConfigurableApplicationContext ctx;
    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Start.class);
        app.setDefaultProperties(Collections.singletonMap("server.port","3030"));
        ctx = app.run(args);



    }
    public static void exitApplication() {
        int exitCode = SpringApplication.exit(ctx, new ExitCodeGenerator() {
            @Override
            public int getExitCode() {
                return 0;
            }
        });
        System.exit(exitCode);
    }
}
