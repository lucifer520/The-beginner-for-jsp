import com.opensymphony.xwork2.ActionSupport;
public class LoginAction extends ActionSupport{
	 private static final long serialVersionUID = 1L;
	 private String username;
	 private String password;
	 
	 public String getUsername() {
	  return username;
	 }
	 public void setUsername(String username) {
	  this.username = username;
	 }
	 public String getPassword() {
	  return password;
	 }
	 public void setPassword(String password) {
	  this.password = password;
	 }

	 @Override
	 public String execute() throws Exception {
	  if("haha".equals(username) && "hehe".equals(password))//如果登录的用户名=haha并且密码=hehe，就返回SUCCESS；否则，返回LOGIN
	   return SUCCESS;
	  return LOGIN;
	 }
}
