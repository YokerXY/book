package com.sm.service;

import com.sm.entity.Type;

import java.sql.SQLException;
import java.util.List;

public interface StudentFrameService {
    List<Type> getAll() throws SQLException;
}
