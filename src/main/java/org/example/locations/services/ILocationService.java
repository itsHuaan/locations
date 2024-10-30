package org.example.locations.services;

import org.example.locations.dtos.AllLocationDto;
import org.example.locations.dtos.LocationDto;
import org.example.locations.entities.LocationEntity;

import java.util.List;

public interface ILocationService extends IBaseService<LocationDto, Integer> {
    LocationDto getByCoordinate(String latitude, String longitude);
    List<AllLocationDto> getByRegion(String region);
    List<AllLocationDto> getByRegionId(int regionId);
    List<AllLocationDto> allLocations();
    List<LocationDto> getRegion();
}
