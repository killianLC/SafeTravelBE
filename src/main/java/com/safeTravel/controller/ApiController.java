package com.safeTravel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping({"/data_api"})
public class ApiController {

    private static final String API_KEY_METEO = "888f70e84a4d7e44f3c0d4870c926e9d";

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

    /**
     * Endpoint / type GET
     *
     * @return ResponseEntity<String>
     */
    @GetMapping({"/city/{name}"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getCityData(@PathVariable("name") String name) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("https://nominatim.openstreetmap.org/search/" + name + "?format=json&addressdetails=1&limit=1&polygon_svg=1", String.class);
        return response;
    }

    /**
     * Endpoint / type GET
     *
     * @return ResponseEntity<String>
     */
    @GetMapping({"/meteo/{latitude}/{longitude}"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getMeteo(@PathVariable("latitude") String latitude, @PathVariable("longitude") String longitude) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("https://api.openweathermap.org/data/2.5/onecall?lat=" + latitude + "&lon=" + longitude + "&exclude=current,minutely,hourly&appid=" + API_KEY_METEO, String.class);
        return response;
    }
}
