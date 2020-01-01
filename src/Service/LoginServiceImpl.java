package Service;

import Dao.LoginDao;
import VO.UserVO;

public class LoginServiceImpl implements LoginService {
    public LoginDao loginDao=new LoginDao();
    @Override
    public void login() {
        loginDao.login();
    }

     @Override
    public boolean longinCheck(UserVO userVO) {
         return loginDao.loginCheck(userVO);
    }
}
