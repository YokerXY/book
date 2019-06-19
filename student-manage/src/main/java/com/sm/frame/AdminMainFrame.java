package com.sm.frame;

import com.eltima.components.ui.DatePicker;
import com.sm.entity.*;
import com.sm.factory.ServiceFactory;
import com.sm.ui.ImgPanel;
import com.sm.utils.AliOSSUtil;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.YES_OPTION;

public class AdminMainFrame extends JFrame {
    private ImgPanel rootPanel;
    private JButton 院系管理Button;
    private JButton 奖惩管理Button;
    private JButton 班级管理Button;
    private JButton 学生管理Button;
    private JPanel centerPanel;
    private JPanel departmentPanel;
    private JPanel classPanel;
    private JPanel studentPanel;
    private JPanel rewardPunishPanel;
    private JPanel topPanel;
    private JButton 新增院系Button;
    private JButton 刷新数据Button;
    private JPanel leftPanel;
    private JTextField depNameField;
    private JButton 选择logo图Button;
    private JButton 新增Button;
    private JScrollPane scrollPane;
    private JPanel contentPanel;
    private JTextField deNameField;
    private JLabel logoLabel;
    private JComboBox<Department> depcomboBox;
    private JTextField CClassNameField;
    private JButton 新增班级Button;
    private JPanel treePanel;
    private JPanel classContentPanel;
    private JPanel stuTopPanel;
    private JComboBox<Department> comboBox1;
    private JComboBox<CClass> comboBox2;
    private JTextField searchField;
    private JButton 新增学生Button;
    private JTextField stuAddresssField;
    private JTextField stuPhoneField;
    private JButton 编辑Button;
    private JPanel tablePanel;
    private ImgPanel infoPanel;
    private JLabel stuIdLabel;
    private JLabel stuDepLabel;
    private JLabel stuClassLabel;
    private JLabel stuNameLabel;
    private JLabel stuGenderLabel;
    private JLabel stuBirLabel;
    private JLabel stuAvatarLabel;
    private JButton 初始化数据Button;
    private JButton 搜索Button;
    private JTextField rp搜索Field2;
    private JButton 搜索Btn;
    private JButton 刷新Button;
    private JComboBox comboBox5;
    private JComboBox comboBox3;
    private JButton 奖励增加完成Button;
    private JComboBox comboBox4;
    private JButton 惩处记录增加完成Button;
    private JButton timeBtn;
    private JPanel rewardsPanel;
    private JPanel punishmentsPanel;
    private JLabel 姓名Label;
    private JLabel 院系Label;
    private JLabel 性别Label;
    private JLabel 班级Label;
    private Admin admin;
    private String uploadFileUrl;
    private File file;
    private  int departmentId = 0;
    private  int row;


