package Dao;


import Service.DisplayMenu;
import VO.BookRatingVO;
import VO.BookVO;
import VO.BusinessVO;
import VO.PartnerCompanyVO;

import java.text.SimpleDateFormat;
import java.util.*;

public class BookDao {
    public static List<BookVO> BookList = new ArrayList<>();
    private BusinessDao businessDao = new BusinessDao();

    /*

        static {
            BookVO[] bookVOscience = new BookVO[5];
            BookVO[] bookVOessey = new BookVO[5];
            BookVO[] bookVOHistory = new BookVO[5];
            BookVO[] bookVOstudy = new BookVO[5];
            //--------------------------------------------------------과학
            BookVO bookVO1 = new BookVO();
            bookVO1.setAuthorName("칼세이건");
            bookVO1.setCategoryName("과학");
            bookVO1.setName("코스모스");
            bookVO1.setRegDate("2019-12-25");
            bookVO1.setPublishCompanyName("사이언스북스");
            bookVO1.setStock(10);
            bookVO1.setSalePoint(16500);
            bookVO1.setPrice(10000);
            bookVO1.setScore(0);
            BookVO bookVO2 = new BookVO();
            bookVO2.setAuthorName("옥스토비");
            bookVO2.setCategoryName("과학");
            bookVO2.setName("옥스토비의 일반화학");
            bookVO2.setRegDate("2019-12-19");
            bookVO2.setStock(10);
            bookVO2.setSalePoint(7500);
            bookVO2.setPrice(10000);
            bookVO2.setPublishCompanyName("사이플러스");
            bookVO2.setScore(0);
            BookVO bookVO3 = new BookVO();
            bookVO3.setAuthorName("맨큐");
            bookVO3.setCategoryName("과학");
            bookVO3.setName("맨큐의 경제학");
            bookVO3.setRegDate("2019-12-19");
            bookVO3.setPublishCompanyName("Cengage Learning");
            bookVO3.setSalePoint(3000);
            bookVO3.setStock(10);
            bookVO3.setPrice(14000);
            bookVO3.setScore(0);
            */
    
	public static List<BookRatingVO> BookRatingList=new ArrayList<>();
    public void registBook() {                                            //신규 도서 정보 등록
        String name;
        String categoryName;
        String publishCompanyName;
        String authorName;
        int stock;
        int price;


        String agentName;
        String directorName;
        String directPhoneNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.println("                        ▼");
        System.out.println("                        ▼");
        System.out.println("=================================================");
        System.out.println("                  < 도서 정보 등록 >");
        System.out.println("=================================================");
        
        System.out.print("책이름 입력 : ");
        BookVO bookVO = new BookVO();
        name = scanner.nextLine();
        for (int i = 0; i < BookList.size(); i++) {
            if (BookList.get(i).getName().equals(name)) {
                System.out.println("이미등록된 책입니다.");
                DisplayMenu displayMenu = new DisplayMenu();
                displayMenu.adminLoginMenu();
            }

        }
        System.out.print("카테고리 입력 : ");
        categoryName = scanner.nextLine();
        System.out.print("출판사 이름 : ");
        publishCompanyName = scanner.nextLine();
        System.out.print("저자 이름 : ");
        authorName = scanner.nextLine();
        
        System.out.print("가격 : ");
        price = Integer.parseInt(scanner.nextLine());
        System.out.println("                        ▼");
        System.out.println("                        ▼");
        System.out.println("=================================================");
        System.out.println("                 < 출판사 정보 등록 >");
        System.out.println("=================================================");
        System.out.print("출판사 대표이름 : ");
        agentName=scanner.nextLine();
        System.out.print("출판사 담당자 이름 : ");
        directorName=scanner.nextLine();
        System.out.print("출판사 담당자 연락처 : ");
        directPhoneNumber=scanner.nextLine();
        System.out.println("도서 및 출판사 등록이 완료되었습니다.");        
        bookVO.setName(name);
        bookVO.setCategoryName(categoryName);
        bookVO.setPublishCompanyName(publishCompanyName);
        bookVO.setAuthorName(authorName);
    
        bookVO.setPrice(price);
        bookVO.setScore(0);
        bookVO.setComment("");
        Date today = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        bookVO.setRegDate(simpleDateFormat.format(today));

        BookList.add(bookVO);

        PartnerCompanyVO partnerCompanyVO = new PartnerCompanyVO();
        partnerCompanyVO.setPublishingBook(name);
        partnerCompanyVO.setCompanyName(publishCompanyName);
        partnerCompanyVO.setAgentName(agentName);
        partnerCompanyVO.setDirectorName(directorName);
        partnerCompanyVO.setDirectPhoneNumber(directPhoneNumber);
        PartnerCompanyDao.partnerCompanys.add(partnerCompanyVO);


    }

