package com.jack;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Text_IO {

//将所有单词存于哈希表中
    public static List<List<Word>> FindWords(String Path){
        // 把外部设备的文件 test.txt和translation.txt 包装成 file 对象
        File file = new File(Path);
        // 由于要做读的操作，并且对文件读，所以使用字符输入流，XXXReader
        // FileReader 可以直接封装 File 对象，所以使用 FileReader
        FileReader fr = null;
        BufferedReader br = null;
        String[] words=new String[4];
        String temp= "";
        //创建哈希表
        List<List<Word>> hashtable=new ArrayList<List<Word>>();
        //创建哈希表里面的“边结点”
        List<Word> As=new ArrayList<Word>();
        List<Word> Bs=new ArrayList<Word>();
        List<Word> Cs=new ArrayList<Word>();
        List<Word> Ds=new ArrayList<Word>();
        List<Word> Es=new ArrayList<Word>();
        List<Word> Fs=new ArrayList<Word>();
        List<Word> Gs=new ArrayList<Word>();
        List<Word> Hs=new ArrayList<Word>();
        List<Word> Is=new ArrayList<Word>();
        List<Word> Js=new ArrayList<Word>();
        List<Word> Ks=new ArrayList<Word>();
        List<Word> Ls=new ArrayList<Word>();
        List<Word> Ms=new ArrayList<Word>();
        List<Word> Ns=new ArrayList<Word>();
        List<Word> Os=new ArrayList<Word>();
        List<Word> Ps=new ArrayList<Word>();
        List<Word> Qs=new ArrayList<Word>();
        List<Word> Rs=new ArrayList<Word>();
        List<Word> Ss=new ArrayList<Word>();
        List<Word> Ts=new ArrayList<Word>();
        List<Word> Us=new ArrayList<Word>();
        List<Word> Vs=new ArrayList<Word>();
        List<Word> Ws=new ArrayList<Word>();
        List<Word> Xs=new ArrayList<Word>();
        List<Word> Ys=new ArrayList<Word>();
        List<Word> Zs=new ArrayList<Word>();
        //将"边结点"存入表头
        hashtable.add(As);
        hashtable.add(Bs);
        hashtable.add(Cs);
        hashtable.add(Ds);
        hashtable.add(Es);
        hashtable.add(Fs);
        hashtable.add(Gs);
        hashtable.add(Hs);
        hashtable.add(Is);
        hashtable.add(Js);
        hashtable.add(Ks);
        hashtable.add(Ls);
        hashtable.add(Ms);
        hashtable.add(Ns);
        hashtable.add(Os);
        hashtable.add(Ps);
        hashtable.add(Qs);
        hashtable.add(Rs);
        hashtable.add(Ss);
        hashtable.add(Ts);
        hashtable.add(Us);
        hashtable.add(Vs);
        hashtable.add(Ws);
        hashtable.add(Xs);
        hashtable.add(Ys);
        hashtable.add(Zs);
        try {
            fr = new FileReader(file);
            // 使用缓冲流，可以一行一行的读取内容
            br = new BufferedReader(fr);
            temp  = br.readLine();
            while (temp != null) {
                words=temp.split("#");
                Word word=new Word(words[0],words[1],words[2],words[3]);
                switch (word.getKey().substring(0,1)) {
                    case "a" -> hashtable.get(0).add(word);
                    case "b" -> hashtable.get(1).add(word);
                    case "c" -> hashtable.get(2).add(word);
                    case "d" -> hashtable.get(3).add(word);
                    case "e" -> hashtable.get(4).add(word);
                    case "f" -> hashtable.get(5).add(word);
                    case "g" -> hashtable.get(6).add(word);
                    case "h" -> hashtable.get(7).add(word);
                    case "i" -> hashtable.get(8).add(word);
                    case "j" -> hashtable.get(9).add(word);
                    case "k" -> hashtable.get(10).add(word);
                    case "l" -> hashtable.get(11).add(word);
                    case "m" -> hashtable.get(12).add(word);
                    case "n" -> hashtable.get(13).add(word);
                    case "o" -> hashtable.get(14).add(word);
                    case "p" -> hashtable.get(15).add(word);
                    case "q" -> hashtable.get(16).add(word);
                    case "r" -> hashtable.get(17).add(word);
                    case "s" -> hashtable.get(18).add(word);
                    case "t" -> hashtable.get(19).add(word);
                    case "u" -> hashtable.get(20).add(word);
                    case "v" -> hashtable.get(21).add(word);
                    case "w" -> hashtable.get(22).add(word);
                    case "x" -> hashtable.get(23).add(word);
                    case "y" -> hashtable.get(24).add(word);
                    case "z" -> hashtable.get(25).add(word);
                }
                temp = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }  finally {
            if (fr != null) {
                try {
                    // 关闭
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return hashtable;
    }

//记忆背诵进度模块
    //存储背到的单词位置
    public static void remember(String path, int i,int j){
        String content=i+","+j;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(content);
            bufferedWriter.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    //读取背诵到的单词的位置
    public static String[] readPosition(){
        File file = new File("src\\position.txt");
        FileReader fr = null;
        BufferedReader br = null;
        String[] position=new String[2];
        String temp;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            temp  = br.readLine();
            position=temp.split(",");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }  finally {
            if (fr != null) {
                try {
                    // 关闭
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return position;
    }

//生词本模块
    //获取生词本的内容
    public static List<Word> readWord(){
        File file = new File("src\\NewWord.txt");
        FileReader fr = null;
        BufferedReader br = null;
        String[] part=new String[3];
        String temp="";
        List<Word> words=new ArrayList<>();
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            temp  = br.readLine();
            while (temp!=null){
                part=temp.split("#");
                Word word=new Word(part[0],part[1],part[2],null);
                words.add(word);
                temp  = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }  finally {
            if (fr != null) {
                try {
                    // 关闭
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return words;
    }

    //添加生词
    public static boolean addWord(Word word){
        File file =new File(("src\\NewWord.txt"));
        BufferedWriter bw=null;
        FileReader fr = null;
        BufferedReader br = null;
        String[] words=new String[3];
        boolean flag=true;
        String temp;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            temp  = br.readLine();
            while (temp!=null){
                words=temp.split("#");
                if (words[0].equals(word.getKey())){
                    flag=false;
                    break;
                }
                temp=br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }  finally {
            if (fr != null) {
                try {
                    // 关闭
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if(flag){
            try {
                bw=new BufferedWriter(new FileWriter(file,true));
                bw.write("\n"+word.getKey()+"#"+word.getDefinition()+"#"+word.getSpeech());
                bw.flush();
                bw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return flag;
    }
    //删除生词
    public static void deleteWord(List<Word> words,int row){
        words.remove(row);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src\\NewWord.txt"))) {
            bufferedWriter.write(words.get(0).getKey()+"#"+words.get(0).getDefinition()+"#"+words.get(0).getSpeech());
            bufferedWriter.flush();
            for (int i=1;i<words.size();i++){
                bufferedWriter.write("\n"+words.get(i).getKey()+"#"+words.get(i).getDefinition()+"#"+words.get(i).getSpeech());
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}