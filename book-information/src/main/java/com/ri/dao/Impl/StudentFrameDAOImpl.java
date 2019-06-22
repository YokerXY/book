package com.ri.dao.Impl;

import com.ri.dao.StudentFrameDAO;
import com.ri.entrty.*;
import com.ri.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentFrameDAOImpl implements StudentFrameDAO {
    @Override
    public List<BorrowVO> getBorrowByStudentAccount(String account) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.`student_name`,t1.`reader_id`,t3.`account`,t4.`book_name`,t4.`book_id`,t2.`borrow_time`,t4.`img_url`,t4.`book_name`,t4.`introduction`,t4.`author`\n" +
                "FROM t_student t1\n" +
                "LEFT JOIN t_borrow t2\n" +
                "ON t1.`student_id` =t2.`student_id`\n" +
                "LEFT JOIN t_studentlogin t3\n" +
                "ON t3.`student_id` = t1.`student_id`\n" +
                "LEFT JOIN t_book t4\n" +
                "ON t4.`book_id` = t2.`book_id`\n" +
                "WHERE t3.`account` = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, account);
        ResultSet rs = pstmt.executeQuery();
        List<BorrowVO> borrowVOList = convert1(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return borrowVOList;
    }

    @Override
    public List<ReturnVO> getReturnByStudentAccount(String account) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.`student_name`,t1.`student_id`,t3.`account`,t4.`book_name`,t4.`book_id`,t2.`return_time`,t4.`img_url`,t4.`book_name`,t4.`introduction`,t4.`author`\n" +
                "FROM t_student t1\n" +
                "LEFT JOIN t_return t2\n" +
                "ON t1.`student_id` =t2.`student_id`\n" +
                "LEFT JOIN t_studentlogin t3\n" +
                "ON t3.`student_id` = t1.`student_id`\n" +
                "LEFT JOIN t_book t4\n" +
                "ON t4.`book_id` = t2.`book_id`\n" +
                "WHERE t3.`account` = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, account);
        ResultSet rs = pstmt.executeQuery();
        List<ReturnVO> returnVOList = convert2(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return returnVOList;
    }

    @Override
    public int deleteStudentBorrowByStudentIdBookId(String studentId, String bookId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "DELETE FROM t_borrow \n" +
                "WHERE student_id = ? AND book_id = ?";
        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, studentId);
        psmt.setString(2, bookId);
        return psmt.executeUpdate();
    }

    @Override
    public int insertReturn(InsertReturn insertReturn) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_return(student_id,book_id,return_time) VALUES (?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, insertReturn.getStudentID());
        pstmt.setString(2, insertReturn.getBookId());
        pstmt.setString(3, insertReturn.getReturnDate());
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public int insetBorrow(InsertBorrow insertBorrow) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_borrow(student_id,book_id,borrow_time) VALUES (?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, insertBorrow.getStudentId());
        pstmt.setString(2, insertBorrow.getBorrowBookId());
        pstmt.setString(3, insertBorrow.getBorrowTime());
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public List<Introduction> getInformationByBookId(String bookId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.`introduction`\n" +
                "FROM t_book t1\n" +
                "WHERE t1.`book_id`=?\n";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, bookId);
        ResultSet rs = pstmt.executeQuery();
        List<Introduction> introductionList = convert4(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return introductionList;
    }

    @Override
    public List<Avatar> getAvatarByBookId(String bookId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.`img_url`\n" +
                "FROM t_book t1\n" +
                "WHERE t1.`book_id`=?\n";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, bookId);
        ResultSet rs = pstmt.executeQuery();
        List<Avatar> avatarList = convert5(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return avatarList;
    }

    @Override
    public List<BookName> getBookName(String bookId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.`book_name`\n" +
                "FROM t_book t1\n" +
                "WHERE t1.`book_id`=?\n";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, bookId);
        ResultSet rs = pstmt.executeQuery();
        List<BookName> bookNameList = convert6(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return bookNameList;
    }

    @Override
    public List<Author> getAuthor(String bookId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.`author`\n" +
                "FROM t_book t1\n" +
                "WHERE t1.`book_id`=?\n";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, bookId);
        ResultSet rs = pstmt.executeQuery();
        List<Author> authorList = convert7(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return authorList;
    }

    @Override
    public int countBooks() throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT COUNT(book_id) FROM t_book\n";
        PreparedStatement psmt = connection.prepareStatement(sql);
        ResultSet rs = psmt.executeQuery();
        int rowCount = 0;
        if (rs.next()) {
            rowCount = rs.getInt(1);
        }
        rs.close();
        psmt.close();
        jdbcUtil.closeConnection();
        return rowCount;
    }

    @Override
    public List<Book> selectBooksByKeywords(String keywords) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_book\n" +
                "WHERE book_id LIKE ? OR book_name LIKE ? OR author LIKE ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, keywords );
        pstmt.setString(2, "%" + keywords + "%");
        pstmt.setString(3, "%" + keywords + "%");
        ResultSet rs = pstmt.executeQuery();
        List<Book> bookList = convert8(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return bookList;
    }

    @Override
    public List<Book> selectBooksByTypeId(int typeId) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_book\n" +
                "WHERE type_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, typeId);
        ResultSet rs = pstmt.executeQuery();
        List<Book> bookList = convert8(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return bookList;
    }

    @Override
    public int countselectBooksByKeywords(String keywords) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT COUNT(*) FROM t_book\n" +
                "WHERE book_id LIKE ? OR book_name LIKE ? OR author LIKE ?";
        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1,keywords);
        psmt.setString(2,"%" + keywords + "%");
        psmt.setString(3,"%" + keywords + "%");
        ResultSet rs = psmt.executeQuery();
        int rowCount = 0;
        if (rs.next()){
            rowCount = rs.getInt(1);
        }
        rs.close();
        psmt.close();
        jdbcUtil.closeConnection();
        return rowCount;

    }
    private List<BorrowVO> convert1(ResultSet rs) throws SQLException {
        List<BorrowVO> brvoList = new ArrayList<>();
        while (rs.next()) {
            BorrowVO brvo = new BorrowVO();
            brvo.setAccount(rs.getString("account"));
            brvo.setStudentId(rs.getString("student_id"));
            brvo.setBorrowBookId(rs.getString("book_id"));
            brvo.setBorrowBookName(rs.getString("book_name"));
            brvo.setBorrowTime(rs.getDate("borrow_time"));
            brvo.setBorrowBookAuthor(rs.getString("author"));
            brvoList.add(brvo);
        }
        return brvoList;
    }
    private List<ReturnVO> convert2(ResultSet rs) throws SQLException {
        List<ReturnVO> returnVOList = new ArrayList<>();
        while (rs.next()) {
            ReturnVO returnVO = new ReturnVO();
            returnVO.setBookId(rs.getString("book_id"));
            returnVO.setReturnBookName(rs.getString("book_name"));
            returnVO.setReturnDate(rs.getDate("return_time"));
            returnVO.setStudentID(rs.getString("student_id"));
            returnVOList.add(returnVO);
        }
        return returnVOList;
    }
    private List<Introduction> convert4(ResultSet rs) throws SQLException {
        List<Introduction> introductionList = new ArrayList<>();
        while (rs.next()){
            Introduction introduction = new Introduction();
            introduction.setInformation(rs.getString("introduction"));
            introductionList.add(introduction);
        }
        return introductionList;
    }
    private List<Avatar> convert5(ResultSet rs) throws SQLException {
        List<Avatar> avatarList = new ArrayList<>();
        while (rs.next()){
            Avatar avatar = new Avatar();
            avatar.setAvatar(rs.getString("img_url"));
            avatarList.add(avatar);
        }
        return  avatarList;
    }
    private List<BookName> convert6(ResultSet rs) throws SQLException {
        List<BookName> bookNameList = new ArrayList<>();
        while (rs.next()){
            BookName bookName = new BookName();
            bookName.setBookName(rs.getString("book_name"));
            bookNameList.add(bookName);
        }
        return  bookNameList;
    }
    private List<Author> convert7(ResultSet rs) throws SQLException {
        List<Author> authorList = new ArrayList<>();
        while (rs.next()){
            Author author = new Author();
            author.setAuthor(rs.getString("author"));
            authorList.add(author);
        }
        return  authorList;
    }
    private List<Book> convert8(ResultSet rs) throws SQLException {
        List<Book> bookList = new ArrayList<>();
        while (rs.next()) {
            Book book = new Book();
            book.setAuthor(rs.getString("author"));
            book.setBookName(rs.getString("book_name"));
            book.setStock(rs.getInt("stock"));

            bookList.add(book);
        }
        return bookList;
    }
}
