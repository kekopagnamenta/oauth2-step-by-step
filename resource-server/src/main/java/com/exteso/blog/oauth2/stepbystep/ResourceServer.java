package com.exteso.blog.oauth2.stepbystep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableResourceServer
public class ResourceServer {

    public static void main(String[] args) {
        SpringApplication.run(ResourceServer.class, args);
    }

    @Autowired
    private StringRedisTemplate template;

    private String key = "oauth.demo.key";

    @PreAuthorize("#oauth2.hasScope('resource-server-read')")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Map<String, String> home() {
        ValueOperations<String, String> ops = this.template.opsForValue();
        String message = ops.get(key);
        return Collections.singletonMap("message", message.isEmpty() ? "no message" : message);
    }

    @PreAuthorize("#oauth2.hasScope('resource-server-write')")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void updateMessage(@RequestBody String message) {
        ValueOperations<String, String> ops = this.template.opsForValue();
        ops.set(key, message);
    }

    @PreAuthorize("#oauth2.hasScope('resource-server-read')")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Map<String, String> user(Principal user) {
        return Collections.singletonMap("message", "user is: " + user.toString());
    }

}