package org.example;
import java.util.Scanner;

public class WordManager {
    Scanner s = new Scanner(System.in);
    WordCRUD WordCRUD;
    WordManager() {
        WordCRUD = new WordCRUD(s);
    }

    public int selectMenu() {
        System.out.println("*** 영단어 마스터 ***\n"
                + "*****************\n"
                + "1. 모든 단어 보기\n"
                + "2. 수준별 단어 보기\n"
                + "3. 단어 검색\n"
                + "4. 단어 추가\n"
                + "5. 단어 수정\n"
                + "6. 단어 삭제\n"
                + "7. 파일 저장\n"
                + "0. 나가기\n"
                + "*****************\n"
                + "=> 원하는 메뉴는? ");
        return s.nextInt();
    }
    public void start() {
        WordCRUD.loadFile();
        while(true) {
            int menu = selectMenu();
            if(menu == 0) {
                WordCRUD.end();
                break;
            }
            else if(menu == 1) {
                WordCRUD.listAll();
            }
            else if(menu == 2) {
                WordCRUD.searchLevel();
            }
            else if(menu == 3) {
                WordCRUD.searchWord();
            }
            else if(menu == 4) {
                WordCRUD.addItem();
            }
            else if(menu == 5) {
                WordCRUD.updateItem();
            }
            else if(menu == 6) {
                WordCRUD.deleteItem();
            }
            else if(menu == 7) {
                WordCRUD.saveFile();
            }
        }
    }
}
