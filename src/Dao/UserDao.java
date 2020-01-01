package Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Service.DisplayMenu;
import VO.UserVO;

public class UserDao {
    public static List<UserVO> userList = new ArrayList<>();

    static {
        UserVO admin = new UserVO();
        admin.setId("admin");
        admin.setPassword("admin");
        admin.setAddress("admin");
        admin.setPhonNumber("admin");
        admin.setRoll("admin");
        userList.add(admin);

        UserVO user = new UserVO();
        user.setId("user");
        user.setPassword("user");
        user.setName("user");
        user.setAddress("user");
        user.setPhonNumber("user");
        user.setRoll("user");
        user.setPoint(20000);
        userList.add(user);

    }

    public void insertUser(UserVO vo) {
        int a = 0;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(vo.getId())) {
                System.out.println("이미 가입된 계정입니다.");
                break;
            } else {
                a++;
            }
        }
        if (a == userList.size()) {
            System.out.println("가입됨");
            UserVO user = new UserVO();
            user.setId(vo.getId());
            user.setName(vo.getName());
            user.setAddress(vo.getAddress());
            user.setPhonNumber(vo.getPhonNumber());
            user.setPassword(vo.getPassword());
            user.setPoint(vo.getPoint());
            user.setRoll(vo.getRoll());
            userList.add(user);
        }

    }


    public void login() {


    }

    public void userList() {
    	System.out.println("                        ▼");
        System.out.println("                        ▼");
    	System.out.println("=================================================");
    	System.out.println("                   < 회원 목록 >");
    	System.out.println("=================================================");
        System.out.println("아이디 \t" + "이름\t" + "주소\t" + "전화번호\t" + "포인트\t" + "분류");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).getId() + "\t" + userList.get(i).getName() + "\t" +
                    userList.get(i).getAddress() + "\t" + userList.get(i).getPhonNumber()
                    + "\t" + userList.get(i).getPoint() + "\t" + userList.get(i).getRoll());
        }

    }

    public void userDelete(String deleteId) { //삭제

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(deleteId)) {
                userList.remove(i);
                System.out.println(deleteId + "가 삭제되었습니다.");
            }
        }
    }


    public void myPage() { //마이페이지
        Scanner s = new Scanner(System.in);
        String a = "";
        String answer;
        for (int i = 0; i < userList.size(); i++) {
            if (LoginDao.loginSessionVO.getId().equals(userList.get(i).getId())) {
            	System.out.println("                        ▼");
                System.out.println("                        ▼");
            	System.out.println("=================================================");
            	System.out.println("                   < 마이페이지 >");
            	System.out.println("=================================================");
                System.out.println("아이디 : " + userList.get(i).getId());
                System.out.println("포인트 : " + userList.get(i).getPoint());
                System.out.print("1.비밀번호 : ");
                for (int j = 0; j < userList.get(i).getPassword().length(); j++) {
                    System.out.print("*");
                }
                System.out.println();
                a = userList.get(i).getPassword();
                System.out.println("2.이름 : " + userList.get(i).getName());
                System.out.println("3.주소 : " + userList.get(i).getAddress());
                System.out.println("4.전화번호 : " + userList.get(i).getPhonNumber());
                System.out.println("수정하시겠습니까? (y/n)");
                answer = s.nextLine();
                if (answer.toLowerCase().equals("y")) {
                    System.out.println("수정할 정보의 번호를 입력해주세요");
                    int menu = Integer.parseInt(s.nextLine());
                    String revise = "";
                    switch (menu) {
                        case 1:
                            do {
                                System.out.println("기존 비밀번호 : ");
                                revise = s.nextLine();
                                if (!a.equals(revise)) {
                                    System.out.println("비밀번호가 다릅니다.");
                                }
                            } while (!a.equals(revise));
                            System.out.println("새로운 비밀번호 : ");
                            revise = s.nextLine();
                            userList.get(i).setPassword(revise);
                            break;
                        case 2:
                            System.out.println("이름 : ");
                            revise = s.nextLine();
                            userList.get(i).setName(revise);
                            break;
                        case 3:
                            System.out.println("주소 : ");
                            revise = s.nextLine();
                            userList.get(i).setAddress(revise);
                            break;
                        case 4:
                            System.out.println("전화번호 : ");
                            revise = s.nextLine();
                            userList.get(i).setPhonNumber(revise);
                            break;
                    }
                    System.out.println("수정되었습니다.");
                } else if (answer.toLowerCase().equals("n")) {
                    DisplayMenu displayMenu = new DisplayMenu();
                    displayMenu.userMenu();
                }
            }
        }
    }
}
