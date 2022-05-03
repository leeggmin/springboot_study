package com.example.whatisrice.repository;

import com.example.whatisrice.domain.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcTemplateRiceRepository implements RiceRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateRiceRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Date> findByDay(Long day) {
        List<Date> result = jdbcTemplate.query("select * from menu where day = ?", riceRowMapper(), day);
        return result.stream().findAny();
    }

    private RowMapper<Date> riceRowMapper(){
        return (rs, rowNum) ->{
            Date date=new Date();
            date.setDay(rs.getLong("day"));
            return date;
        };
    }
}
