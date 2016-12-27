package com.exteso.blog.oauth2.stepbystep;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by eocdev on 23.12.16.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "OK";
    }
}
