package org.example.locations.repositories;

import org.example.locations.entities.PrecipitationEntity;

import java.util.List;

public interface IPrecipitationRepository extends IBaseRepository<PrecipitationEntity, Integer>{
    double getTotalPrecipitation(int locationId, int year);
    List<PrecipitationEntity> getByLocationIdInAYear(int locationId, int year);
}
