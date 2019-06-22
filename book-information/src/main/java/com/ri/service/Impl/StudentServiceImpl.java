package com.ri.service.Impl;

import com.ri.dao.StudentDAO;
import com.ri.entrty.Student;
import com.ri.factory.DAOFactory;
import com.ri.service.StudentService;
import com.ri.utils.ResultEntity;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.SQLException;

public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO = DAOFactory.getStudentDAOInstance();

    @Override
    public ResultEntity stuLogin(String account, String password) {
        ResultEntity resultEntity = new ResultEntity();
        Student stuLogin = null;
        try {
            //根据账号查找管理员信息，捕获SQL异常
            stuLogin = studentDAO.getStuLoginByAccount(account);
        } catch (SQLException e) {
            System.err.println("根据账号查找管理员信息出现SQL异常");
        }
//根据账号查找到了记录
        if (stuLogin != null) {
            //比较密码，此时需要将客户端传过来的密码进行MD5加密后才能比对
            if (DigestUtils.md5Hex(password).equals(stuLogin.getPassword())) {
                resultEntity.setCode(0);
                resultEntity.setMessage("登录成功");
                resultEntity.setData(stuLogin);
            } else {  //账号存在，密码输入错误
                resultEntity.setCode(1);
                resultEntity.setMessage("密码错误");
            }
        } else {  //账号不存在
            resultEntity.setCode(2);
            resultEntity.setMessage("账号不存在");
        }
        return resultEntity;
    }

}
