package com.crawford.content_calendar.repository;


import com.crawford.content_calendar.model.Content;
import com.crawford.content_calendar.model.Status;
import com.crawford.content_calendar.model.Type;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentRepository {

    private final JdbcClient jdbcClient;
    public ContentRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public static Content mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Content(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                Status.valueOf(rs.getString("status")),
                Type.valueOf(rs.getString("content_type")),
                rs.getTimestamp("date_created").toLocalDateTime(),
                rs.getTimestamp("date_updated") != null ? rs.getTimestamp("date_updated").toLocalDateTime() : null,
                rs.getString("url")
        );
    }

    public List<Content> findAll(){
        return jdbcClient.sql("SELECT * FROM Content")
                .query(ContentRepository::mapRow)
                .list();
    }

    public Optional<Content> findById(int id){
        return jdbcClient.sql("SELECT * FROM Content WHERE id = :id")
                .param("id",id)
                .query(ContentRepository::mapRow)
                .optional();

    }
}
