package Dao;

import Service.DisplayMenu;
import Service.UserServieImpl;
import VO.BookShoppingBasketVO;

import java.text.SimpleDateFormat;
import java.util.*;

public class BookShoppingBasketDao {
    public static List<BookShoppingBasketVO> bookShoppingBasket = new ArrayList<>();
    private PaymentDao paymentDao = new PaymentDao();
    private BookDao bookDao = new BookDao();
    private BusinessDao businessDao=new BusinessDao();
    BookShoppingBasketVO bookShoppingBasketVO;


    public BookShoppingBasketDao() {
    }

    public void bookShoppingBasketMenu() {
        Scanner scanner = new Scanner(System.in);
        String menuId;

        System.out.println("                        ▼");
    	System.out.println("                        ▼");
        System.out.println("                        ▼");
        System.out.println("=================================================");
        System.out.println("                   < 도서 구매 >");
        System.out.println("=================================================");
        System.out.println("1.도서 검색");
        System.out.println("2.장바구니 목록");
     //   System.out.println("3.장바구니 목록 삭제");
        System.out.println("3.결재");
        System.out.println("0.뒤로가기");
        System.out.println("번호를 입력해주세요 >");

        while(true) {
            menuId = scanner.nextLine();
            if (menuId.equals("1")) {
            	addBookShoppingBasket();
                break;
            } else if (menuId.equals("2")) {
            	bookShoppingBasketList();
                break;
            } else if (menuId.equals("3")) {
                paymentDao.pay();
                break;
            } /*else if (menuId.equals("3")) {
            	removeBookName();
            	break;
            }*/else if (menuId.equals("0")) {
                DisplayMenu displayMenu = new DisplayMenu();
                displayMenu.userMenu();
                break;
            }
        }
    }

    public void addBookShoppingBasket() {
        String answer;
        Scanner scanner = new Scanner(System.in);
        int stock;
        System.out.println("                        ▼");
    	System.out.println("                        ▼");
        System.out.println("                        ▼");
        System.out.println("=================================================");
        System.out.println("             < 장바구니에 담을 도서 검색 >");
        System.out.println("=================================================");
       
        StringBuilder stringBuilder = bookDao.usingSearchForBookShoppingBasket();
        String bookName = stringBuilder.toString();
        
        
        System.out.println("\"" + bookName + "\"" + "을 장바구니에 추가  하시겠습니까? (y/n)");
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        UserServieImpl us = new UserServieImpl();
        
        if ("y".equals(a)){
        	 System.out.print("주문할 수량 : ");
             stock = Integer.parseInt(scanner.nextLine());
             for (int i = 0; i < BookDao.BookList.size(); i++) {
                 if (BookDao.BookList.get(i).getName().equals(bookName)) {
                     if (BookDao.BookList.get(i).getStock() - stock < 0) {
                         System.out.println("재고가 부족합니다. 현재 " + bookName + "의 재고는 " + (BookDao.BookList.get(i).getStock()) + "개 있습니다." + (BookDao.BookList.get(i).getStock()) + "라도 장바구니에 추가 하시겠습니까?(yes/no)");
                         answer = scanner.nextLine();
                         if (answer.toLowerCase().equals("yes")) {
                             bookShoppingBasketVO = new BookShoppingBasketVO();
                             bookShoppingBasketVO.setAmount(BookDao.BookList.get(i).getStock());
                             bookShoppingBasketVO.setId(LoginDao.loginSessionVO.getId());
                             bookShoppingBasketVO.setName(LoginDao.loginSessionVO.getName());
                             bookShoppingBasketVO.setBookName(bookName);
                             bookShoppingBasket.add(bookShoppingBasketVO);
                             Date today=new Date();
                             SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                            String regDate=simpleDateFormat.format(today);
                          
                         } else if (answer.toLowerCase().equals("no")) {
                             System.out.println("구매가 취소되었습니다.장바구니 목록을 보여드리겠습니다.");
                             bookShoppingBasketList();
                         }
                     } else if (BookDao.BookList.get(i).getStock() - stock >=0) {
                    	
                       
                         if (a.toLowerCase().equals("y")) {
                             bookShoppingBasketVO = new BookShoppingBasketVO();
                             bookShoppingBasketVO.setAmount(stock);
                             bookShoppingBasketVO.setId(LoginDao.loginSessionVO.getId());
                             bookShoppingBasketVO.setName(LoginDao.loginSessionVO.getName());
                             bookShoppingBasketVO.setBookName(bookName);
                             bookShoppingBasket.add(bookShoppingBasketVO);
                             System.out.println("장바구니에 " + bookName + "이/가 추가되었습니다.");
                         } else if (a.toLowerCase().equals("n")) {
                             System.out.println("구매가 취소되었습니다.장바구니 목록을 보여드리겠습니다.");
                             bookShoppingBasketList();
                         }
                     } else {
                         System.out.println("현재 준비된 재고가 없습니다.");
                         bookShoppingBasketList();
                     }
                 }
             }
             bookShoppingBasketMenu();
        	
		
        
        
        
        
        }else if("n".equals(a)){
        	 bookShoppingBasketMenu();
		}
      
        
        
        
       
    }


    public void removeBookName() {
    	
    	  System.out.println("                        ▼");
    	  System.out.println("                        ▼");
          System.out.println("                        ▼");
          System.out.println("=================================================");
          System.out.println("                < 장바구니 목록 삭제 >");
          System.out.println("=================================================");
         
        System.out.print("삭제할 도서의 이름 >");
        Scanner s = new Scanner(System.in);
        String userSearch = s.nextLine();
        boolean b2;
        for (int i = 0; i < bookShoppingBasket.size(); i++) {
            b2 = bookShoppingBasket.get(i).getBookName().toLowerCase().replace(" ", "").contains(userSearch.replace(" ", "").toLowerCase());
          if(b2==true)
              bookShoppingBasket.remove(i);
        }
        bookShoppingBasketMenu();
    }

    public void bookShoppingBasketList() {
    	
    	 System.out.println("                        ▼");
   	  	 System.out.println("                        ▼");
         System.out.println("                        ▼");
         System.out.println("=================================================");
         System.out.println("                  < 장바구니 목록 >");
         System.out.println("=================================================");
        
         System.out.println("책이름\t\t 수량");
    	
        for (BookShoppingBasketVO book : bookShoppingBasket) {

            System.out.println(book.getBookName()+"\t\t "+book.getAmount());
        }
        System.out.println("장바구니에서 삭제하고 싶은 도서가 있나요? (y/n)");
        Scanner s = new Scanner(System.in);
        String qwe = s.nextLine();
        if(qwe.equals("y")) {
			removeBookName();
		}else if(qwe.equals("n")){
			bookShoppingBasketMenu();
		}        
				
            
            

	}

}
