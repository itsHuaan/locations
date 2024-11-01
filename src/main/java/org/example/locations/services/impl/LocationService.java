package org.example.locations.services.impl;

import org.example.locations.dtos.AllLocationDto;
import org.example.locations.dtos.LocationDto;
import org.example.locations.entities.LocationEntity;
import org.example.locations.mappers.entitymappers.LocationMapper;
import org.example.locations.repositories.impl.LocationRepository;
import org.example.locations.services.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationService implements ILocationService {
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Autowired
    public LocationService(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }
    public List<LocationDto> getAll(){
        return locationRepository.getAll().stream().map(locationMapper::toDto).toList();
    }

    @Override
    public LocationDto getById(Integer id) {
        return locationMapper.toDto(locationRepository.getById(id));
    }

    @Override
    public LocationDto getByCoordinate(String latitude, String longitude) {
        return null;
    }

    @Override
    public List<AllLocationDto> getByRegion(String region) {
        return locationRepository.getByRegionName(region);
    }

    @Override
    public List<AllLocationDto> getByRegionId(int regionId) {
        return locationRepository.getByRegionId(regionId);
    }

    @Override
    public List<AllLocationDto> getAllLocations() {
        return locationRepository.getAllLocations();
    }

    @Override
    public List<LocationDto> getRegion() {
        return locationRepository.getRegions().stream().map(locationMapper::toDto).toList();
    }
}
