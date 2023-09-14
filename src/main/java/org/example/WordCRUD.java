package org.example;
import  java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    ArrayList<Word> list;
    Scanner s;
    final String fname = "Dictionary.txt";

    WordCRUD(Scanner s) {
        list = new ArrayList<>();
        this.s = s;
    }
    @Override
    public Object add() {
        System.out.print("=> 난이(1,2,3) & 새 단어 입력 : ");
        int level = s.nextInt();
        String word = s.nextLine();
        System.out.print("뜻 입력 : ");
        String meaning = s.nextLine();

        return new Word(0, level, word, meaning);
    }

    public void addItem() {
        Word one = (Word)add();
        list.add(one);
        System.out.println("새 단어가 단어장에 추가되었습니다. ");

    }

    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }

    public void listAll() {
        System.out.println("---------------------------");
        for(int i=0; i<list.size(); i++) {
            System.out.print((i+1) + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("---------------------------");
    }
    public void end() {
        System.out.println("프로그램 종료!");
    }

    public ArrayList<Integer> listAll(String keyword) {
        ArrayList<Integer> idlist = new ArrayList<>();
        int j=0;
        System.out.println("---------------------------");
        for(int i=0; i<list.size(); i++) {
            String word = list.get(i).getWord();
            if (!word.contains(keyword)) {
                continue;
            }
            System.out.print((j + 1) + " ");
            System.out.println(list.get(i).toString());
            idlist.add(i);
            j++;
        }
        System.out.println("---------------------------");
        return idlist;
    }

    public void updateItem() {
        System.out.println("=> 수정할 단어 검색 : ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.println("=> 수정할 번호 선택 : ");
        int id = s.nextInt();
        s.nextLine();
        System.out.println("=> 뜻 입력 : ");
        String meaning = s.nextLine();
        Word word = list.get(idlist.get(id-1));
        word.setMeaning(meaning);
        System.out.println("단어가 수정되었습니다. ");
    }


    public void deleteItem() {
        System.out.println("=> 삭제할 단어 검색 : ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.println("=> 삭제할 번호 선택 : ");
        int id = s.nextInt();
        s.nextLine();
        System.out.println("=> 정말로 삭제하시겠습니까?(Y/N) : ");
        String answer = s.next();
        if (answer.equalsIgnoreCase("y")) {
            list.remove((int)idlist.get(id - 1));
            System.out.println("단어가 삭제되었습니다. ");
        } else {
            System.out.println("취소되었습니다. ");
        }
    }

    public void loadFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            line = br.readLine(); // 한줄씩 불러옴
            String data[] = line.split("\\|"); // |를 가지고 split 앞에 \\를 넣어야 |라는 문자로 쪼갠다는 걸 인식함.
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
