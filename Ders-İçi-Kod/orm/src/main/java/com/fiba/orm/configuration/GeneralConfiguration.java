package com.fiba.orm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {

    @Bean
    MyBean myBean(){
        MyBean myBean = new MyBean();
        myBean.setMyLong(123);
        myBean.setMyString("Godoro");
        myBean.setMyDouble(43.21);
        return myBean;
    }
}
