package com.safeTravel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping({"/data_api"})
public class ApiController {
    /**
     * Endpoint / type GET
     *
     * @return ResponseEntity<String>
     */
    @GetMapping({"/city_info/{city}"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getAll(@PathVariable("city") String city) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("https://geo.api.gouv.fr/communes?nom=" + city + "&fields=nom,code,codesPostaux,codeDepartement,codeRegion,population&format=json&geometry=centre", String.class);
        return response;
    }

    
}
