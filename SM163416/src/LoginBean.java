import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

public class LoginBean implements DBConnection {
String username,password;

public LoginBean() {
}
public String logout()
{	
	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    return "index?redirect=true";
}
public String verify(){
	Connection con = null;
	try {
		com.mysql.jdbc.jdbc2.optional.MysqlDataSource ds = new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
		ds.setServerName(ICSI518_SERVER);
		ds.setPortNumber(ICSI518_PORT);
		ds.setDatabaseName(ICSI518_DB);
		ds.setUser(ICSI518_USER);
		ds.setPassword(ICSI518_PASSWORD);

		// Get a connection object
		con = ds.getConnection();
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection con = DriverManager.getConnection(
//                "jdbc:mysql://"+ICSI518_SERVER+":"+ICSI518_PORT+"/"+ICSI518_PORT+"",ICSI518_USER,ICSI518_USER);
       
        	Statement stmt=con.createStatement();
        	String sql="Select * from user where username = '"+getusername()+"' and password = '"+getpassword()+"'";
        	ResultSet rs=stmt.executeQuery(sql);
        	if(rs.first()) {
        		System.out.print(rs.getString("username"));
        		if(rs.getString("username").equals(getusername()) && 
        				rs.getString("password").equals(getpassword()))
        	    {
        			FacesContext facesContext=FacesContext.getCurrentInstance();
           		 	Flash flash = facesContext.getExternalContext().getFlash();
           		 	flash.setKeepMessages(true);
           		 	flash.setRedirect(true);
           		 	facesContext.addMessage(null, new javax.faces.application.FacesMessage("Successfully registered"));
           		 	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", getusername()); 
           		 	return "success";
        	    }
        	}
        		else 
        		{
        			return"Failed";
        		}
        	
    } catch (Exception e2) {
        System.out.println(e2);
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
