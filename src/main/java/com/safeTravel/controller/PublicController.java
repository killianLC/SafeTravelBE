package com.safeTravel.controller;

import com.safeTravel.dto.CityClassementDto;
import com.safeTravel.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/public"})
public class PublicController {

    @Autowired
    private CityService cityService;

    @GetMapping({"/top10"})
    @ResponseStatus(HttpStatus.OK)
    public List<CityClassementDto> getTop10OrderByDesc() {
        return cityService.getTop10ByNotesDesc();
    }
}
