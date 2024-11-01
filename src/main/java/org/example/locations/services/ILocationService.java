package org.example.locations.services;

import org.example.locations.dtos.CityDto;
import org.example.locations.dtos.LocationDto;

import java.util.List;

public interface ILocationService extends IBaseService<LocationDto, Integer> {
    LocationDto getByCoordinate(String latitude, String longitude);
    List<CityDto> getByRegion(String region);
    List<CityDto> getByRegionId(int regionId);
    List<CityDto> getAllLocations();
    List<LocationDto> getRegion();
}
