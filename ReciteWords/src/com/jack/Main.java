package com.jack;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//将存储词典的哈希表打印出来
//        List<List<Word>> words = Text_IO.FindWords("src\\test.txt");
//        for (List<Word> word : words) {
//            System.out.println(word);
//            System.out.println();
//        }
        //图形化界面
        JFrame frame = new GUI("背单词");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    GUI.position();//保存背单词的进度
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                super.windowClosing(e);
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setSize(455, 310);
        frame.setVisible(true);
    }
}
