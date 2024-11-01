package org.example.locations.mappers.rowmapers;

import org.example.locations.entities.PrecipitationEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrecipitationRowMapper implements RowMapper<PrecipitationEntity> {
    @Override
    public PrecipitationEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PrecipitationEntity(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getInt(5)
        );
    }
}
