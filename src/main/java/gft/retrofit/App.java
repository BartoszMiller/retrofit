package gft.retrofit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public Retrofit retrofit() {

        return new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl("http://httpbin.org/")
                .build();
    }

    @Bean
    public RdsClient rdsClient(Retrofit retrofit) {
        return retrofit.create(RdsClient.class);
    }
}
