package org.example.locations.repositories;

import org.example.locations.dtos.AllLocationDto;
import org.example.locations.entities.LocationEntity;

import java.util.List;

public interface ILocationRepository extends IBaseRepository<LocationEntity, Integer> {
    LocationEntity getByCoordinate(String latitude, String longitude);
    List<AllLocationDto> getByRegionName(String region);
    List<AllLocationDto> getByRegionId(int regionId);
    List<AllLocationDto> allLocations();
    List<LocationEntity> getRegions();
}
