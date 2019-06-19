package com.sm.frame;

import com.sm.entity.*;
import com.sm.factory.ServiceFactory;
import com.sm.ui.ImgPanel;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AdminMainFrame1 extends  JFrame{
    private ImgPanel rootPanel;
    private JButton bookbutton1;
    private JButton borrowbutton2;
    private JButton accountbutton3;
    private JButton 系统设置Button;
    private JPanel book;
    private JPanel borrow;
    private JPanel forst;
    private JPanel contacPanel;
    private JLabel timerLabel;
    private JLabel xyLabel;
    private JComboBox<Book> comboBox1;
    private JComboBox<com.sm.entity.Type> comboBox2;
    private JTextField searchField;
    private JButton 批量导出Button;
    private JButton 搜索Button;
    private JButton 新增读者Button;
    private JPanel tablePanel;
    private JTextField reaEmailField;
    private JTextField reaMobileField;
    private JButton 编辑Button;
    private JPanel infoPanel;
    private JLabel reaTypeLabel;
    private JLabel reaBookLabel;
    private JLabel reaNameLabel;
    private JLabel reaGenderLabel;
    private JLabel reaJoinLabel;
    private JLabel reaIdLabel;
    private JComboBox depcomboBox;
    private JPanel treePanel;
    private JPanel classContentPanel;
    private  Admin admin;
    private  int typeId = 0;
    private  int row;

    public AdminMainFrame1(Admin adminByAccount) {
        this.admin = adminByAccount;
        setTitle("管理员登陆界面");
        setContentPane(rootPanel);
        setSize(918, 626);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        final CardLayout cardLayout = (CardLayout) contacPanel.getLayout();
        bookbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.repaint();
                List<ReaderVO> readers = ServiceFactory.getReaderServiceInstance().selectAll();
                showReaderTable(readers);
                Book tip1 = new Book();
                tip1.setBookName("请选择书类");
                comboBox1.addItem(tip1);
                com.sm.entity.Type tip2 = new com.sm.entity.Type();
                tip2.setTypeName("请选择类名");
                comboBox2.addItem(tip2);
                List<Book> books = ServiceFactory.getBookServiceInstance().selectAll();
                for (Book book : books){
                    comboBox1.addItem(book);
                }
                List<com.sm.entity.Type> types = ServiceFactory.getTypeServiceInstance().selectAll();
                for (com.sm.entity.Type type : types){
                    comboBox2.addItem(type);
                }
            }
        });
        borrowbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contacPanel, "Card2");

            }
        });
        accountbutton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contacPanel, "Card3");

            }
        });
        TimerTask timerTask = null;
        timerTask = new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("当前系统时间为：" + "yyyy/MM/dd    HH:mm:ss");
                String timeString = sdf.format(date);
                timerLabel.setText(timeString);
                xyLabel.setText(adminByAccount.getAdminName());
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 0, 1000);


        borrowbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisteredFrame();
            }
        });
        系统设置Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contacPanel, "Card4");
            }
        });
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int index = comboBox1.getSelectedIndex();
                if (index != 0) {
                    typeId = comboBox1.getItemAt(index).getId();
                    List<ReaderVO> readerList = ServiceFactory.getReaderServiceInstance().selectByTypeId(typeId);
                    showReaderTable(readerList);
                    List<com.sm.entity.Type> typeList = ServiceFactory.getTypeServiceInstance().selectByTypeId(typeId);
                    comboBox2.removeAllItems();
                    com.sm.entity.Type tip = new com.sm.entity.Type();
                    tip.setTypeName("请选择类名");
                    comboBox2.addItem(tip);
                    for (com.sm.entity.Type type :typeList){
                        comboBox2.addItem(type);
                    }
                }
            }
        });
        comboBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    int index = comboBox2.getSelectedIndex();
                    if (index != 0) {
                        int classId = comboBox2.getItemAt(index).getId();
                        List<ReaderVO> readerList = ServiceFactory.getReaderServiceInstance().selectByClassId(classId);
                        showReaderTable(readerList);
                    }
                }
            }
        });
        搜索Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keywords = searchField.getText().trim();
                List<ReaderVO> readerList = ServiceFactory.getReaderServiceInstance().selectByKeywords(keywords);
                if (readerList !=null){
                    showReaderTable(readerList);
                }
            }
        });
        新增读者Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

