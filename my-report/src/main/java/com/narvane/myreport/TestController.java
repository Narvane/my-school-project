package com.narvane.myreport;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("my-report/teste")
public class TestController {

    @GetMapping
    public String teste() {
        return "my-report";
    }

}
