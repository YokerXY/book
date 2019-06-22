package com.ri.dao;

import com.ri.entrty.ReaderInformation;

import java.sql.SQLException;
import java.util.List;

public interface ReaderInformationDAO {

    List<ReaderInformation> selectAllIn(String id) throws SQLException;
}
