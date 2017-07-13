package gft.retrofit;

import gft.model.IpAddress;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RdsClient {

    /**
     * Simple GET without any params.
     */
    @GET("/ip")
    Call<IpAddress> ip();
}
