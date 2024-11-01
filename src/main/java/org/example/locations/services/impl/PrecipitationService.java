package org.example.locations.services.impl;

import org.example.locations.dtos.PrecipitationDto;
import org.example.locations.entities.PrecipitationEntity;
import org.example.locations.mappers.entitymappers.PrecipitationMapper;
import org.example.locations.repositories.impl.PrecipitationRepository;
import org.example.locations.services.IPrecipitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrecipitationService implements IPrecipitationService {
    private final PrecipitationRepository precipitationRepository;
    private final PrecipitationMapper precipitationMapper;

    @Autowired
    public PrecipitationService(PrecipitationRepository precipitationRepository, PrecipitationMapper precipitationMapper) {
        this.precipitationRepository = precipitationRepository;
        this.precipitationMapper = precipitationMapper;
    }

    @Override
    public double getTotalPrecipitation(int locationId, int year) {
        return precipitationRepository.getTotalPrecipitation(locationId, year);
    }

    @Override
    public List<PrecipitationDto> getByLocationIdInAYear(int locationId, int year) {
        return precipitationRepository.getByLocationIdInAYear(locationId, year).stream().map(precipitationMapper::toDto).toList();
    }

    @Override
    public List<PrecipitationDto> getAll() {
        return precipitationRepository.getAll().stream().map(precipitationMapper::toDto).toList();
    }

    @Override
    public PrecipitationDto getById(Integer id) {
        return precipitationMapper.toDto(precipitationRepository.getById(id));
    }
}