private  void showReaderTable(List<ReaderVO> readerList){
    tablePanel.removeAll();
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    table.setModel(model);
    table.setFont(new Font("楷体", Font.PLAIN, 23));
    model.setColumnIdentifiers(new String[]{"序号", "类别", "书名","作者", "角色", "邮件地址", "手机号", "加入日期"});
    for (ReaderVO reader : readerList){
        Object[] objects = new Object[]{reader.getId(),reader.getTypeName(),reader.getBookName(),reader.getName(),
                reader.getRole(),reader.getEmail(),reader.getMobile(),reader.getJoin_date(),reader.getAvatar()};
        model.addRow(objects);
    }
    TableColumn tc = table.getColumnModel().getColumn(7);
    tc.setMinWidth(0);
    tc.setMaxWidth(0);
    JTableHeader head = table.getTableHeader();
    DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
    hr.setHorizontalTextPosition(JLabel.CENTER);
    head.setDefaultRenderer(hr);
    head.setPreferredSize(new Dimension(head.getWidth(), 40));
    head.setFont(new Font("楷体", Font.PLAIN, 22));
    table.setRowHeight(35);
    table.setBackground(new Color(233, 241, 234));
    DefaultTableCellRenderer r = new DefaultTableCellRenderer();
    r.setHorizontalAlignment(JLabel.CENTER);
    table.setDefaultRenderer(Object.class, r);
    JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    tablePanel.add(scrollPane);
    JPopupMenu jPopupMenu = new JPopupMenu();
    JMenuItem item = new JMenuItem("删除");
    jPopupMenu.add(item);
    table.add(jPopupMenu);
    table.addMouseListener(new MouseInputAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = table.getSelectedRow();
            reaIdLabel.setText(table.getValueAt(row,0).toString());
            reaTypeLabel.setText(table.getValueAt(row,1).toString());
            reaBookLabel.setText(table.getValueAt(row,2).toString());
            reaNameLabel.setText(table.getValueAt(row,3).toString());
            reaGenderLabel.setText(table.getValueAt(row,4).toString());
            reaEmailField.setText(table.getValueAt(row,5).toString());
            reaMobileField.setText(table.getValueAt(row,6).toString());
            reaJoinLabel.setText(table.getValueAt(row,7).toString());
//                reaAvatarLabel.setText("<html>< img src= ‘" + table.getValueAt(row, 8).toString() + "’width=400 height=300/></html>");
            编辑Button.setVisible(true);
            编辑Button.setText("编辑");
            编辑Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getActionCommand().equals("编辑")){
                        reaEmailField.setEditable(true);
                        reaEmailField.setEnabled(true);
                        reaMobileField.setEditable(true);
                        reaMobileField.setEnabled(true);
                        编辑Button.setText("保存");
                        table.revalidate();
                    }
                    if (e.getActionCommand().equals("保存")){
                        Reader reader = new Reader();
                        reader.setId(Integer.valueOf(reaIdLabel.getText()));
                        reader.setEmail(reaEmailField.getText());
                        reader.setMobile(reaMobileField.getText());
                        int n = ServiceFactory.getReaderServiceInstance().updateReader(reader);
                        if (n == 1) {
                            model.setValueAt(reaEmailField.getText(), row, 5);
                            model.setValueAt(reaMobileField.getText(), row, 6);
                            reaEmailField.setEditable(false);
                            reaEmailField.setEnabled(false);
                            reaMobileField.setEditable(false);
                            reaMobileField.setEnabled(false);
                            编辑Button.setText("编辑");
                            table.revalidate();
                        }
                    }
                }
            });
            if (e.getButton() == 3){
                jPopupMenu.show(table,e.getX(), e.getY());
            }
        }
    });
    item.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = String.valueOf((table.getValueAt(row,0)));
            int choice = JOptionPane.showConfirmDialog(tablePanel, "确认删除吗");
            if (choice == 0) {
                if (row != -1) {
                    model.removeRow(row);
                }
                ServiceFactory.getReaderServiceInstance().deleteReader(id);
            }
        }
    });

}
    public static void main(String[] args) throws SQLException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        new AdminMainFrame1(new Admin());
    }
}
