package com.springcontext.microservices.consumer.controllers;

import com.springcontext.microservices.consumer.controllers.dto.HeroRequestDto;
import com.springcontext.microservices.consumer.controllers.dto.HeroResponseDto;
import com.springcontext.microservices.consumer.services.AspConsumerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeroConsumer {

    private AspConsumerService aspConsumerService;

    @Autowired
    public HeroConsumer(AspConsumerService aspConsumerService) {
        this.aspConsumerService = aspConsumerService;
    }

    @RequestMapping(path = "/consume-heroes", method = RequestMethod.GET)
    public List<HeroResponseDto> consumeGetHeroes() {
        return this.aspConsumerService.getAllHeroes();
    }

    @RequestMapping(path = "/consume-heroes", method = RequestMethod.POST)
    public void consumePostHero(@RequestBody HeroRequestDto dto) {
        this.aspConsumerService.createHero(dto);
    }
}
