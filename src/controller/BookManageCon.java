package controller;
// 다른 클래스들에서 만든 메서드를 호출하는 클래스
// DTO와 View에 대해 알고 있어야 한다.
// DTO와 View의 변경을 모니터링 해야 한다.

import service.BookService;
import view.BookManageView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookManageCon {

    // 프로그램 이름 (상수로 설정)
    public static final String PROGRAMM = "Sun's Book List Programm";

    public static void main(String[] args) {

        // 생성자 호출
        BookService service = new BookService();
        // 의존성 주입
        BookManageView view = new BookManageView(service);

        Scanner menu = new Scanner(System.in);
        int select;

        System.out.print("\n[" + PROGRAMM + "]에 오신 것을 환영합니다!\n");
        while(true) {
            try {
                view.printMenu();
                select = menu.nextInt();
                System.out.println("");

                if (select==1) {
                    view.printBook();
                }
                else if (select==2) {
                    service.searchBook();
                }
                else if (select==3) {
                    service.addBook();
                }
                else if (select==4) {
                    service.reviseBook();
                }
                else if (select==5) {
                    service.removeBook();
                }
                else if (select==6) {
                    System.out.print("[" + PROGRAMM + "]을 종료합니다.");
                    break;
                }
                else {
                    System.out.println("번호가 잘못 입력되었습니다.");
                    continue;
                }
            } catch(InputMismatchException e) {
                System.out.println("번호가 잘못 입력되었습니다.");
            } finally {
                menu = new Scanner(System.in);
            }
        }
    }
}