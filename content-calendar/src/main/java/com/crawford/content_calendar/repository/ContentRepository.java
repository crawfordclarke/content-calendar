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

import static org.springframework.web.servlet.function.RequestPredicates.param;


// Repository for interacting with the Content table using JdbcClient
@Repository
public class ContentRepository {

    private final JdbcClient jdbcClient;
    public ContentRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }


    // Maps SQL result rows to Content objects
    public static Content mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Content(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                // Assumes database enum values match Java enum names exactly
                Status.valueOf(rs.getString("status")),
                Type.valueOf(rs.getString("content_type")),
                rs.getTimestamp("date_created").toLocalDateTime(),
                // date_updated may be null if the content has never been updated
                rs.getTimestamp("date_updated") != null ? rs.getTimestamp("date_updated").toLocalDateTime() : null,
                rs.getString("url")
        );
    }


    // Returns all content records
    public List<Content> findAll(){
        return jdbcClient.sql("SELECT * FROM Content")
                .query(ContentRepository::mapRow)
                .list();
    }


    // // Retrieves all content records from the database by ID
    // Returns Optional to explicitly handle the case where content does not exist
    public Optional<Content> findById(int id){
        return jdbcClient.sql("SELECT * FROM Content WHERE id = :id")
                .param("id",id)
                .query(ContentRepository::mapRow)
                .optional();

    }


    // Adds new content to db
    public void create(Content content) {
        this.jdbcClient.sql("INSERT INTO Content (title, description, status, content_type, date_created, url) VALUES (:title, :description, :status, :content_type, :date_created, :url)")
                .param("title", content.title())
                .param("description", content.description())
                .param("status", content.status().name())
                .param("content_type", content.contentType().name())
                // date_updated is omitted on creation and only set on updates
                .param("date_created", content.dateCreated())
                .param("url", content.url())
                .update();


    }


    // updates pre-existing content in db by id
    // Performs a full update; all fields are overwritten
    public void update(Content content) {
        this.jdbcClient.sql("UPDATE Content SET id = :id, title=:title, description=:description, status=:status, content_type=:content_type, date_created =:date_created, url =:url WHERE id = :id")
                .param("id", content.id())
                .param("title", content.title())
                .param("description", content.description())
                .param("status", content.status().name())
                .param("content_type", content.contentType().name())
                .param("date_created", content.dateCreated())
                .param("url", content.url())
                .update();
    }


    // Deletes content by ID
    public void delete(int id) {
        this.jdbcClient.sql("DELETE FROM Content WHERE id = :id")
                .param("id",id)
                .update();
    }


}




