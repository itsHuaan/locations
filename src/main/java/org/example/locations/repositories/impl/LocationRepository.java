package org.example.locations.repositories.impl;

import org.example.locations.dtos.AllLocationDto;
import org.example.locations.entities.LocationEntity;
import org.example.locations.mappers.rowmapers.LocationRowMapper;
import org.example.locations.repositories.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationRepository implements ILocationRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LocationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<LocationEntity> getAll() {
        String query = "select * from tbl_location";
        return jdbcTemplate.query(query, new LocationRowMapper());
    }

    @Override
    public LocationEntity getById(Integer id) {
        String query = "select * from tbl_location where locationId = ?";
        return jdbcTemplate.queryForObject(query, new LocationRowMapper(), id);
    }

    @Override
    public LocationEntity getByCoordinate(String latitude, String longitude) {
        String coordinate = latitude + ", " + longitude;
        String query = "select * from tbl_location where coords = ?";
        return jdbcTemplate.queryForObject(query, new LocationRowMapper(), coordinate);
    }

    @Override
    public List<AllLocationDto> getByRegionName(String region) {
        String query = "SELECT child.locationId, child.name, child.coords, parent.name FROM tbl_location AS child JOIN tbl_location AS parent ON child.parentId = parent.locationId WHERE parent.name = ? ORDER BY child.name";
        return jdbcTemplate.query(query, (rs, rowNum) -> new AllLocationDto(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)), region);
    }

    @Override
    public List<AllLocationDto> getByRegionId(int regionId) {
        String query = "SELECT child.locationId, child.name, child.coords, parent.name FROM tbl_location AS child JOIN tbl_location AS parent ON child.parentId = parent.locationId WHERE parent.locationId = ? ORDER BY child.name";
        return jdbcTemplate.query(query, (rs, rowNum) -> new AllLocationDto(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)), regionId);
    }

    @Override
    public List<AllLocationDto> getAllLocations() {
        String query = "SELECT child.locationId, child.name, child.coords, parent.name FROM tbl_location AS child JOIN tbl_location AS parent ON child.parentId = parent.locationId WHERE child.locationId > 8 ORDER BY child.name";
        return jdbcTemplate.query(query, (rs, rowNum) -> new AllLocationDto(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)
        ));
    }

    @Override
    public List<LocationEntity> getRegions() {
        String query = "select * from tbl_location where parentId = 0";
        return jdbcTemplate.query(query, new LocationRowMapper());
    }
}
