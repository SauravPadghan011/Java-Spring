package com.spring.IoC.service;

public class SadFortune implements FortuneService{

    @Override
    public String getFortune() {
        return "Sad Fortune";
    }
}
