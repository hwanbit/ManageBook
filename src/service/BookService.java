package service;
// 로직을 처리하는 메서드를 만드는 클래스 (사용자가 원하는 데이터를 반환해주는)

import dto.BookDTO;

import java.util.*;
import java.util.regex.Pattern;

public class BookService {

    private HashMap<Integer, String> manageMenu;
    private ArrayList<BookDTO> bookList;
    private ArrayList<BookDTO> newBookList;

    public BookService() {
        bookList = new ArrayList<>();
        newBookList = new ArrayList<>();
        menuList();
        existBook();
    }

    // key-value로 연결하기 위해 hashmap 사용
    public void menuList() {
        manageMenu = new HashMap<>();
        manageMenu.put(1, "도서 목록 확인");
        manageMenu.put(2, "도서 정보 조회");
        manageMenu.put(3, "도서 목록 추가");
        manageMenu.put(4, "도서 정보 수정");
        manageMenu.put(5, "도서 목록 삭제");
        manageMenu.put(6, "프로그램 종료");
    }

    // get hashmap
    public HashMap<Integer, String> getMap() {
        return this.manageMenu;
    }

    // 기존 책 목록 내역 생성
    public void existBook() {
        bookList = new ArrayList<>();
        bookList.add(new BookDTO("강철의 연금술사 1", "Hiromu Arakawa", "학산문화사", "2004-04-25", "만화", 4500, 180, "9788925886862"));
        bookList.add(new BookDTO("그림으로 배우고 실생활 예제로 실습하는 자바를 부탁해", "박세홍(홍팍)", "한빛아카데미", "2021-10-29", "컴퓨터", 26000, 556, "9791156645672"));
        bookList.add(new BookDTO("돈의 속성(300쇄 리커버에디션)", "김승호", "스노우폭스북스", "2020-06-15", "재테크", 17800, 416, "9791188331796"));
        bookList.add(new BookDTO("듄 1(DUNE)", "프랭크 허버트", "황금가지", "2021-01-21", "소설", 30000, 940, "9791158887544"));
        bookList.add(new BookDTO("모순", "양귀자", "쓰다", "2013-04-01", "소설", 13000, 308, "9788998441012"));
        bookList.add(new BookDTO("반지의 제왕 1: 반지 원정대", "존 로널드 루엘 톨킨", "아르테(arte)", "2021-02-23", "소설", 49800, 708, "9788950992460"));
        bookList.add(new BookDTO("부자의 그릇(블랙 에디션)", "이즈미 마사토", "다산북스", "2024-05-01", "경제", 17000, 224, "9791130633619"));
        bookList.add(new BookDTO("아기 판다 푸바오", "에버랜드 동물원, 강철원", "시공주니어", "2021-07-20", "에세이", 18000, 136, "9791165796396"));
        bookList.add(new BookDTO("해리 포터와 마법사의 돌 1(해리포터 20주년 개정판)", "J. K. 롤링", "문학수첩", "2019-11-19", "소설", 9000, 268, "9788983927620"));
        bookList.add(new BookDTO("Mellow Dog Volume 8(멜로우 매거진)", "펫앤스토리 편집부", "펫앤스토리", "2023-08-31", "잡지", 17000, 178, ""));
    }

    // get booklist
    public ArrayList<BookDTO> getBookList() {
        return bookList;
    }

    // 도서 정보 중 발행일 입력 (문자열인데 형식을 지정해야 하기 때문에 따로 메서드 생성함)
    private String getValidatedPubDate() {
        Scanner scanner = new Scanner(System.in);
        String pubDate;
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";

        while (true) {
            System.out.print("발행일(예:2024-10-10) : ");
            pubDate = scanner.nextLine();
            if (Pattern.matches(regex, pubDate)) {
                break;
            } else {
                System.out.println("잘못된 형식입니다. YYYY-MM-DD 형식으로 입력해주세요.");
            }
        }
        return pubDate;
    }

    // 도서 정보 중 가격 입력 (문자열인데 형식을 지정해야 하기 때문에 따로 메서드 생성함)
    private int getValidatePrice() {
        Scanner scanner = new Scanner(System.in);
        int price;

        while(true) {
            try {
                System.out.print("가격 : ");
                price = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("숫자로 입력해주세요.");
            } finally {
                scanner = new Scanner(System.in);
            }
        }
        return price;
    }

    // 도서 정보 중 쪽수 입력 (문자열인데 형식을 지정해야 하기 때문에 따로 메서드 생성함)
    private int getValidatePrintLen() {
        Scanner scanner = new Scanner(System.in);
        int printLen;

        while(true) {
            try {
                System.out.print("쪽수 : ");
                printLen = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("숫자로 입력해주세요.");
            } finally {
                scanner = new Scanner(System.in);
            }
        }
        return printLen;
    }

