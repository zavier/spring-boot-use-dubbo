package com.zavier.dubboprovider.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping(value = "http")
    public String test(@RequestParam(defaultValue = "abcdefg") String text) {
        return "HTTP Result : " + text;
    }
}
