package com.juhe.frame;

import com.juhe.entity.Dream;
import com.juhe.entity.News;
import com.juhe.sevice.DreamApiService;
import com.sun.imageio.plugins.gif.GIFImageReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.util.List;

public class DreamFrame {
    private JPanel panel1;
    private JPanel topPanel;
    private JButton button1;
    private JButton 血型性格Button;
    private JButton 周公解梦Button;
    private JButton button4;
    private JButton button5;
    private JButton 十二星座Button;
    private JButton button7;
    private JPanel mainPanel;
    private JPanel zhouPanel;
    private JPanel starPanel;
    private JLabel abcLabel;
    private JLabel bgLabel;


    public DreamFrame() {
        Carouse11Thread nt = new Carouse11Thread();
        nt.setBgLabel(bgLabel);
        new Thread(nt).start();
        CardLayout cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);
        mainPanel.add("zhou", zhouPanel);
        mainPanel.add("star",starPanel);
        JScrollPane jScrollPane = new JScrollPane();
        mainPanel.add(jScrollPane);
        List<Dream> dreamList = DreamApiService.getDream("name");
        showDate(dreamList, zhouPanel);
        cardLayout.show(mainPanel, "zhou");

        周公解梦Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Dream> dreamList = DreamApiService.getDream("name");
                showDate(dreamList, zhouPanel);
                cardLayout.show(mainPanel, "zhou");
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        十二星座Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              cardLayout.show(mainPanel,"star");

            }
        });
        button7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(URI.create("https://www.zgjm.org/xm/"));
                } catch (IOException err) {
                    err.printStackTrace();
                }
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(URI.create("https://www.zgjm.org/huangli/"));
                } catch (IOException err) {
                    err.printStackTrace();
                }

            }
        });
        abcLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(URI.create("https://www.zgjm.org/"));
                } catch (IOException err) {
                    err.printStackTrace();
                }
            }
        });
    }

    public void showDate(List<Dream> dreamList, JPanel mainPanel) {
        mainPanel.removeAll();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setHgap(20);
        flowLayout.setVgap(30);
        mainPanel.setLayout(flowLayout);

        for (Dream dream : dreamList) {
            Font font = new Font(null, Font.BOLD, 23);
            JLabel jLabel = new JLabel("序号：");
            jLabel.setFont(font);
            jLabel.setForeground(new Color(192, 45, 121));
            JLabel nameJL = new JLabel(dream.getName());
            JLabel id = new JLabel(dream.getId());
            JLabel fid = new JLabel("  " + dream.getFid());
            nameJL.setFont(font);
            id.setFont(font);
            fid.setFont(font);

            JPanel gridLayout = new JPanel();
            gridLayout.setLayout(new GridLayout(1, 3));
            gridLayout.add(jLabel);
            gridLayout.add(id);
            gridLayout.add(nameJL);
            gridLayout.add(fid);
            System.out.println(dream.getName());
            mainPanel.add(gridLayout);
            mainPanel.add(starPanel);
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("DreamFrame");
        frame.setContentPane(new DreamFrame().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 2000);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
