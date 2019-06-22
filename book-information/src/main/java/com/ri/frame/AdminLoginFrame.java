package com.ri.frame;

import com.ri.entrty.Student;
import com.ri.factory.DAOFactory;
import com.ri.factory.ServiceFactory;
import com.ri.ui.ImgPanel;
import com.ri.utils.ResultEntity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AdminLoginFrame extends JFrame {
    private ImgPanel rootPanel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JRadioButton 管理员RadioButton;
    private JRadioButton 学生RadioButton;
    private JButton 登录Button;
    private JButton 取消Button;


    public AdminLoginFrame() {
        rootPanel.setFileName("34.png");
        rootPanel.repaint();
        setTitle("管理员登陆界面");
        setContentPane(rootPanel);
        setSize(918, 626);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);

        ButtonGroup group = new ButtonGroup();
        group.add(学生RadioButton);
        group.add(管理员RadioButton);

        登录Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (管理员RadioButton.isSelected()) {
                    //获得输入的账号密码
                    String account = accountField.getText().trim();
                    String password = new String(passwordField.getPassword()).trim();
                    ResultEntity resultEntity = ServiceFactory.getAdminServiceInstance().adminLogin(account, password);
                    JOptionPane.showMessageDialog(rootPanel, resultEntity.getMessage());

                    //  登录成功，进入主界面，并关闭登录界面
                    if (resultEntity.getCode() == 0) {
                        try {
                            new AdminMainFrame1(DAOFactory.getAdminDAOInstance().getAdminByAccount(account));
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        AdminLoginFrame.this.dispose();

                    } else if (resultEntity.getCode() == 1) {
                        // 密码错误，清空密码框
                        passwordField.setText("");

                    }
                }
                if (学生RadioButton.isSelected()) {
                    //获得输入的账号密码
                    String account1 = accountField.getText().trim();
                    String password1 = new String(passwordField.getPassword()).trim();
                    //员工登录
                    ResultEntity resultEntity1 = ServiceFactory.getStudentServiceInstance().stuLogin(account1, password1);
                    JOptionPane.showMessageDialog(rootPanel, resultEntity1.getMessage());
                    Student student = new Student();

                    //登录成功，进入主界面，并关闭登录界面
                    if (resultEntity1.getCode() == 0) {
                        try {
                            new AdminMainFrame2(DAOFactory.getStudentDAOInstance().getStuLoginByAccount(account1));
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        AdminLoginFrame.this.dispose();

                    } else if (resultEntity1.getCode() == 1) {
                        //密码错误，清空密码框
                        passwordField.setText("");
                    } else {
                        //账号错误，清空两个输入框
                        accountField.setText("");
                        passwordField.setText("");
                    }
                }
            }
        });
        取消Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminLoginFrame.this.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new AdminLoginFrame();
    }
}
