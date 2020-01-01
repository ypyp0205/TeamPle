package Service;

import Dao.BookDao;
import Dao.BookShoppingBasketDao;
import Dao.LoginDao;
import VO.LoginSessionVO;

import java.io.PrintStream;
import java.util.Scanner;

public class DisplayMenu {
    private PrintStream printStream = new PrintStream(System.out);
    private BookSeviceImpl bookSeviceImpl = new BookSeviceImpl();
    private LoginServiceImpl loginServiceImpl = new LoginServiceImpl();//login  체크를 위해서 필요
    private PartnerCompanyManagementServiceImpl partnerCompanyManagementServiceImpl = new PartnerCompanyManagementServiceImpl();
    private BookShoppingBasketServiceImpl bookShoppingBasketServiceImpl = new BookShoppingBasketServiceImpl();
    private UserServieImpl userServieImpl = new UserServieImpl();
    private BusinessServiceImpl businessServiceImpl = new BusinessServiceImpl();
    private PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();

    //시작메뉴
    public void defaultMenu() {
		System.out.println("                        ▼");
	    System.out.println("                        ▼");
	    System.out.println("                        ▼");
    	printStream.println("=================================================");
        printStream.println("                   < 책조24 >");
        printStream.println("=================================================");
        printStream.println("1.도서검색");
        printStream.println("2.베스트 셀러 목록");
        printStream.println("3.로그인");
        printStream.println("4.회원가입");
        printStream.println("0.종료");
        selectedDefaultMenu();
        
    }

    public void selectedDefaultMenu() {

        Scanner scanner = new Scanner(System.in);
        String selectedNum;
        while (true) {
        	
            System.out.print("번호를 입력해주세요 >");
           
            selectedNum = scanner.nextLine();
            if (selectedNum.equals("1")) {
                bookSeviceImpl.searchBook();
                defaultMenu();
            } else if (selectedNum.equals("2")) {
                bookSeviceImpl.showBestSeller();
                defaultMenu();
            } else if (selectedNum.equals("3")) {
                while (true) {
                    if (LoginDao.loginSessionVO == null) {
                        loginServiceImpl.login();
                    }
                    if (LoginDao.loginSessionVO.getRoll().equals("admin")) {
                        adminLoginMenu();
                        break;
                    } else if (LoginDao.loginSessionVO.getRoll().equals("user")) {
                        userMenu();
                        break;
                    }
                }
            } else if (selectedNum.equals("4")) {
                userServieImpl.addUser();
            } else if (selectedNum.equals("0")) {
                System.out.println("프로그램이 종료 되었습니다.");
                System.exit(0);
            }
        }
    }

    public void userMenu() {
//        printStream.println("종료라고 첫 화면으로 돌아 갑니다.");
//        printStream.println("1.도서검색");
//        printStream.println("2.베스트셀러 보러가기");
//        printStream.println("3.장바구니로 가기 ");
//        printStream.println("4.구매내역보기 ");
//        printStream.println("5.평점 입력 하기");
//        printStream.println("6.마이페이지");
        userSelectedMenu();
    }

    public void userSelectedMenu() {
        Scanner scanner = new Scanner(System.in);
        String selectedNum;
        while (true) {
        	
        	
        	printStream.println("                        ▼");
        	printStream.println("                        ▼");
        	printStream.println("                        ▼");
        	printStream.println("=================================================");
            printStream.println("                   < 회원 메뉴 >");
            printStream.println("=================================================");
            printStream.println("1.베스트셀러 TOP10");
            printStream.println("2.도서 정보 검색");
            printStream.println("3.도서 구매  ");
            printStream.println("4.최근 구매내역 ");
            printStream.println("5.도서 평점 주기");
            printStream.println("6.마이페이지");
            printStream.println("0.뒤로가기");
            System.out.print("번호를 입력해주세요 >");
            selectedNum = scanner.nextLine();
            if (selectedNum.equals("1")) {
                bookSeviceImpl.showBestSeller();
            } else if (selectedNum.equals("2")) {
            	bookSeviceImpl.searchBook();
            } else if (selectedNum.equals("3")) {
                bookShoppingBasketServiceImpl.bookShoppingBasketMenu();
            } else if (selectedNum.equals("4")) {
                paymentServiceImpl.payList();
            } else if (selectedNum.equals("5")) {
                bookSeviceImpl.userRating();
            } else if (selectedNum.equals("6")) {
                userServieImpl.myPage();
            } else if (selectedNum.equals("0")) {
                 printStream.println("로그아웃 되었습니다. 첫 페이지로 돌아갑니다.");
                LoginDao.loginSessionVO = null;
                defaultMenu();
            }
        }
    }

    public void adminLoginMenu() {
//        printStream.println("종료라고 첫 화면으로 돌아 갑니다.");
//        printStream.println("1.새로운 책 등록");
//        printStream.println("2.도서 재고 관리");
//        printStream.println("3.출판사별 거래 내역보기");
//        printStream.println("4.출판사 목록");
//        printStream.println("5.회원 목록보기 ");
//        printStream.println("6.회원 삭제하기 ");

        adminSelectedMenu();
    }

    public void adminSelectedMenu() {
        Scanner scanner = new Scanner(System.in);
        String selectedNum;
        while (true) {
        	System.out.println("                        ▼");
        	System.out.println("                        ▼");
            System.out.println("                        ▼");
        	printStream.println("=================================================");
        	printStream.println("                   < 관리자 메뉴 >");
        	printStream.println("=================================================");
            printStream.println("1.신규도서 및 출판사 정보등록");
            printStream.println("2.출판사에 도서 주문");
            printStream.println("3.출판사별 거래 내역");
            printStream.println("4.등록된 출판사 목록");
            printStream.println("5.회원 목록보기 ");
            printStream.println("6.회원 삭제하기 ");
            printStream.println("0.로그아웃");
            System.out.print("번호를 입력해주세요 >");
            selectedNum = scanner.nextLine();
            if (selectedNum.equals("1")) {
                bookSeviceImpl.registBook();
            } else if (selectedNum.equals("2")) {
                bookSeviceImpl.adminSearchBuyBook();
            } else if (selectedNum.equals("3")) {
                businessServiceImpl.showTradeHistory();
            } else if (selectedNum.equals("4")) {
                partnerCompanyManagementServiceImpl.getPartnerList();
            } else if (selectedNum.equals("5")) {
                userServieImpl.ListUser();
            }else if (selectedNum.equals("6")) {
                userServieImpl.deleteUser();;
            }   else if (selectedNum.equals("0")) {
                LoginDao.loginSessionVO=null;
                defaultMenu();
                break;

            }
        }
    }
}