    // 도서 정보 중 ISBN 입력 (문자열인데 형식을 지정해야 하기 때문에 따로 메서드 생성함)
    private String getValidatedIsbn() {
        Scanner scanner = new Scanner(System.in);
        String isbnPattern = "^[0-9]+$";
        String isbn;

        while (true) {
            System.out.print("ISBN : ");
            isbn = scanner.nextLine();
            if (Pattern.matches(isbnPattern, isbn)) {
                break;
            } else {
                System.out.println("잘못된 형식입니다. 숫자만 입력해주세요.");
            }
        }
        return isbn;
    }

    // 도서 목록 추가
    public void addBook() {
        newBookList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("도서 정보를 입력해주세요.");

        System.out.print("도서명 : ");
        String bookName = scanner.nextLine();

        System.out.print("저자 : ");
        String author = scanner.nextLine();

        System.out.print("출판사 : ");
        String publisher = scanner.nextLine();

        String pubDate = getValidatedPubDate();

        System.out.print("분류 : ");
        String department = scanner.nextLine();

        int price = getValidatePrice();

        int printLen = getValidatePrintLen();

        String isbn = getValidatedIsbn();

        System.out.println("\n추가할 도서 정보 : ");
        System.out.printf("도서명:%s    저자:%s    출판사:%s    발행일:%s    분류:%s    가격:%d    쪽수:%d    ISBN:%s\n",
                bookName, author, publisher, pubDate, department, price, printLen, isbn);

        System.out.print("입력된 정보를 확인해주세요. (y/n) : ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("y")) {
            newBookList.add(new BookDTO(bookName, author, publisher, pubDate, department, price, printLen, isbn));
            bookList.addAll(newBookList);
            System.out.println("새 도서가 추가되었습니다.");
        } else {
            System.out.println("도서를 추가하지 않고 메뉴로 돌아갑니다.");
        }
    }

