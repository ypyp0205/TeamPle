package VO;

public class BusinessVO {
    public String bookName;
    public String publishingCompanyName;
    public int quantity;
    public String regDate;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublishingCompanyName() {
        return publishingCompanyName;
    }

    public void setPublishingCompanyName(String publishingCompanyName) {
        this.publishingCompanyName = publishingCompanyName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
