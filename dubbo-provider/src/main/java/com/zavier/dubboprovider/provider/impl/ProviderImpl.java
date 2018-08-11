package com.zavier.dubboprovider.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zavier.provider.Provider;
import org.springframework.stereotype.Component;

@Service(interfaceClass = Provider.class)
@Component
public class ProviderImpl implements Provider {

    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
