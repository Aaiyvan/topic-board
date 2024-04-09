package dev.aaiyvan.topicboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TopicBoardApplication {

    public static void main(
            final String[] args
    ) {
        SpringApplication.run(TopicBoardApplication.class, args);
    }

}
