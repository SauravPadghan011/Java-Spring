package com.spring.IoC.service;

public class HappyFortune implements FortuneService{

    @Override
    public String getFortune() {
        return "Happy Fortune";
    }
}
