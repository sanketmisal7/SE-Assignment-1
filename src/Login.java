
public class Login {
String username,password;

public Login() {
}

public String verify(){
    if(username.equals("admin") && password.equals("admin"))
    {
        return "success";
    }
    return "failed";
}

public String getusername() {
    return username;
}

public void setusername(String username) {
    this.username = username;
}

public String getpassword() {
    return password;
}

public void setpassword(String password) {
    this.password = password;
}
}
