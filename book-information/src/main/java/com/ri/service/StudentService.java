package com.ri.service;
import com.ri.utils.ResultEntity;


public interface StudentService {
    ResultEntity stuLogin(String account, String password);
}
