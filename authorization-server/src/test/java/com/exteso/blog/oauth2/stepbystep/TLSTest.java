package com.exteso.blog.oauth2.stepbystep;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@BootstrapWith(SpringBootTestContextBootstrapper.class)
//@ContextConfiguration(classes = {RestClientConfig.class})
public class TLSTest {


//    @Autowired
//    private HttpClient httpClient;

    @Ignore
    @Test
    public void testRestTemplate() throws Exception {

//        HttpResponse httpResponse = httpClient.execute(
//                new HttpGet("https://localhost:8080/admin/test"));
//
//        Assert.assertThat(httpResponse.getStatusLine().getStatusCode(), CoreMatchers.equalTo(200));
    }

}