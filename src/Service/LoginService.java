package Service;

import VO.UserVO;

public interface LoginService {
    public void login();
    public boolean longinCheck(UserVO vo);
}
