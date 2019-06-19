package com.sm.service;

import com.sm.entity.Reader;
import com.sm.entity.ReaderVO;

import java.util.List;

public interface ReaderService {
    List<ReaderVO> selectAll();
    List<ReaderVO> selectByTypeId(int typeId);
    List<ReaderVO> selectByClassId(int classId);
    List<ReaderVO> selectByKeywords(String keywords);
    int updateReader(Reader reader);
    void deleteReader(String id);
    int insertReader(Reader reader);
    int countReader(int classId);
}
