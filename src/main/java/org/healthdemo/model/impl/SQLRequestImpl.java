package org.healthdemo.model.impl;

import org.apache.catalina.util.ParameterMap;
import org.healthdemo.model.SQLRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("sqlRequest")
public class SQLRequestImpl implements SQLRequest {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public String getTableCreationStatus() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS dogs");
            jdbcTemplate.execute("CREATE TABLE public.dogs\n" +
                    "(\n" +
                    "    id integer NOT NULL,\n" +
                    "    name character varying(255) COLLATE pg_catalog.\"default\",\n" +
                    "    description character varying(255) COLLATE pg_catalog.\"default\",\n" +
                    "    color_id integer,\n" +
                    "    CONSTRAINT dogs_pkey PRIMARY KEY (id)\n" +
                    ")");
            return "Table created";
        } catch (Exception e) {
            return "Table creation failed\n" + e.getMessage();
        }
    }

    @Override
    public Integer getCountByName(String name) {
        String sql = "select count(*) from dogs where name = :name";
        SqlParameterSource namedParameter = new MapSqlParameterSource("name", name);
        return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameter, Integer.class);
    }

    @Override
    public Integer insertNewRecord(String name, String description, Integer color_id) {
        String sql = "insert into dogs (name, description, color_id) values (:name, :description, :color_id)";
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("description", description);
        params.put("color_id", color_id);
        Integer result = this.namedParameterJdbcTemplate.update(sql, params);
        return result;
    }

    @Override
    public Integer getInfo(String name, String description) {
        String sql = "select count(*) from dogs where name = :name and description = :description";
        Map<String, String> map = new ParameterMap<>();
        map.put("name", name);
        map.put("description", description);
        SqlParameterSource namedparameters = new MapSqlParameterSource(map);
        return this.namedParameterJdbcTemplate.queryForObject(sql, namedparameters, Integer.class);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
}
