package gft.retrofit;

import gft.model.IpAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

    @Autowired
    private RdsClient rdsClient;

    @Test
    public void init() {
        assertNotNull(rdsClient);
    }

    @Test
    public void ip_success() throws IOException {

        // when
        Call<IpAddress> ipAddressCall = rdsClient.ip();
        Response<IpAddress> response = ipAddressCall.execute();
        IpAddress body = response.body();

        // then
        assertThat(body).isNotNull();
        assertThat(body.getOrigin()).isNotBlank();
    }

}