    public AdminMainFrame(Admin admin) {
        final DatePicker datepick;
        datepick = getDatePicker();
        timeBtn.add(datepick);
        this.admin = admin;
        //窗体的基本属性
        rootPanel.setFileName("23.jpg");
        setTitle("管理员主界面");
        setContentPane(rootPanel);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        //
        showDepartments();

        //获取centerPanel的布局,获得是LayoutManger，向下转型为CardLayout
        final CardLayout cardLayout = (CardLayout) centerPanel.getLayout();

        院系管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "Card1");
            }
        });
        班级管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "Card2");
                showClassPanel();
            }
        });
        学生管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel,"Card3");
                infoPanel.setFileName("123.jpg");
                infoPanel.repaint();
                List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().selectAll();
                showStudentTable(studentList);


                Department tip1 = new Department();
                tip1.setDepartmentName("请选择院系");
                comboBox1.addItem(tip1);
                CClass tip2 = new CClass();
                tip2.setClassName("请选择班级");
                comboBox2.addItem(tip2);

                List<Department> departmentList = ServiceFactory.getDepartmentServiceInstance().selectAll();
                for (Department department : departmentList) {
                    comboBox1.addItem(department);
                }
                List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectAll();
                for (CClass cClass : cClassList) {
                    comboBox2.addItem(cClass);
                }


            }
        });
        新增院系Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = leftPanel.isVisible();
                if (flag == true) {
                    leftPanel.setVisible(false);
                } else {
                    leftPanel.setVisible(true);
                }
            }
        });
        刷新数据Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDepartments();
            }
        });
        新增Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //上传文件到OSS并返回外链
                uploadFileUrl = AliOSSUtil.ossUpload(file);
                //创建Department对象，并设置相应属性
                Department department = new Department();
                department.setDepartmentName(depNameField.getText().trim());
                department.setLogo(uploadFileUrl);
                //调用service实现新增功能
                int n = ServiceFactory.getDepartmentServiceInstance().addDepartment(department);
                if (n == 1) {
                    JOptionPane.showMessageDialog(rootPanel, "新增院系成功");
                    //新增成功后，将侧边栏隐藏
                    leftPanel.setVisible(false);
                    //刷新界面数据
                    showDepartments();
                    //将图片预览标签隐藏
                    logoLabel.setVisible(false);
                    //将选择图片的按钮可见
                    选择logo图Button.setVisible(true);
                    //清空文本框
                    depNameField.setText("");
                } else {
                    JOptionPane.showMessageDialog(rootPanel, "新增院系失败");
                }
            }
        });

        选择logo图Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("D:"));
                int result = fileChooser.showOpenDialog(rootPanel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    //选中文件
                    file = fileChooser.getSelectedFile();
                    //通过文件创建icon对象
                    ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                    icon.setImage(icon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
                    //通过标签显示图片
                    logoLabel.setIcon(icon);
                    //设置标签可见
                    logoLabel.setVisible(true);
                    //将按钮隐藏
                    选择logo图Button.setVisible(false);
                }
            }
        });
        logoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("D:"));
                int result = fileChooser.showOpenDialog(rootPanel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    //选中文件
                    file = fileChooser.getSelectedFile();
                    //通过文件创建icon对象
                    ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                    icon.setImage(icon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
                    //通过标签显示图片
                    logoLabel.setIcon(icon);
                    //设置标签可见
                    logoLabel.setVisible(true);
                    //将按钮隐藏
                    选择logo图Button.setVisible(false);

                }
            }
        });
        depcomboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //得到选中项的索引
                int index = depcomboBox.getSelectedIndex();
                //按照索引取出项，就是一个Department对象，然后取出其id备用
                departmentId = depcomboBox.getItemAt(index).getId();
            }
        });
        新增班级Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("1");
                CClass  cClass = new CClass();
                cClass.setDepartmentId(departmentId);
                cClass.setClassName(CClassNameField.getText().trim());
                int n = ServiceFactory.getCClassServiceInstance().addCClass(cClass);
                if (n==1){
                    JOptionPane.showMessageDialog(classContentPanel,"新增班级成功");
                    showClassPanel();
                    CClassNameField.setText("");
                }else {
                    System.out.println("新增班级失败");
                }
            }
        });

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    int index = comboBox1.getSelectedIndex();
                    if (index != 0) {
                        departmentId =comboBox1.getItemAt(index).getId();
                        List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().selectByDepartmentId(departmentId);
                        showStudentTable(studentList);

                        List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectByDepartmentId(departmentId);
                        comboBox2.removeAllItems();
                        CClass tip = new CClass();
                        tip.setClassName("请选择班级");
                        comboBox2.addItem(tip);
                        for (CClass cClass : cClassList){
                            comboBox2.addItem(cClass);
                        }
                    }
                }
            }
        });
        comboBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() ==ItemEvent.SELECTED){
                    int index = comboBox2.getSelectedIndex();
                    if (index !=0){
                        int classId = comboBox2.getItemAt(index).getId();
                        List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().selectByClassId(classId);
                        showStudentTable(studentList);
                    }
                }
            }
        });
        初始化数据Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().selectAll();
                showStudentTable(studentList);

                    comboBox1.setSelectedIndex(0);
                    comboBox2.removeAllItems();

                    CClass tip = new CClass();
                    tip.setClassName("请选择班级");
                    comboBox2.addItem(tip);

                    List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectAll();
                    for (CClass cClass : cClassList){
                        comboBox2.addItem(cClass);
                    }

                    stuIdLabel.setText("未选择");
                    stuDepLabel.setText("未选择");
                    stuClassLabel.setText("未选择");
                    stuNameLabel.setText("未选择");
                    stuGenderLabel.setText("未选择");
                    stuAddresssField.setText("未选择");
                    stuPhoneField.setText("未选择");
                    stuBirLabel.setText("未选择");
                    stuAvatarLabel.setText("<html>< img src=’https://student1.oss-cn-shanghai.aliyuncs.com/logo/photo1.jpg'/></html>");

                }
        });
        搜索Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              String keywords = searchField.getText().trim();
              List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().selectByKeywords(keywords);
              if ( studentList != null){
                  showStudentTable(studentList);
              }
            }
        });
        新增学生Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             new AdminInsertFrame(AdminMainFrame.this);
            }
        });
        奖惩管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel,"Card4");
            }
        });
        rp搜索Field2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rp搜索Field2.setText("");

            }
        });
        搜索Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int m = ServiceFactory.getStudentServiceInstance().selectRewardsById(rp搜索Field2.getText()).size();
                int n = ServiceFactory.getStudentServiceInstance().selectPunishmentsById(rp搜索Field2.getText()).size();
                if (m != 0 & n != 0){
                    String id =rp搜索Field2.getText().trim();
                    List<StudentRewards> studentList= ServiceFactory.getStudentServiceInstance().selectRewardsById(id);
                    List<StudentPunishments> studentPunishmentsList= ServiceFactory.getStudentServiceInstance().selectPunishmentsById(id);
                    if (studentList!=null){
                        showRewards(studentList);
                        showPunishments(studentPunishmentsList);
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "查无此学生", null, JOptionPane.ERROR_MESSAGE);
                    try {
                        Thread.sleep(800);
                        rp搜索Field2.setText("请输入你要查询的学生姓名或者学号");
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }

            }
        });
        刷新Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<StudentRewards> studentList= ServiceFactory.getStudentServiceInstance().selectRewardsById(rp搜索Field2.getText());
                List<StudentPunishments> studentPunishments= ServiceFactory.getStudentServiceInstance().selectPunishmentsById(rp搜索Field2.getText());
                showRewards(studentList);
                showPunishments(studentPunishments);
            }
        });
        comboBox5.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int index = comboBox5.getSelectedIndex();
                if (index == 0){
                    comboBox4.setVisible(true);
                    timeBtn.setVisible(true);
                }
                if (index == 1){
                    comboBox3.setVisible(true);
                    timeBtn.setVisible(true);
                }
            }
        });
        comboBox3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int index = comboBox3.getSelectedIndex();
                if (index == 1){
                    奖励增加完成Button.setVisible(true);
                }
                if (index == 2){
                    奖励增加完成Button.setVisible(true);
                }
                if (index == 3){
                    奖励增加完成Button.setVisible(true);
                }
                if (index == 4){
                    奖励增加完成Button.setVisible(true);
                }
                if (index == 5){
                    奖励增加完成Button.setVisible(true);
                }
            }
        });
        奖励增加完成Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "奖励增加完成 ", null, INFORMATION_MESSAGE);
                StudentRewards rewards = new StudentRewards();
                rewards.setPrimaryId(ServiceFactory.getStudentServiceInstance().countRewards()+1);
                rewards.setId(rp搜索Field2.getText());
                int index = comboBox3.getSelectedIndex();
                if (index == 0){
                    rewards.setRewards("国家奖学金");
                }
                if (index == 1){
                    rewards.setRewards("国家励志奖学金");
                }
                if (index == 2){
                    rewards.setRewards("感动中国青年");
                }
                if (index == 3){
                    rewards.setRewards("劳动模范");
                }

                rewards.setRewardsDate((Date) datepick.getValue());
                try {
                    ServiceFactory.getStudentServiceInstance().insertRewards(rewards);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                rewardsPanel.revalidate();
                comboBox3.setVisible(false);
                timeBtn.setVisible(false);
                奖励增加完成Button.setVisible(false);
            }
        });
        comboBox4.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int index = comboBox4.getSelectedIndex();
                if (index ==1){
                    惩处记录增加完成Button.setVisible(true);
                }
                if (index ==2){
                    惩处记录增加完成Button.setVisible(true);
                }
                if (index ==3){
                    惩处记录增加完成Button.setVisible(true);
                }
                if (index ==4){
                    惩处记录增加完成Button.setVisible(true);
                }
            }
        });
        惩处记录增加完成Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "惩处记录增加完成 ", null, INFORMATION_MESSAGE);

                StudentPunishments punishments = new StudentPunishments();
                punishments.setPrimaryId(ServiceFactory.getStudentServiceInstance().countPunishments()+1);
                punishments.setId(rp搜索Field2.getText());
                int index = comboBox4.getSelectedIndex();
                if (index == 0){
                    punishments.setPunishments("劝退");
                }
                if (index == 1){
                    punishments.setPunishments("留校察看");
                }
                if (index == 2){
                    punishments.setPunishments("记过");
                }
                if (index == 3){
                    punishments.setPunishments("警告处分");
                }
                punishments.setPunishmentsDate((Date) datepick.getValue());
                try {
                    ServiceFactory.getStudentServiceInstance().insertPunishments(punishments);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                punishmentsPanel.revalidate();
                comboBox4.setVisible(false);
                timeBtn.setVisible(false);
                惩处记录增加完成Button.setVisible(false);
            }
        });
    }
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        new AdminMainFrame(new Admin());
    }
    private static DatePicker getDatePicker() {
        final DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyy-MM-dd";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times New Roman", Font.BOLD, 14);
        Dimension dimension = new Dimension(177, 24);
        int[] hilightDays = { 1, 3, 5, 7 };
        int[] disabledDays = { 4, 6, 5, 9 };
        //构造方法（初始时间，时间显示格式，字体，控件大小）
        datepick = new DatePicker(date, DefaultFormat, font, dimension);
        datepick.setLocation(137, 83);//设置起始位置
    /*
    //也可用setBounds()直接设置大小与位置
    datepick.setBounds(137, 83, 177, 24);
    */
        // 设置一个月份中需要高亮显示的日子
        datepick.setHightlightdays(hilightDays, Color.red);
        // 设置一个月份中不需要的日子，呈灰色显示
        datepick.setDisableddays(disabledDays);
        // 设置国家
        datepick.setLocale(Locale.CANADA);
        // 设置时钟面板可见
        datepick.setTimePanleVisible(true);
        return datepick;
    }

    private void showDepartments() {
//移除原有数据
        contentPanel.removeAll();
//从service层获取到所有院系列表
        List<Map> departmentList = ServiceFactory.getDepartmentServiceInstance().selectDepartmentInfo();
        GridLayout gridLayout = new GridLayout(0, 1, 10, 10);
        contentPanel.setLayout(gridLayout);
        for (Map map : departmentList) {
            //给每个院系对象创建一个面板
            JPanel depPanel = new JPanel();
            Department department = (Department) map.get("department");
            int classCount = (int) map.get("classCount");
            int studentCount = (int) map.get("studentCount");
            depPanel.setPreferredSize(new Dimension(300, 300));
            //将院系名称设置给面板标题
            depPanel.setBorder(BorderFactory.createTitledBorder(department.getDepartmentName()));
            //新建一个Label用来放置院系logo，并指定大小
            logoLabel = new JLabel("<html><img src='"+ department.getLogo() + "'width=200 height=200/></html>");
            //右点击图片删除
            JPopupMenu jPopupMenu = new JPopupMenu();
            JMenuItem item = new JMenuItem("删除");
            jPopupMenu.add(item);
            logoLabel.add(jPopupMenu);
            logoLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 3) {
                        jPopupMenu.show(depPanel, e.getX(), e.getY());
                        item.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int n = JOptionPane.showConfirmDialog(null, "确定要删除这行数据吗？", "删除警告",
                                        YES_OPTION);
                                if (n == YES_OPTION) {
                                    contentPanel.remove(depPanel);
                                    contentPanel.repaint();
                                    ServiceFactory.getDepartmentServiceInstance().deledeDapartment(department.getId());
                                }
                            }
                        });
                    }
                }
            });
            //图标标签加入院系面板
            depPanel.add(logoLabel);
            //统计数据加入院系面板
            JLabel infoLabel = new JLabel("班级" + classCount + "个，学生" + studentCount + "人");
            depPanel.add(infoLabel);
