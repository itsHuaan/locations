package org.example.locations.mappers.rowmapers;

import org.example.locations.entities.LocationEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationRowMapper implements RowMapper<LocationEntity> {
    @Override
    public LocationEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new LocationEntity(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getString(4)
        );
    }
}
