package org.example.locations.controllers;

import org.example.locations.services.impl.PrecipitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/precipitation/v1")
public class PrecipitationController {
    private final PrecipitationService precipitationService;

    @Autowired
    public PrecipitationController(PrecipitationService precipitationService) {
        this.precipitationService = precipitationService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> getLocations(@RequestParam(required = false) Integer precipitationId, @RequestParam(required = false) Integer locationId, @RequestParam(required = false) Integer year) {
        if (precipitationId != null) {
            return ResponseEntity.ok(precipitationService.getById(precipitationId));
        } else if (locationId != null && year != null) {
            return ResponseEntity.ok(precipitationService.getByLocationIdInAYear(locationId, year));
        } else {
            return ResponseEntity.ok(precipitationService.getAll());
        }
    }

    @GetMapping("/total")
    @ResponseBody
    public ResponseEntity<Double> getTotalPrecipitation(@RequestParam Integer locationId, @RequestParam Integer year) {
        if (locationId != null && year != null) {
            return ResponseEntity.ok(precipitationService.getTotalPrecipitation(locationId, year));
        }
        return null;
    }
}
