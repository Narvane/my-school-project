package com.narvane.myschool;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my-school/tenant/university-one/test")
public class TestController {

    @GetMapping
    public String teste() {
        return "my-school";
    }

}
