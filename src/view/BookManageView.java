package view;
// 콘솔 창에 출력하는 것들을 만드는 클래스
// DTO에서 저장한 정보를 다시 저장해서는 안 된다.

import dto.BookDTO;
import service.BookService;

import java.util.ArrayList;
import java.util.HashMap;

public class BookManageView {

    private BookService service;

    public BookManageView(BookService service) {
        this.service = service;
    }

    // 책 정보 나열
    public void printBookList(BookDTO BookDTO) {
        System.out.printf("도서명:%s    저자:%s    출판사:%s    발행일:%s    분류:%s    가격:%d    쪽수:%d    ISBN:%s\n",
                BookDTO.getBookName(), BookDTO.getAuthor(), BookDTO.getPublisher(), BookDTO.getPubDate(), BookDTO.getDepartment(), BookDTO.getPrice(), BookDTO.getPrintLen(), BookDTO.getIsbn());
    }

    // 도서 관리 시스템 메뉴 나열
    public void printMenu() {
        service.menuList();
        HashMap<Integer, String> manageMenu = service.getMap();
        System.out.println("아래 메뉴 번호를 입력해주세요.");
        for (Integer key : manageMenu.keySet()) {
            String value = manageMenu.get(key);
            System.out.println(key + ". " + value);
        }
    }

    // 책 목록 나열
    public void printBook() {
        ArrayList<BookDTO> bookList = service.getBookList();
        int index = 1;
        System.out.println("================================================================================================================================================================================");
        for (BookDTO bookDTO : bookList) {
            System.out.print("[" + index + "] ");
            this.printBookList(bookDTO);
            System.out.println("");
            index++;
        }
        System.out.println("================================================================================================================================================================================\n");
    }
}