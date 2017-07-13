package gft.retrofit.client;

import gft.retrofit.model.github.Repository;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubClient {

    /**
     * Returns GitHub repository.
     */
    @GET("/repos/{owner}/{repo}")
    Call<Repository> findRepo(@Path("owner") String owner, @Path("repo") String repo);
}
