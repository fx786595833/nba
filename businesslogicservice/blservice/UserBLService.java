package blservice;

import vo.UserVO;
import enumType.ResultMessage;

public interface UserBLService {
	public ResultMessage addUser(UserVO vo);
	public ResultMessage deleteUser(UserVO vo);
	public ResultMessage verify(long id,String password);
	public UserVO findUser(long id);
	public ResultMessage register(String text,String string);
	public String getPassword(long id,String name);
}
