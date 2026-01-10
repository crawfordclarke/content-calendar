package com.crawford.content_calendar.repository;


import com.crawford.content_calendar.model.Content;
import com.crawford.content_calendar.model.Status;
import com.crawford.content_calendar.model.Type;
import org.springframework.data.repository.ListCrudRepository;
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
public interface ContentRepository extends ListCrudRepository<Content, Integer> {




}




