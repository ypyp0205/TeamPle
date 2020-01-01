package VO;

public class PaymentVO {
    private String userId;
    private String bookName;
    private String regDate;
    private int totPayment=0;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getTotPayment() {
        return totPayment;
    }

    public void setTotPayment(int totPayment) {
        this.totPayment = totPayment;
    }
}
