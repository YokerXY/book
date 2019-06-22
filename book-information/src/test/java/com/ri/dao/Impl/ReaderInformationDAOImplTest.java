package com.ri.dao.Impl;

import com.ri.dao.ReaderInformationDAO;
import com.ri.entrty.ReaderInformation;
import com.ri.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ReaderInformationDAOImplTest {

    private ReaderInformationDAO readerInformationDAO = DAOFactory.getReaderInstance();
    @Test
    public void selectAllIn() {
        List<ReaderInformation> readerInformationList =null;
        try {
            readerInformationList= readerInformationDAO.selectAllIn("8");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        readerInformationList.forEach(readerInformation -> System.out.println(readerInformation));
    }
}