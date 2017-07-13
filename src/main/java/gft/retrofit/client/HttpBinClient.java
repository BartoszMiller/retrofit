package gft.retrofit.client;

import gft.retrofit.model.httpbin.IpAddress;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HttpBinClient {

    /**
     * Returns Origin IP.
     */
    @GET("/ip")
    Call<IpAddress> findIp();
}
