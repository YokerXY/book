package com.ri.dao;
import com.ri.entrty.*;
import java.sql.SQLException;
import java.util.List;

public interface StudentFrameDAO {
    /**
     * 根据登录账号查询学生的借书情况
     * @return
     * @throws SQLException
     */
    List<BorrowVO> getBorrowByStudentAccount(String account) throws SQLException;

    /**
     * 根据登录账号查询学生的还书情况
     */
    List<ReturnVO> getReturnByStudentAccount(String  account)throws SQLException;




    /**
     * 根据学生学号和所借的书的id，删除学生借阅记录
     * @param studentId
     * @param bookId
     * @return
     */
    int deleteStudentBorrowByStudentIdBookId(String studentId,String bookId) throws SQLException;

    /**
     * 增加学生还书
     * @param insertReturn
     * @return
     * @throws SQLException
     */
    int insertReturn(InsertReturn insertReturn) throws SQLException;

    /**
     * 增加学生的借书记录
     * @param insertBorrow
     * @return
     * @throws SQLException
     */
    int insetBorrow(InsertBorrow insertBorrow) throws SQLException;



    /**
     * 根据书序号查询书的information
     * @param bookId
     * @return
     * @throws SQLException
     */
    List<Introduction> getInformationByBookId(String bookId) throws SQLException;

    /**
     * 根据书序号查询书的封面图片路径
     * @param bookId
     * @return
     * @throws SQLException
     */
    List<Avatar> getAvatarByBookId(String bookId) throws SQLException;

    /**
     * 根据书序号查询书的名字
     * @param bookId
     * @return
     * @throws SQLException
     */
    List<BookName> getBookName(String bookId) throws SQLException;

    /**
     * 根据书序号查询书的作者
     * @param bookId
     * @return
     * @throws SQLException
     */
    List<Author> getAuthor(String bookId)throws SQLException;


    /**
     * 查询书本数量(一种一本)
     * @return
     * @throws SQLException
     */
    int countBooks() throws SQLException;

    /**
     * 模糊查询（根据关键词：书序号、作者、书名）
     * @param keywords
     * @return
     * @throws SQLException
     */
    List<Book> selectBooksByKeywords(String keywords) throws SQLException;

    /**
     * 根据类别id查询书籍（combobox的实现）
     * @param typeId
     * @return
     * @throws SQLException
     */
    List<Book> selectBooksByTypeId(int typeId) throws SQLException;

    /**
     * 判断关键词所搜索的书籍是否存在
     * @param keywords
     * @return
     * @throws SQLException
     */
    int countselectBooksByKeywords(String keywords)throws SQLException;
}
