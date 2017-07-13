package gft.retrofit.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class RetrofitSecurityInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        Request.Builder requestBuilder = request.newBuilder().addHeader("Authorization-Header", "auth-value");
        Request authorizedRequest = requestBuilder.build();

        return chain.proceed(authorizedRequest);
    }
}
