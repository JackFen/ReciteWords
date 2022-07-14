package com.jack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

import static com.jack.Text_IO.readPosition;
import static com.jack.Text_IO.remember;

public class GUI extends JFrame {
//预处理
    List<List<Word>> words = Text_IO.FindWords("src\\test.txt");//以哈希表的形式存储词典
    static int i=0;
    static int j=0;
    String[] pos=readPosition();//获取文件中记忆的进度
//定义各个组件
    JLabel key=new JLabel();//单词的英文标签
    JLabel speech=new JLabel();//单词的词性标签
    JLabel definition=new JLabel();//单词的释义标签
    JButton remember=new JButton("记住了");//记住了标签
    JButton searBtn=new JButton("查单词");//跳转搜索按钮
    JButton NewBtn=new JButton("生词本");//跳转生词本按钮

//图形化界面的实现
    public GUI(String title) {
        super(title);
        //获取背单词的进度
        i=Integer.parseInt(pos[0]);
        j=Integer.parseInt(pos[1]);
//        System.out.println(i+""+j);
        JPanel panel = new JPanel();//panel为背单词界面
        this.setContentPane(panel);
        panel.setLayout(null);
        panel.setVisible(true);
//------------背单词模块-----------
        //设置单词显示的位置
        panel.add(key);
        key.setBounds(120, 50, 160, 30);
        key.setText(words.get(i).get(j).getKey());
        key.setFont(new Font("宋体",Font.PLAIN,25));
        key.setOpaque(true);  //此句是重点，设置背景颜色必须先将它设置为不透明的，因为默认是透明的。。。
        key.setBackground(Color.GREEN);
        //设置词性显示的位置
        panel.add(speech);
        speech.setBounds(120, 90, 100, 30);
        speech.setText(words.get(i).get(j).getSpeech());
        speech.setFont(new Font("宋体",Font.PLAIN,25));
        speech.setOpaque(true);  //此句是重点，设置背景颜色必须先将它设置为不透明的，因为默认是透明的。。。
        speech.setBackground(Color.yellow);
        //设置释义显示的位置
        panel.add(definition);
        definition.setBounds(120, 130, 100, 30);
        definition.setText(words.get(i).get(j).getDefinition());
        definition.setFont(new Font("宋体",Font.PLAIN,25));
        definition.setOpaque(true);  //此句是重点，设置背景颜色必须先将它设置为不透明的，因为默认是透明的。。。
        definition.setBackground(Color.red);
        //设置记住了按钮的位置与功能
        panel.add(remember);
        remember.setBounds(123, 170, 95, 30);
        remember.setFont(new Font("宋体",Font.PLAIN,20));
        remember.addActionListener((e) -> {
            if(i+1==words.size()&&j+1==words.get(i).size()){
                JOptionPane.showMessageDialog(panel,"恭喜你已经背完了所有单词！");
            }
            if (words.size()<=(i+1)){
                i=0;
                j=0;
            }
            else if(words.get(i).size()<=(j+1)){
                j=0;
                i++;
                i=findNext(words,i);
//                System.out.println(i);
            }
            else {
                j++;
            }
            key.setText(words.get(i).get(j).getKey());
            speech.setText(words.get(i).get(j).getSpeech());
            definition.setText(words.get(i).get(j).getDefinition());
        });

//设置查单词按钮位置
        panel.add(searBtn);
        searBtn.setBounds(330, 50, 95, 30);
        searBtn.setFont(new Font("宋体",Font.PLAIN,20));
        searBtn.addActionListener((e) -> {
            JFrame f2=new Search(title,this,words);
            f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f2.setLocationRelativeTo(null);
            f2.setSize(455, 310);
            f2.addWindowListener(new WindowAdapter() {
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
            f2.setVisible(true);
            this.setVisible(false);
        });

//设置生词本按钮
        panel.add(NewBtn);
        NewBtn.setBounds(330, 90, 95, 30);
        NewBtn.setFont(new Font("宋体",Font.PLAIN,20));
        NewBtn.addActionListener((e) -> {
            JFrame f3=new NewWord("生词本",this);
            f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f3.setLocationRelativeTo(null);
            f3.setSize(300, 500);
            f3.addWindowListener(new WindowAdapter() {
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
            f3.setVisible(true);
            this.setVisible(false);
        });
    }

//设置自动保存进度
    public static void position() throws IOException {
        remember("src\\position.txt",i,j);
    }

    //对应字母无单词处理函数（即向下寻找，直到找到有单词的字母为止）
    public  int findNext(List<List<Word>> words,int i){
        if(words.get(i).size()==0){
            i++;
            return findNext(words,i);
        }
        return i;
    }
}