    public void searchBook() {            //도서검색

        Scanner s = new Scanner(System.in);
        System.out.println("검색어를 입력해주세요 > ");
        String userSearch = s.nextLine();

        boolean b1 = false;
        boolean b2 = false;
        boolean b3 = false;
        boolean b4 = false;
        int noSearch = 0;

        System.out.print("\"" + userSearch + "\"" + "으로 ");
 
        System.out.println("                        ▼");
        System.out.println("                        ▼");
        System.out.println("=================================================");
        System.out.println("                    < 도서정보 >");
        System.out.println("=================================================");
        System.out.println("검색하신 결과입니다.");
        for (int i = 0; i < BookList.size(); i++) {
            b1 = BookList.get(i).getCategoryName().toLowerCase().replace(" ", "").contains(userSearch.replace(" ", "").toLowerCase());
            b2 = BookList.get(i).getName().toLowerCase().replace(" ", "").contains(userSearch.replace(" ", "").toLowerCase());
            b3 = BookList.get(i).getAuthorName().toLowerCase().replace(" ", "").contains(userSearch.replace(" ", "").toLowerCase());
            b4 = BookList.get(i).getPublishCompanyName().toLowerCase().replace(" ", "").contains(userSearch.replace(" ", "").toLowerCase());

            if (b1 == true || b2 == true || b3 == true || b4 == true) {

                System.out.println("카테고리 : " + BookList.get(i).getCategoryName());
                System.out.println("책이름 : " + BookList.get(i).getName());
                System.out.println("작가 : " + BookList.get(i).getAuthorName());
                System.out.println("출판일 : " + BookList.get(i).getRegDate());
                System.out.println("출판사 : " + BookList.get(i).getPublishCompanyName());
                System.out.println("재고 : " + BookList.get(i).getStock());
                System.out.println("가격 : " + BookList.get(i).getPrice());
                System.out.println("평점 : " + BookList.get(i).getScore());
                
            } else if (b1 != true && b2 != true && b3 != true) {
                noSearch++;
            }
        }//for문 종료

        if (noSearch == BookList.size()) {
            System.out.println("검색하신 도서가 없습니다.");
            
        }
    }

    
    
    
    public StringBuilder usingSearchForBookShoppingBasket() {        
        StringBuilder stringBuilder = new StringBuilder();
        Scanner s = new Scanner(System.in);
        System.out.println("검색어를 입력해주세요 > ");
        String userSearch = s.nextLine();
        int count = 0;
        boolean b2 = false;
        int noSearch = 0;

        System.out.print("\"" + userSearch + "\"" + "으로 ");
        System.out.println("검색하신 결과입니다.");
        

        for (int i = 0; i < BookList.size(); i++) {
            b2 = BookList.get(i).getName().toLowerCase().replace(" ", "").contains(userSearch.replace(" ", "").toLowerCase());
            if (b2 == true) {
                System.out.println("카테고리 : " + BookList.get(i).getCategoryName());
                System.out.println("책이름 : " + BookList.get(i).getName());
                System.out.println("작가 : " + BookList.get(i).getAuthorName());
                System.out.println("출판일 : " + BookList.get(i).getRegDate());
                System.out.println("출판사 : " + BookList.get(i).getPublishCompanyName());
                System.out.println("재고 : " + BookList.get(i).getStock());
                System.out.println("가격 : " + BookList.get(i).getPrice());
                System.out.println("평점 : " + BookList.get(i).getScore());
               
                stringBuilder.append(BookList.get(i).getName());
            } else if (b2 != true) {
                noSearch++;

            }
        }//for문 종료

        if (noSearch == BookList.size()) {
            System.out.println("검색하신 도서가 없습니다.");
            
            return null;
        }
        return stringBuilder;
    }

    
    
    
    
    public void adminSearchBuyBook() {                            //주문 하는곳
        Scanner scanner = new Scanner(System.in);
        
        
        for (int i = 0; i < BookDao.BookList.size(); i++){
            if (BookDao.BookList.get(i).getStock() >= 0) {
            	
            	
                
                int bookInsert;
                System.out.println("                        ▼");
                System.out.println("                        ▼");
                System.out.println("=================================================");
                System.out.println("                 < 거래처에 도서 주문 >");
                System.out.println("=================================================");
                System.out.println("<" + BookDao.BookList.get(i).getName() + ">" + " 도서를 주문할 수량을 입력해주세요.");
                bookInsert = Integer.parseInt(scanner.nextLine());
                Date today = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String regDate = simpleDateFormat.format(today);
                BookDao.BookList.get(i).setStock(bookInsert);
                businessDao.addTrade(BookDao.BookList.get(i).getName(), BookDao.BookList.get(i).getPublishCompanyName(), bookInsert, regDate);
                System.out.println("해당 출판사에 주문완료");

            	
            }
        }
    }


    
    
    
    
