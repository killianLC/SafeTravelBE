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

    /**
     * Endpoint / type GET
     *
     * @return ResponseEntity<String>
     */
    @GetMapping({"/flux_rss/{city}"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getFluxRss(@PathVariable("city") String city) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("https://news.google.com/rss/search?q=" + city + "&hl=fr", String.class);
        return response;
    }
}
