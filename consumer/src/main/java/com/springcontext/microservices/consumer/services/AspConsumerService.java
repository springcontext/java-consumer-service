package com.springcontext.microservices.consumer.services;

import com.springcontext.microservices.consumer.controllers.dto.HeroRequestDto;
import com.springcontext.microservices.consumer.controllers.dto.HeroResponseDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("ASP-CONSUMER-SERVICE")
public interface AspConsumerService {

    @RequestMapping(method = RequestMethod.GET, path = "/api/heroes", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<HeroResponseDto> getAllHeroes();

    @RequestMapping(path = "/api/heroes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    void createHero(HeroRequestDto dto);
}