    public void showBestSeller() {									//베스트
        Scanner scanner = new Scanner(System.in);
        ArrayList<BookVO> bestSellerList = new ArrayList<>();

        String catergoryName;
        for (BookVO bookVO : BookList) {
            System.out.println(bookVO.getCategoryName() + "\t");
        }
        System.out.println("                        ▼");
        System.out.println("                        ▼");
        System.out.println("=================================================");
    	System.out.println("               < 베스트셀러 카테고리 검색>");
    	System.out.println("=================================================");
        System.out.print("카테고리를 입력해주세요 : ");
        catergoryName = scanner.nextLine();

        for (int i = 0; i < BookList.size(); i++) {
            if (BookList.get(i).getCategoryName().equals(catergoryName)) {
                Collections.sort(BookList);
            }
        }

        for (int i = 0; i < BookList.size(); i++) {
            if (BookList.get(i).getCategoryName().equals(catergoryName)) {
            	System.out.println("                        ▼");
                System.out.println("                        ▼");
            	System.out.println("=================================================");
            	System.out.println("                 < 베스트셀러 목록 >");
            	System.out.println("=================================================");
                System.out.println("카테고리 : " + BookList.get(i).getCategoryName());
                System.out.println("책이름 : " + BookList.get(i).getName());
                System.out.println("작가 : " + BookList.get(i).getAuthorName());
                System.out.println("판매량 : " + BookList.get(i).getSalePoint());
                System.out.println("평점 : " + BookList.get(i).getScore());

            }
        }
    }

   
    
    
    
    public void userRating() {          //유저가 한줄평을 작성하는 메서드
    	
        BookRatingVO bookRatingVO=new BookRatingVO();
    	PaymentDao paymentDao = new PaymentDao();
        String bookName = "";
		int score;
        String comment;
        boolean b = true;
   
        System.out.println("                        ▼");
        System.out.println("                        ▼");
        System.out.println("=================================================");
    	System.out.println("                  < 최근 구매 내역 >");
    	System.out.println("=================================================");
        Scanner s = new Scanner(System.in);

        
        
        do {
            if (b == false) {
                System.out.println("책 제목을 확인해주세요");
            }
            b = false;
            
            	
    		System.out.println("구매날짜  \t \t 책이름");
            for(int i = 0; i < paymentDao.payList.size(); i++) {
            	if(paymentDao.payList.get(i).getPayUserId().equals(LoginDao.loginSessionVO.getId())) {
            		System.out.println(paymentDao.payList.get(i).getRegDate() + "\t" + paymentDao.payList.get(i).getPayBookName());
            	}
             }
               
             
             System.out.print("책 제목 : ");
             bookName = s.nextLine();
             for(int i = 0; i<paymentDao.payList.size();i++) {
             if(bookName.replace(" ", "").equals(paymentDao.payList.get(i).getPayBookName().replace(" ", ""))){
            	 bookName = paymentDao.payList.get(i).getPayBookName();
            	 bookRatingVO.setBookName(bookName);
            	 b = true;
             	}
             }

        } while (b != true);


        do {
            b = false;
            System.out.print("점수(1~10) : ");
            score = Integer.parseInt(s.nextLine());
            if (score <= 0 || score >= 11) {
                System.out.println("점수는 1에서 10까지 가능합니다.");
            } else {
                b = true;
            }
        } while (b != true);

    

        bookRatingVO.setScore(score);
 
    	bookRatingVO.setUserId(LoginDao.loginSessionVO.getId());
        
        BookRatingList.add(bookRatingVO);
        
        
        //BookList에 평점 입력
        int sum = 0;
        double avg = 0;
        int cnt = 0;
        
        for(int i =0; i < BookList.size();i++) {
        	for(int j = 0; j < BookRatingList.size();j++) {
        		if(BookList.get(i).getName().equals(BookRatingList.get(j).getBookName())) {
        			cnt++;
        			sum += BookRatingList.get(j).getScore();
        		}
        	}
        	if(sum != 0) {
        	avg = ((int)(sum/cnt*10+0.5))/10.0;
        	
        	BookList.get(i).setScore(avg);
        	cnt =0;
        	sum=0;
        	}
        }

    }


    


}


