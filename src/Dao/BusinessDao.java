package Dao;

import VO.BusinessVO;

import java.awt.print.Book;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BusinessDao {
    public static List<BusinessVO> businessList=new ArrayList<>();
    public void addTrade() {
         String bookName;
         String publishingCompanyName;
         int quantity;
         String regDate;
        Scanner scanner=new Scanner(System.in);
        BusinessVO businessVO=new BusinessVO();
        System.out.println("                        ▼");
        System.out.println("                        ▼");
        System.out.println("=================================================");
        System.out.println("                 < 출판사에 도서 주문 >");
        System.out.println("=================================================");
        System.out.print("주문할 책 이름 : ");
        bookName=scanner.nextLine();
        System.out.print("주문할 출판사 이름 : ");
        publishingCompanyName=scanner.nextLine();
        System.out.print("주문할 수량 입력 : ");
        quantity=Integer.parseInt(scanner.nextLine());
        Date today=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        regDate=simpleDateFormat.format(today);
        businessVO.setBookName(bookName);
        businessVO.setPublishingCompanyName(publishingCompanyName);
        businessVO.setQuantity(quantity);
        businessVO.setRegDate(regDate);
        businessList.add(businessVO);
        System.out.println("해당출판사에게 책을 주문 완료 하였습니다.");

    }
    public void addTrade(String bookName ,String publishingCompanyName,int quantity, String regDate) {
        BusinessVO businessVO=new BusinessVO();
        businessVO.setBookName(bookName);
        businessVO.setPublishingCompanyName(publishingCompanyName);
        businessVO.setQuantity(quantity);
        businessVO.setRegDate(regDate);
        int sum=quantity;
        int searchidx=-1;
        for(int i=0;i<BookDao.BookList.size();i++){
            if(BookDao.BookList.get(i).getName().equals(bookName)){
                searchidx=i;
            }
        }
        //System.out.println(BookDao.BookList.get(searchidx).getStock()+sum);
        BookDao.BookList.get(searchidx).setStock(BookDao.BookList.get(searchidx).getStock()+sum);
        businessList.add(businessVO);
    }
    public void deleteTrade() {
        Scanner scanner=new Scanner(System.in);
        String bookName;
        System.out.print("주문을 취소할 책 이름 : ");
        bookName=scanner.nextLine();
        for(int i=0;i<businessList.size();i++){
            if(businessList.get(i).getBookName().equals(bookName)){
                businessList.remove(i);
            }
        }
        System.out.println("주문이 취소 되었습니다.");
    }
    public void showTradeHistory(){
    	System.out.println("                        ▼");
        System.out.println("                        ▼");
    	System.out.println("=================================================");
    	System.out.println("                  < 도서 거래내역 >");
    	System.out.println("=================================================");
        System.out.println("책이름\t수량\t출판사이름\t주문일");

        if(businessList.size()!=0) {
            for (BusinessVO vo : businessList) {
                System.out.println(vo.getBookName() + "\t" +vo.getQuantity()+"\t"+ vo.getPublishingCompanyName() + "\t" + vo.getRegDate());
                
            }
        }
        else{
            System.out.println("거래내역없음");
        }
    }
        
    public void quantity() {
    	if(businessList.size()!=0) {
            for (BusinessVO vo : businessList) {
             int cnt =   vo.getQuantity();
                
            }
        }
	}
        
        
        
        
        

}
