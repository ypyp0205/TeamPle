package Dao;

import VO.LoginSessionVO;
import VO.UserVO;

import java.util.Scanner;

public class LoginDao {
    public static LoginSessionVO loginSessionVO; //로그인 세션
    public void login (){
        String id;
        String password;
        Scanner scanner=new Scanner(System.in);


    	//아이디와 패스워드를 입력받음
          
        	System.out.println("                        ▼");
        	System.out.println("                        ▼");
        	System.out.println("                        ▼");
        	System.out.println("=================================================");
    		System.out.println("                    < 로그인 >");
    		System.out.println("=================================================");
            System.out.print("ID : ");
            id = scanner.nextLine();
            System.out.print("PASSWORD : ");
            password = scanner.nextLine();
        // 입력된 아이디와 패스워드를 vo에 저장
            UserVO vo = new UserVO();
            vo.setId(id);
            vo.setPassword(password);
        //loginCheck에 유저 정보를 넘김
            boolean isLogin = loginCheck(vo);
            if(isLogin == false){
            	System.out.println("아이디가 없거나 비밀번호가 다릅니다. 다시 입력해주세요");
            	login();
            }

    }
    public boolean loginCheck(UserVO vo) {
//        while (true) {
            for (int i = 0; i < UserDao.userList.size(); i++) {
                if (UserDao.userList.get(i).getId().equals(vo.getId())) {
                    if (UserDao.userList.get(i).getPassword().equals(vo.getPassword())) {
                        if (UserDao.userList.get(i).getRoll().equals("user")) {
                            loginSessionVO = new LoginSessionVO();
                            loginSessionVO.setId(vo.getId());
                            loginSessionVO.setRoll("user");
                            System.out.println(UserDao.userList.get(i).getName()+"님 로그인 되었습니다.");
                            return true;
                        } else if (UserDao.userList.get(i).getRoll().equals("admin")) {
                            loginSessionVO = new LoginSessionVO();
                            loginSessionVO.setId(vo.getId());
                            loginSessionVO.setRoll("admin");
                            return true;
                        }
                    } else {//비밀번호가 다를때 false 리턴
                        return false;
                    }
                 } 
            }return false; //아이디가 다를떄 false 리턴
//        }
    }
}
