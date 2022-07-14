package com.jack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import static com.jack.Text_IO.deleteWord;
import static com.jack.Text_IO.readWord;

public class NewWord extends JFrame {

//定义各个组件
    JButton retn=new JButton("返回");//返回按钮
    JTable New_Word;//显示生词的表格
    JLabel notice=new JLabel("选中某行来删除生词");//提示标签
    JButton delBtn=new JButton("删除");//删除按钮

//图形化界面的实现
    public NewWord(String title, JFrame f1){
        super(title);
        JPanel panel = new JPanel();//panel生词本界面
        this.setContentPane(panel);
        panel.setLayout(null);

        //设置返回按钮
        panel.add(retn);
        retn.setBounds(10,10,60,20);
        retn.addActionListener((e) -> {
            this.dispose();
            f1.setVisible(true);
        });

        //设置提示标签的位置
        panel.add(notice);
        notice.setBounds(80,10,118,20);
        notice.setOpaque(true);
        notice.setBackground(Color.yellow);

        //设置显示生词的表格
        String[] columnName={"单词","词性","释义"};
        String[][] rowData={{"*********","*********","*********"}};
        DefaultTableModel tableModel = new DefaultTableModel(rowData, columnName);//创建表格模型
        New_Word=new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(New_Word);// 创建显示表格的滚动面板
        panel.add(scrollPane,BorderLayout.CENTER);
        New_Word.setBounds(0,60,300,200);
        New_Word.setFont(new Font("宋体",Font.PLAIN,16));
        New_Word.setRowHeight(25);
        New_Word.setSelectionMode(0);
        scrollPane.setBounds(0,40,295,410);
        tableModel.removeRow(0);
        List<Word> words=readWord();
        for (Word word : words) {
            String[] data = {word.getKey(), word.getSpeech(), word.getDefinition()};
            tableModel.addRow(data);
        }

        //设置删除按钮
        panel.add(delBtn);
        delBtn.setBounds(213,10,60,20);
        delBtn.addActionListener(e->{
            int option=JOptionPane.showConfirmDialog(panel,"确认要删除吗？","确认删除",JOptionPane.OK_CANCEL_OPTION);
            if (option==JOptionPane.YES_OPTION){
                int Row=New_Word.getSelectedRow();
//                System.out.println(Row);
                tableModel.removeRow(Row);
                deleteWord(words,Row);
            }
        });
    }
}