package com.sm.service.Impl;

import com.sm.entity.Reader;
import com.sm.entity.ReaderVO;
import com.sm.factory.ServiceFactory;
import com.sm.service.ReaderService;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ReaderServiceImplTest {
    private ReaderService readerService = ServiceFactory.getReaderServiceInstance();
    @Test
    public void selectAll() {
        List<ReaderVO> readerList = readerService.selectAll();
        readerList.forEach(readerVO -> System.out.println(readerVO));

    }

    @Test
    public void selectByTypeId() {
        List<ReaderVO> readerVOList = readerService.selectByTypeId(3);
        readerVOList.forEach(readerVO -> System.out.println(readerVOList));
    }

    @Test
    public void selectByClassId() {
        List<ReaderVO> readerVOList = readerService.selectByClassId(3);
        readerVOList.forEach(readerVO -> System.out.println(readerVOList));
    }

    @Test
    public void selectByKeywords() {
        List<ReaderVO> readerVOList = readerService.selectByKeywords("王");
        readerVOList.forEach(readerVO -> System.out.println(readerVOList));

    }

    @Test
    public void updateReader() {
        Reader reader = new Reader();
        reader.setId(8);
        reader.setEmail("222@qq.com");
        reader.setMobile("321123");
        readerService.updateReader(reader);
    }

    @Test
    public void deleteReader() {
        String id = String.valueOf(9);
        readerService.deleteReader(id);
    }

    @Test
    public void insertReader() {
        Reader reader = new Reader();
        reader.setId(10);
        reader.setClass_id(10);
        reader.setName("安楠");
        reader.setRole("女");
        reader.setAvatar("http://pj7ldvis7.bkt.clouddn.com/avatar/1.jpg");
        reader.setJoin_date(new Date(2018-2-12));
        reader.setEmail("444@qq.com");
        reader.setMobile("123321");
        readerService.insertReader(reader);
    }

    @Test
    public void countReader() {
        int n =  readerService.countReader(2);
        System.out.println(n);
    }
}