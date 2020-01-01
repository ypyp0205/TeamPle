package Dao;

import Service.DisplayMenu;
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

        System.out.println("원하시는 내용을 입력해주세요");
        System.out.println("1.도서검색");
        System.out.println("2.나의 장바구니");
        System.out.println("3.장바구니 목록 삭제");
        System.out.println("4.결재");
        System.out.println("0.뒤로가기");

        while(true) {
            menuId = scanner.nextLine();
            if (menuId.equals("1")) {
            	addBookShoppingBasket();
                break;
            } else if (menuId.equals("2")) {
            	bookShoppingBasketList();
                break;
            } else if (menuId.equals("3")) {
                removeBookName();
                break;
            } else if (menuId.equals("4")) {
                paymentDao.pay();
                break;
            }else if (menuId.equals("0")) {
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
        System.out.println("장바구니에 추가할 책을 검색하러 이동합니다. ");
        StringBuilder stringBuilder = bookDao.usingSearchForBookShoppingBasket();
        String bookName = stringBuilder.toString();
        System.out.print("주문할 책의 갯수:");
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
                       //재고가 부족한 도서에 대해서 5개씩 재고 추가
                        businessDao.addTrade(bookName,BookDao.BookList.get(i).getPublishCompanyName(),5,regDate);
                    } else if (answer.toLowerCase().equals("no")) {
                        System.out.println("구매가 취소되었습니다.장바구니 목록을 보여드리겠습니다.");
                        bookShoppingBasketList();
                    }
                } else if (BookDao.BookList.get(i).getStock() - stock >=0) {
                    System.out.println(bookName + "을 장바구니에 추가  하시겠습니까?(yes/no)");
                    answer = scanner.nextLine();
                    if (answer.toLowerCase().equals("yes")) {
                        bookShoppingBasketVO = new BookShoppingBasketVO();
                        bookShoppingBasketVO.setAmount(stock);
                        bookShoppingBasketVO.setId(LoginDao.loginSessionVO.getId());
                        bookShoppingBasketVO.setName(LoginDao.loginSessionVO.getName());
                        bookShoppingBasketVO.setBookName(bookName);
                        bookShoppingBasket.add(bookShoppingBasketVO);

                    } else if (answer.toLowerCase().equals("no")) {
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
    }


    public void removeBookName() {
        System.out.println("삭제하고 싶은 책 이름을 입력해주세요");
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
        for (BookShoppingBasketVO book : bookShoppingBasket) {
        	System.out.println("                        ▼");
            System.out.println("                        ▼");
            System.out.println("=================================================");
    		System.out.println("                    < 장바구니 >");
    		System.out.println("=================================================");
            System.out.println("책이름\t\t 수량");
            System.out.println(book.getBookName()+"\t\t "+book.getAmount());
            
        }
        bookShoppingBasketMenu();

}

}