    // 도서 정보 수정
    public void reviseBook() {
        System.out.print("수정할 도서의 번호를 입력하세요. (1-" + bookList.size() + "): ");
        Scanner scanner = new Scanner(System.in);
        int select = -1;

        while (true) {
            try {
                select = Integer.parseInt(scanner.nextLine()) - 1;
                if (select >= 0 && select < bookList.size()) {
                    break;
                } else {
                    System.out.println("번호가 잘못 입력되었습니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자로 입력해주세요.");
            }
        }

        BookDTO selectBook = bookList.get(select);

        BookDTO originalBook = new BookDTO(
                selectBook.getBookName(),
                selectBook.getAuthor(),
                selectBook.getPublisher(),
                selectBook.getPubDate(),
                selectBook.getDepartment(),
                selectBook.getPrice(),
                selectBook.getPrintLen(),
                selectBook.getIsbn()
        );

        System.out.println("\n현재 도서 정보 : ");
        System.out.printf("도서명:%s    저자:%s    출판사:%s    발행일:%s    분류:%s    가격:%d    쪽수:%d    ISBN:%s\n",
                selectBook.getBookName(), selectBook.getAuthor(), selectBook.getPublisher(), selectBook.getPubDate(), selectBook.getDepartment(), selectBook.getPrice(), selectBook.getPrintLen(), selectBook.getIsbn());

        System.out.println("\n수정할 정보를 입력하세요. (수정하지 않을 항목은 적지 말고 바로 엔터를 눌러주세요)");

        System.out.print("도서명 : ");
        String bookName = scanner.nextLine();
        if (!bookName.trim().isEmpty()) {
            selectBook.setBookName(bookName);
        }

        System.out.print("저자 : ");
        String author = scanner.nextLine();
        if (!author.trim().isEmpty()) {
            selectBook.setAuthor(author);
        }

        System.out.print("출판사 : ");
        String publisher = scanner.nextLine();
        if (!publisher.trim().isEmpty()) {
            selectBook.setPublisher(publisher);
        }

        System.out.print("발행일 : ");
        String pubDate = scanner.nextLine();
        if (!pubDate.trim().isEmpty()) {
            selectBook.setPubDate(getValidatedPubDate());
        }

        System.out.print("분류 : ");
        String department = scanner.nextLine();
        if (!department.trim().isEmpty()) {
            selectBook.setDepartment(department);
        }

        System.out.print("가격 : ");
        String priceStr = scanner.nextLine();
        if (!priceStr.trim().isEmpty()) {
            selectBook.setPrice(getValidatePrice());
        }

        System.out.print("쪽수 : ");
        String printLenStr = scanner.nextLine();
        if (!printLenStr.trim().isEmpty()) {
            selectBook.setPrintLen(getValidatePrintLen());
        }

        System.out.print("ISBN : ");
        String isbn = scanner.nextLine();
        if (!isbn.trim().isEmpty()) {
            selectBook.setIsbn(getValidatedIsbn());
        }

        System.out.println("\n수정된 도서 정보 : ");
        System.out.printf("도서명:%s    저자:%s    출판사:%s    발행일:%s    분류:%s    가격:%d    쪽수:%d    ISBN:%s\n",
                selectBook.getBookName(), selectBook.getAuthor(), selectBook.getPublisher(), selectBook.getPubDate(), selectBook.getDepartment(), selectBook.getPrice(), selectBook.getPrintLen(), selectBook.getIsbn());

        System.out.print("\n이대로 수정하시겠습니까? (y/n) : ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("y")) {
            bookList.set(select, selectBook);
            System.out.println("도서 정보가 수정되었습니다.");
        } else {
            bookList.set(select, originalBook);
            System.out.println("도서 수정이 취소되었습니다.");
        }
    }

    // 도서 삭제
    public void removeBook() {
        System.out.print("삭제할 도서의 번호를 입력하세요. (1-" + bookList.size() + "): ");
        Scanner scanner = new Scanner(System.in);
        int exist = -1;

        while (true) {
            try {
                exist = Integer.parseInt(scanner.nextLine()) - 1;

                if (exist >= 0 && exist < bookList.size()) {
                    break;
                } else {
                    System.out.println("번호가 잘못 입력되었습니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자로 입력해주세요.");
            }
        }

        BookDTO selectBook = bookList.get(exist);

        System.out.println("\n현재 도서 정보 : ");
        System.out.printf("도서명:%s    저자:%s    출판사:%s    발행일:%s    분류:%s    가격:%d    쪽수:%d    ISBN:%s\n",
                selectBook.getBookName(), selectBook.getAuthor(), selectBook.getPublisher(), selectBook.getPubDate(), selectBook.getDepartment(), selectBook.getPrice(), selectBook.getPrintLen(), selectBook.getIsbn());

        System.out.print("\n이 도서를 삭제하시겠습니까? (y/n) : ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("y")) {
            bookList.remove(exist);
            System.out.println("도서가 삭제되었습니다.");
        } else {
            System.out.println("도서 삭제가 취소되었습니다.");
        }
    }

    // 도서 정보 검색
    public void searchBook() {
        Scanner scanner = new Scanner(System.in);
        List<BookDTO> search = new ArrayList<>();

        try {
            System.out.println("\n검색 옵션을 선택하세요. (숫자로 입력해주세요) : ");
        } catch (NumberFormatException e) {
            System.out.println("숫자로 입력해주세요.");
        }

        System.out.println("1. 도서명으로 검색   2. 저자로 검색   3. 출판사로 검색   4. 발행일로 검색 (YYYY-MM-DD)   5. 분류로 검색   6. 가격으로 검색\n");

        int option = scanner.nextInt();
        scanner.nextLine();

        System.out.print("검색어를 입력하세요 : ");
        String keyword = scanner.nextLine();

        for (BookDTO book : bookList) {
            boolean match = false;

            switch (option) {
                case 1:
                    match = book.getBookName().toLowerCase().contains(keyword);
                    break;
                case 2:
                    match = book.getAuthor().toLowerCase().contains(keyword);
                    break;
                case 3:
                    match = book.getPublisher().toLowerCase().contains(keyword);
                    break;
                case 4:
                    if (keyword.matches("\\d{4}")) {
                        match = book.getPubDate().startsWith(keyword);
                    } else {
                        match = book.getPubDate().equals(keyword);
                    }
                    break;
                case 5:
                    match = book.getDepartment().toLowerCase().contains(keyword);
                    break;
                case 6:
                    try {
                        int searchPrice = Integer.parseInt(keyword);
                        match = (book.getPrice() == searchPrice);
                    } catch (NumberFormatException e) {
                        System.out.println("숫자로 입력해주세요.");
                        return;
                    }
                    break;
                default:
                    System.out.println("잘못된 옵션입니다.");
                    return;
            }
            if (match) {
                search.add(book);
            }
        }

        if (search.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            System.out.println("\n검색 결과 : ");
            for (BookDTO book : search) {
                System.out.printf("도서명:%s    저자:%s    출판사:%s    발행일:%s    분류:%s    가격:%d    쪽수:%d    ISBN:%s\n",
                        book.getBookName(), book.getAuthor(), book.getPublisher(), book.getPubDate(), book.getDepartment(), book.getPrice(), book.getPrintLen(), book.getIsbn());
            }
        }
    }
}