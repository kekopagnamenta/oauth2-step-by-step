package com.exteso.blog.oauth2.stepbystep;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by eocdev on 21.12.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RedisConfig.class})
public class RedisTest {

    @Autowired
    private StringRedisTemplate template;

    @Ignore
    @Test
    public void testInsert() throws Exception {

        ValueOperations<String, String> ops = this.template.opsForValue();
        String key = "oauth.demo.key";
        String value = "test";
        if (!this.template.hasKey(key)) {
            ops.set(key, value);
        }
        Assert.assertThat(ops.get(key), CoreMatchers.is(value));
    }

}
