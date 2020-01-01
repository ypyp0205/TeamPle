package VO;

import java.util.Date;

public class PayVO {
	
    private String payUserId;  //결제한 사람
    private String payUserAdd;
    private String payUserPhonNum;
    private String regDate;

	private String payNum;  //결제번호
    private String payComments; // 요청사항
    private String payBookName;
    private int payBookQuantity; //수량 
    private int payPrice;  //결제하는 책 가격
    
    
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

    public String getPayUserId() {
		return payUserId;
	}
	public void setPayUserId(String payUserId) {
		this.payUserId = payUserId;
	}
	public String getPayUserAdd() {
		return payUserAdd;
	}
	public void setPayUserAdd(String payUserAdd) {
		this.payUserAdd = payUserAdd;
	}
	public String getPayUserPhonNum() {
		return payUserPhonNum;
	}
	public void setPayUserPhonNum(String payUserPhonNum) {
		this.payUserPhonNum = payUserPhonNum;
	}
	public String getPayNum() {
		return payNum;
	}
	public void setPayNum(String payNum) {
		this.payNum = payNum;
	}
	public String getPayComments() {
		return payComments;
	}
	public void setPayComments(String payComments) {
		this.payComments = payComments;
	}
	public String getPayBookName() {
		return payBookName;
	}
	public void setPayBookName(String payBookName) {
		this.payBookName = payBookName;
	}
	public int getPayBookQuantity() {
		return payBookQuantity;
	}
	public void setPayBookQuantity(int payBookQuantity) {
		this.payBookQuantity = payBookQuantity;
	}
	public int getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(int payPrice) {
		this.payPrice = payPrice;
	}




}
