package com.jack;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static com.jack.Text_IO.addWord;


public class Search extends JFrame {

//定义各个组件
    JLabel notice=new JLabel("请输入英文/中文");//"请输入英文/中文"的提示标签
    JTextField search=new JTextField();//搜索框
    JButton searBtn=new JButton("搜索");//搜索按钮
    JButton retn=new JButton("返回");//返回按钮
    JLabel key=new JLabel();//单词的英文标签
    JLabel speech=new JLabel();//单词的词性标签
    JLabel definition=new JLabel();//单词的释义标签
    JTextArea sentence=new JTextArea();//单词的例句标签
    JLabel noFound=new JLabel("未查询到该单词");//未找到单词标签
    JButton addNew=new JButton("添加到生词本");//将单词添加到生词本按钮
    static int i=0;
    static int j=0;

//图形化界面的实现
    public Search(String title, JFrame f1, List<List<Word>>words){
        super(title);
        JPanel panel = new JPanel();//panel查单词界面
        this.setContentPane(panel);
        panel.setLayout(null);

        //设置返回按钮
        panel.add(retn);
        retn.setBounds(10,10,60,20);
        retn.addActionListener((e) -> {
            this.dispose();
            f1.setVisible(true);
        });

        //设置提示标签的显示位置
        panel.add(notice);
        notice.setBounds(120,20,140,30);
        notice.setFont(new Font("宋体",Font.PLAIN,16));

        //设置单词显示的位置
        panel.add(key);
        key.setBounds(100, 100, 130, 30);
        key.setFont(new Font("宋体",Font.PLAIN,25));
        key.setOpaque(true);  //此句是重点，设置背景颜色必须先将它设置为不透明的，因为默认是透明的。。。
        key.setBackground(Color.GREEN);
        key.setVisible(false);

        //设置词性显示的位置
        panel.add(speech);
        speech.setBounds(100, 140, 70, 30);
        speech.setFont(new Font("宋体",Font.PLAIN,25));
        speech.setOpaque(true);  //此句是重点，设置背景颜色必须先将它设置为不透明的，因为默认是透明的。。。
        speech.setBackground(Color.yellow);
        speech.setVisible(false);

        //设置释义显示的位置
        panel.add(definition);
        definition.setBounds(180, 140, 80, 30);
        definition.setFont(new Font("宋体",Font.PLAIN,25));
        definition.setOpaque(true);  //此句是重点，设置背景颜色必须先将它设置为不透明的，因为默认是透明的。。。
        definition.setBackground(Color.red);
        definition.setVisible(false);

        //设置例句显示的位置
        panel.add(sentence);
        sentence.setBounds(100, 180, 230, 60);
        sentence.setFont(new Font("宋体",Font.PLAIN,20));
        sentence.setOpaque(true);  //此句是重点，设置背景颜色必须先将它设置为不透明的，因为默认是透明的。。。
        sentence.setBackground(Color.lightGray);
        sentence.setEditable(false);
        sentence.setLineWrap(true);
        sentence.setWrapStyleWord(true);
        sentence.setVisible(false);

        //设置未找到单词标签的位置
        panel.add(noFound);
        noFound.setBounds(120, 140, 144, 30);
        noFound.setFont(new Font("宋体",Font.PLAIN,20));
        noFound.setOpaque(true);  //此句是重点，设置背景颜色必须先将它设置为不透明的，因为默认是透明的。。。
        noFound.setBackground(Color.lightGray);
        noFound.setVisible(false);

        //设置将单词添加到生词本按钮
        panel.add(addNew);
        addNew.setBounds(240, 100,130,24);
        addNew.setFont(new Font("宋体",Font.PLAIN,16));
        addNew.addActionListener(e->{
            boolean flag=addWord(words.get(i).get(j));
            if (flag) JOptionPane.showMessageDialog(null,"添加成功");
            else JOptionPane.showMessageDialog(null,"该单词已经添加过了");
        });
        addNew.setVisible(false);

        //设置搜索框
        panel.add(search);
        search.setBounds(90,50,200,30);

        //设置搜索按钮
        panel.add(searBtn);
        searBtn.setBounds(300,50,60,30);
        searBtn.addActionListener((e)->{
//            int m=0,n=0;
            key.setVisible(false);
            speech.setVisible(false);
            definition.setVisible(false);
            sentence.setVisible(false);
            noFound.setVisible(false);
            addNew.setVisible(false);
            String unknown=search.getText();
            Word word=new Word();
            //用户不输入内容直接提交的处理
            if(unknown.equals("")){

            }
            //用户输入英文的时候进行的处理
            else if (unknown.substring(0, 1).compareTo("a") >= 0 && unknown.substring(0, 1).compareTo("z") <= 0){
                i = 0;
                j = 0;
                boolean flag = false;
                //采用哈希函数来查找
                    switch (unknown.substring(0, 1)) {
                        case "a" -> i = 0;
                        case "b" -> i = 1;
                        case "c" -> i = 2;
                        case "d" -> i = 3;
                        case "e" -> i = 4;
                        case "f" -> i = 5;
                        case "g" -> i = 6;
                        case "h" -> i = 7;
                        case "i" -> i = 8;
                        case "j" -> i = 9;
                        case "k" -> i = 10;
                        case "l" -> i = 11;
                        case "m" -> i = 12;
                        case "n" -> i = 13;
                        case "o" -> i = 14;
                        case "p" -> i = 15;
                        case "q" -> i = 16;
                        case "r" -> i = 17;
                        case "s" -> i = 18;
                        case "t" -> i = 19;
                        case "u" -> i = 20;
                        case "v" -> i = 21;
                        case "w" -> i = 22;
                        case "x" -> i = 23;
                        case "y" -> i = 24;
                        case "z" -> i = 25;
                    }
                for (int k = 0; k < words.get(i).size(); k++) {
//                    m=k+1;
                    if (unknown.equals(words.get(i).get(j).getKey())) {
                        word=words.get(i).get(j);
                        flag = true;
                        break;
                    }
                    j++;
                }
                if (flag) {
                    key.setText(word.getKey());
                    speech.setText(word.getSpeech());
                    definition.setText(word.getDefinition());
                    sentence.setText(word.getSentence());
                    key.setVisible(true);
                    speech.setVisible(true);
                    definition.setVisible(true);
                    sentence.setVisible(true);
                    addNew.setVisible(true);
                } else {
                    noFound.setVisible(true);
                }
//                System.out.println("采用哈希表存储的查找次数："+m);
            }
            //用户输入中文时的处理
            else {
                boolean flag=false;
                //采用遍历哈希表的方式
                for (List<Word> wordList : words) {
                    for (Word value : wordList) {
//                        n++;
                        if (unknown.equals(value.getDefinition())) {
                            word = value;
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
                if (flag){
                    key.setText(word.getKey());
                    speech.setText(word.getSpeech());
                    definition.setText(word.getDefinition());
                    sentence.setText(word.getSentence());
                    key.setVisible(true);
                    speech.setVisible(true);
                    definition.setVisible(true);
                    sentence.setVisible(true);
                    addNew.setVisible(true);
                }
                else {
                    noFound.setVisible(true);
                }
//                System.out.println("不采用哈希表存储的查找次数："+n);
            }
        });
    }
}