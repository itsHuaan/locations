package org.example.locations.controllers;

import org.example.locations.services.impl.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("api/map/v1")
public class LocationController {
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        model.addAttribute("regions", locationService.getRegion());
        return "index";
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> getLocations(@RequestParam(required = false) String regionName, @RequestParam(required = false) Integer regionId, @RequestParam(required = false) Integer locationId) {
        if (regionName != null) {
            return ResponseEntity.ok(locationService.getByRegion(regionName));
        } else if (regionId != null){
            return ResponseEntity.ok(locationService.getByRegionId(regionId));
        }else if (locationId != null){
            return ResponseEntity.ok(locationService.getById(locationId));
        } else {
            return ResponseEntity.ok(locationService.allLocations());
        }
    }

    @GetMapping("/region")
    @ResponseBody
    public ResponseEntity<?> updatePost(@RequestBody Map<String, Integer> payload) {
        Integer id = payload.get("regionId");
        return id == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(locationService.getByRegionId(id));
    }
}