//院系面板加入主体内容面板
            contentPanel.add(depPanel);
//刷新主体内容面板
            contentPanel.revalidate();
        }
        //删除功能键
    }
    private void showClassPanel() {
        List<Department> departmentList = ServiceFactory.getDepartmentServiceInstance().selectAll();
        showCombobox(departmentList);
        showTree(departmentList);
        showClasses(departmentList);

    }

    private void showCombobox(List<Department> departmentList) {
        for (Department department : departmentList) {
            depcomboBox.addItem(department);
        }
    }

    private void showTree(List<Department> departmentList) {
        treePanel.removeAll();
        //左侧树形结构根节点
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("南工院");
        for (Department department : departmentList) {
            DefaultMutableTreeNode group = new DefaultMutableTreeNode(department.getDepartmentName());
            top.add(group);
            List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectByDepartmentId(department.getId());
            for (CClass cClass : cClassList) {
                int num = ServiceFactory.getStudentServiceInstance().countStudentByClassId(cClass.getId());
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(cClass.getClassName() + "  :" + num + "人");
                group.add(node);
            }
        }
        final JTree tree = new JTree(top);
        tree.setRowHeight(30);
        tree.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        treePanel.add(tree);
        treePanel.revalidate();
    }
   public void showStudentTable(List<StudentVO> studentList){
        tablePanel.removeAll();
        //创建表格
        JTable table = new JTable();
        //表格数据模型
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        //表头内容
        model.setColumnIdentifiers(new String[]{"学号","院系","班级","姓名Label","性别","地址","手机号","出生日期","头像"});
        //遍历List,转成Object数组
        for (StudentVO student :studentList){
            Object[] object = new Object[]{student.getId(),student.getDepartmentName(),student.getClassName(),student.getStudentName(),student.getGender(),
                    student.getAddress(),student.getPhone(),student.getBirthday(),student.getAvatar()};
            model.addRow(object);
        }
        //将最后一行隐藏头像地址不显示在表格中
        TableColumn tc = table.getColumnModel().getColumn(8);
        tc.setMinWidth(0);
        tc.setMaxWidth(0);

        //获得表头
        JTableHeader head = table.getTableHeader();
        //表头居中
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        head.setDefaultRenderer(hr);
        //设置表头大小
        head.setPreferredSize(new Dimension(head.getWidth(),28));
        //设置表格字体
        head.setFont(new Font("楷体",Font.PLAIN,17));
        //设置表格行高
        table.setRowHeight(35);
        //表格背景色
        table.setBackground(new Color(223,241,234));
        //表格内容居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class,r);

        //表格加入滚动面板，水平垂直方向带滚动条
        JScrollPane scrollPane = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tablePanel.add(scrollPane);
        tablePanel.revalidate();
        //弹出菜单
        JPopupMenu jPopupMenu = new JPopupMenu();
        JMenuItem item = new JMenuItem("删除");
        jPopupMenu.add(item);
        table.add(jPopupMenu);
        //表格内容选择监听，点击一行，在右边显示这个学生信息
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                row = table.getSelectedRow();
                stuIdLabel.setText(table.getValueAt(row,0).toString());
                stuDepLabel.setText(table.getValueAt(row,1).toString());
                stuClassLabel.setText(table.getValueAt(row,2).toString());
                stuNameLabel.setText(table.getValueAt(row,3).toString());
                stuGenderLabel.setText(table.getValueAt(row,4).toString());
                stuAddresssField.setText(table.getValueAt(row,5).toString());
                stuPhoneField.setText(table.getValueAt(row,6).toString());
                stuBirLabel.setText(table.getValueAt(row,7).toString());
                stuAvatarLabel.setText("<html><img src='"+table.getValueAt(row,8).toString()+"' width=200 height=200/></html>");
                编辑Button.setVisible(true);
                编辑Button.setText("编辑");
                编辑Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //如果按钮文字是“编辑”，就激活两个文本框，并将按钮文字设置为“保存”
                        if (e.getActionCommand().equals("编辑")){
                            stuAddresssField.setEditable(true);
                            stuAddresssField.setEnabled(true);
                            stuPhoneField.setEditable(true);
                            stuPhoneField.setEnabled(true);
                            编辑Button.setText("保存");
                        }
                        //如果按钮文字为“保存”,则通过输入内容创建需要修改的Student对象，调用service进行信息更新
                        if (e.getActionCommand().equals("保存")){
                            Student student = new Student();
                            student.setId(stuIdLabel.getText());
                            student.setAddress(stuAddresssField.getText());
                            student.setPhone(stuPhoneField.getText());
                            int n = ServiceFactory.getStudentServiceInstance().updateStudent(student);
                            if (n == 1){
                                //更新表格中对性的地址、电话单元格内容
                                model.setValueAt(stuAddresssField.getText(),row,5);
                                model.setValueAt(stuPhoneField.getText(),row,6);
                                //文本框恢复成不可用状态
                                stuAddresssField.setEditable(false);
                                stuAddresssField.setEnabled(false);
                                stuPhoneField.setEditable(false);
                                stuPhoneField.setEnabled(false);
                                //按钮文字恢复成“编辑”
                                编辑Button.setText("编辑");
                                table.revalidate();
                            }

                        }
                    }
                });
                //右键弹出菜单
                if (e.getButton() == 3){
                    jPopupMenu.show(table,e.getX(),e.getY());
                }
            }
        });
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = (String) table.getValueAt(row,0);
                int choice = JOptionPane.showConfirmDialog(tablePanel,"确认删除吗？");
                if (choice == 0){
                    if (row != -1){
                        model.removeRow(row);
                    }
                    //刷新表格数据
                    //model.fireTableDataChanged();
                    ServiceFactory.getStudentServiceInstance().deleteStudent(id);
                }
            }
        });

    }
    private void showClasses(List<Department> departmentList) {
        classContentPanel.removeAll();
        //右侧流式布局显示
        Font titleFont = new Font("微软雅黑", Font.PLAIN, 22);
        for (Department department:departmentList) {
            ImgPanel depPanel = new ImgPanel();
            depPanel.setFileName("1111.jpg");
            depPanel.repaint();
            depPanel.setPreferredSize(new Dimension(350,500));
            depPanel.setLayout(null);
            JLabel depNameLabel = new JLabel(department.getDepartmentName());
            depNameLabel.setFont(titleFont);
            depNameLabel.setBounds(130,15,200,30);
            //获得这个院系的所有数据
            List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectByDepartmentId(department.getId());
            //数据模型
            DefaultListModel listModel = new DefaultListModel();
            //遍历班级集合，以此加入数据模型
            for (CClass cClass:cClassList) {
                listModel.addElement(cClass);
            }
            //使用数据模型创建一个JList组件
            JList<CClass> jList = new JList<>(listModel);
            jList.setBackground(new Color(0xC1E5E8));
            //使用数据模型创建一个JList组件
            JPopupMenu jPopupMenu = new JPopupMenu();
//            JMenuItem item1 = new JMenuItem("修改");
            JMenuItem item2 = new JMenuItem("删除");
//            jPopupMenu.add(item1);

            jPopupMenu.add(item2);
            jList.add(jPopupMenu);
            jList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int index = jList.getSelectedIndex();
                    if (e.getButton() == 1) {
                        jPopupMenu.show(jList, e.getX(), e.getY());
                        CClass cClass = jList.getModel().getElementAt(index);
                        item2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int choice = JOptionPane.showConfirmDialog(depPanel, "确定删除吗？");
                                if (choice == 0) {
                                    ServiceFactory.getCClassServiceInstance().deleteCClass(cClass.getId());
                                    listModel.remove(index);
                                    showClassPanel();
                                }
                            }
                        });
                    }
                }
            });
            //JList加入滚动面板
            JScrollPane listScrollPane = new JScrollPane(jList);
            listScrollPane.setBounds(90,120,200,260);
            depPanel.add(depNameLabel);
            depPanel.add(listScrollPane);
            classContentPanel.add(depPanel);
        }

    }
    private void showRewards(List<StudentRewards> studentList){
        Font font = new Font("微软雅黑",Font.BOLD,18);
        //移除原有数据
        rewardsPanel.removeAll();
        for (StudentRewards student : studentList){
            姓名Label.setText("姓名："+student.getStudentName());
            性别Label.setText("性别："+student.getGender());
            班级Label.setText("班级："+student.getClassName());
            院系Label.setText("院系："+student.getDepartmentName());
        }
        List<StudentRewards> rewardsList = ServiceFactory.getStudentServiceInstance().selectRewardsById(rp搜索Field2.getText());
        int len = rewardsList.size();
        int row = len % 1== 0 ? len / 1 : len / 1 + 1;
        GridLayout gridLayout = new GridLayout(row, 1, 0, 15);
        rewardsPanel.setLayout(gridLayout);
        for (StudentRewards studentRewards : rewardsList) {
            //给每个院系对象创建一个面板
            JPanel allPanel = new JPanel();
//            FlowLayout flowLayout = new FlowLayout();
//            flowLayout.setAlignment(FlowLayout.LEFT);
//            flowLayout.setHgap(0);
//            allPanel.setLayout(flowLayout);
            allPanel.setPreferredSize(new Dimension(300, 400));
            //将院系名称设置给面板标题
            allPanel.setBorder(BorderFactory.createTitledBorder(String.valueOf(studentRewards.getRewardsDate())));
            JLabel jLabel = new JLabel(studentRewards.getRewards());
            allPanel.add(jLabel);
            rewardsPanel.add(allPanel);
            //刷新主体内容面板
            rewardsPanel.revalidate();
        }
    }
    private void showPunishments(List<StudentPunishments> studentList){
        Font font = new Font("微软雅黑",Font.BOLD,18);
        punishmentsPanel.removeAll();
        List<StudentPunishments> punishmentsList = ServiceFactory.getStudentServiceInstance().selectPunishmentsById(rp搜索Field2.getText());
        int len = punishmentsList.size();
        int row = len % 1== 0 ? len / 1 : len / 1 + 1;
        GridLayout gridLayout = new GridLayout(row, 1, 0, 15);
        punishmentsPanel.setLayout(gridLayout);
        for (StudentPunishments studentPunishments : punishmentsList) {
            //给每个院系对象创建一个面板
            JPanel rightPanel = new JPanel();
//            FlowLayout flowLayout = new FlowLayout();
//            flowLayout.setAlignment(FlowLayout.LEFT);
//            flowLayout.setHgap(0);
//            allPanel.setLayout(flowLayout);
            rightPanel.setPreferredSize(new Dimension(300, 400));
            //将院系名称设置给面板标题
            rightPanel.setBorder(BorderFactory.createTitledBorder(String.valueOf(studentPunishments.getPunishmentsDate())));
            JLabel jLabel = new JLabel(studentPunishments.getPunishments());
            rightPanel.add(jLabel);
            punishmentsPanel.add(rightPanel);
            //刷新主体内容面板
            punishmentsPanel.revalidate();
            rightPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int n = JOptionPane.showConfirmDialog(null,"确认删除吗？","警告",JOptionPane.YES_NO_OPTION);
                    if (n == YES_OPTION){
                        punishmentsPanel.remove(rightPanel);
                        punishmentsPanel.repaint();
                        ServiceFactory.getStudentServiceInstance().deletePunishmentsByPrimaryId(studentPunishments.getPrimaryId());
                        punishmentsPanel.revalidate();
                    }
                }
            });
        }
    }
}
