package org.example.locations.mappers.entitymappers;

import org.example.locations.dtos.PrecipitationDto;
import org.example.locations.entities.PrecipitationEntity;
import org.springframework.stereotype.Component;

@Component
public class PrecipitationMapper {
    public PrecipitationDto toDto(PrecipitationEntity precipitationEntity) {
        return PrecipitationDto.builder()
                .precipitationId(precipitationEntity.getPrecipitationId())
                .locationId(precipitationEntity.getLocationId())
                .year(precipitationEntity.getYear())
                .month(precipitationEntity.getMonth())
                .precipitationAmount(precipitationEntity.getPrecipitationAmount())
                .build();
    }
}
