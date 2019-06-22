package com.ri.service.Impl;

import com.ri.entrty.ReaderInformation;
import com.ri.factory.ServiceFactory;
import com.ri.service.ReaderInformationSeervice;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ReaderInformationServiceImplTest {

    private ReaderInformationSeervice readerInformationSeervice = ServiceFactory.getReaderServiceInstance();
    @Test
    public void selsetAllIn() {
        List<ReaderInformation> readerInformationList =null;
        readerInformationList= readerInformationSeervice.selsetAllIn("8");
        readerInformationList.forEach(readerInformation -> System.out.println(readerInformation));
    }
}