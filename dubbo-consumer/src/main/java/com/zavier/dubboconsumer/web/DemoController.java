package com.zavier.dubboconsumer.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zavier.provider.Provider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {

    @Reference
    private Provider provider;

    @GetMapping(value = "dubbo")
    public String testDubbo(@RequestParam(defaultValue = "zheng") String name) {
        System.out.println("consumer param:" + name);
        return provider.hello(name);
    }

    @GetMapping(value = "tHTTP")
    public String testHttp() {
        System.out.println("consumer t http");
        return "This HTTP result";
    }

    @GetMapping(value = "oHTTP")
    public String testOtherHTTP(String text) {
        System.out.println("consumer o http");
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://localhost:9998/http?text=" + text, String.class);
        return forObject;
    }
}
