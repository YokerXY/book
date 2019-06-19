package com.sm.dao;

import com.sm.entity.ReaderVO;

import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

public interface ReaderDAO {
    /**
     * 查询所有读者（视图对象）
     * @return
     * @throws SQLException
     */
    List<ReaderVO> selectAll() throws SQLException;

    /**
     * 根据类别ID查询所有读者
     * @param typeId
     * @return
     * @throws SQLException
     */
    List<ReaderVO> selectByTypeId(int typeId) throws SQLException;

    /**
     * 根据班级ID查询学生
     * @param classId
     * @return
     * @throws SQLException
     */
    List<ReaderVO> selectByClassId(int classId) throws SQLException;

    /**
     * 根据关键词模糊查询
     * @param keywords
     * @return
     * @throws SQLException
     */
    List<ReaderVO> selectByKeywords(String keywords) throws SQLException;

    /**
     * 更新读者信息
     * @param reader
     * @return
     * @throws SQLException
     */
    int updateReader(com.sm.entity.Reader reader) throws SQLException;

    /**
     * 根据id删除读者
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteById(String id) throws SQLException;

    /**
     * 新增读者
     * @param reader
     * @return
     * @throws SQLException
     */
    int insertReader(com.sm.entity.Reader reader) throws SQLException;

    int countByTypeId(int typeId) throws SQLException;

}
