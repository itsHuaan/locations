package org.example.locations.mappers.entitymappers;

import org.example.locations.dtos.AllLocationDto;
import org.example.locations.dtos.LocationDto;
import org.example.locations.entities.LocationEntity;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {
    public LocationDto toDto(LocationEntity locationEntity) {
        return LocationDto.builder()
                .locationId(locationEntity.getLocationId())
                .name(locationEntity.getName())
                .parentId(locationEntity.getParentId())
                .coords(locationEntity.getCoords())
                .build();
    }
}
