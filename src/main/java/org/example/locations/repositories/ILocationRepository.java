package org.example.locations.repositories;

import org.example.locations.dtos.CityDto;
import org.example.locations.entities.LocationEntity;

import java.util.List;

public interface ILocationRepository extends IBaseRepository<LocationEntity, Integer> {
    LocationEntity getByCoordinate(String latitude, String longitude);
    List<CityDto> getByRegionName(String region);
    List<CityDto> getByRegionId(int regionId);
    List<CityDto> getAllLocations();
    List<LocationEntity> getRegions();
}
