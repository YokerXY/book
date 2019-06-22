package com.ri.service.Impl;

import com.ri.dao.ReaderInformationDAO;
import com.ri.entrty.ReaderInformation;
import com.ri.factory.DAOFactory;
import com.ri.factory.ServiceFactory;
import com.ri.service.ReaderInformationSeervice;

import java.sql.SQLException;
import java.util.List;

public class ReaderInformationServiceImpl implements ReaderInformationSeervice {

    private ReaderInformationDAO  ReaderInformation = DAOFactory.getReaderInstance();
    @Override
    public List<ReaderInformation> selsetAllIn(String id) {
        List<ReaderInformation> readerInformationList = null;
        try {
            readerInformationList = ReaderInformation.selectAllIn(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readerInformationList;
    }
}
