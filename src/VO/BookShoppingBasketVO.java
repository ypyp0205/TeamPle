package VO;

public class BookShoppingBasketVO {
    private String bookName;//구매한 책이름
    private String id;//구매자 아이디
    private String name;//구매자 이름
    private int amount;//구매 수량

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
