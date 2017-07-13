package gft.retrofit;

import gft.retrofit.client.GitHubClient;
import gft.retrofit.client.HttpBinClient;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${api.url.httpBin}")
    private String httpBinUrl;

    @Value("${api.url.gitHub}")
    private String gitHubUrl;

    @Bean
    public Retrofit retrofitHttpBin() {

        return new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl(httpBinUrl)
                .build();
    }

    @Bean
    public Retrofit retrofitGitHub() {

        return new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl(gitHubUrl)
                .build();
    }

    @Bean
    public HttpBinClient httpBinClient() {
        return retrofitHttpBin().create(HttpBinClient.class);
    }

    @Bean
    public GitHubClient gitHubClient() {
        return retrofitGitHub().create(GitHubClient.class);
    }
}
