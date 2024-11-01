package org.example.locations.repositories.impl;

import org.example.locations.entities.PrecipitationEntity;
import org.example.locations.mappers.rowmapers.PrecipitationRowMapper;
import org.example.locations.repositories.IPrecipitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public class PrecipitationRepository implements IPrecipitationRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PrecipitationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public double getTotalPrecipitation(int locationId, int year) {
        String query = "select sum(precipitation_amount) from tbl_precipitation where locationId = ? and year = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{locationId, year}, Double.class);
    }

    @Override
    public List<PrecipitationEntity> getByLocationIdInAYear(int locationId, int year) {
        String query = "select * from tbl_precipitation where locationId = ? and year = ? order by month";
        return jdbcTemplate.query(query, new PrecipitationRowMapper(), locationId, year);
    }

    @Override
    public List<PrecipitationEntity> getAll() {
        String query = "select * from tbl_precipitation";
        return jdbcTemplate.query(query, new PrecipitationRowMapper());
    }

    @Override
    public PrecipitationEntity getById(Integer id) {
        String query = "select * from tbl_precipitation where precipitationId = ?";
        return jdbcTemplate.queryForObject(query, new PrecipitationRowMapper(), id);
    }
}
