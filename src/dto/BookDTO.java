package dto;
// 책 이름, 저자, 출판사 등 책의 데이터를 ArrayList로 만드는 클래스
// 사용자가 편집하길 원하는 모든 데이터를 가지고 있어야 한다.
// View나 Controller에 대해서 어떤 정보도 알지 말아야 한다. View의 캡슐화가 잘 되어야 한다.

public class BookDTO {
    // 도서 이름, 저자, 출판사, 발행일, 분류, 가격, 쪽수, ISBN
    private String bookName;
    private String author;
    private String publisher;
    private String pubDate;
    private String department;
    private int price;
    private int printLen;
    private String isbn;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrintLen() {
        return printLen;
    }

    public void setPrintLen(int printLen) {
        this.printLen = printLen;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BookDTO(String bookName, String author, String publisher, String pubDate, String department, int price, int printLen, String isbn) {
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.pubDate = pubDate;
        this.department = department;
        this.price = price;
        this.printLen = printLen;
        this.isbn = isbn;
    }
}
