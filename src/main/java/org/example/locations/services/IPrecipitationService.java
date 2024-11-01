package org.example.locations.services;

import org.example.locations.dtos.PrecipitationDto;
import org.example.locations.entities.PrecipitationEntity;

import java.util.List;

public interface IPrecipitationService extends IBaseService<PrecipitationDto, Integer> {
    double getTotalPrecipitation(int locationId, int year);
    List<PrecipitationDto> getByLocationIdInAYear(int locationId, int year);
}
