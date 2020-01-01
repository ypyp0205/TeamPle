package VO;

import Dao.BookDao;

import java.util.Comparator;

public class BookVO implements Comparable<BookVO> {

    private String name;//책이름
    private String authorName;//작가이름
    private String categoryName;//카테고리
    private String regDate;//책등록일자
    private static int management = 0;//관리 번호
    private String publishCompanyName;//출판사 이름
    private int salePoint;
    private int stock;//재고
    private int price;
    private double score;//점수 1~10점까지 가능
    private String comment;//한줄평
    private String userId;

    public BookVO() {
        management++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public static int getManagement() {
        return management;
    }

    public static void setManagement(int management) {
        BookVO.management = management;
    }

    public String getPublishCompanyName() {
        return publishCompanyName;
    }

    public void setPublishCompanyName(String publishCompanyName) {
        this.publishCompanyName = publishCompanyName;
    }

    public int getSalePoint() {
        return salePoint;
    }

    public void setSalePoint(int salePoint) {
        this.salePoint = salePoint;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public int compareTo(BookVO o) {
        if (this.salePoint > o.getSalePoint()) {
            return -1;
        } else if (this.salePoint < o.getSalePoint()) {
            return 1;
        }
        return 0;
    }
}
