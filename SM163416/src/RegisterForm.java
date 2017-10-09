import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

public class RegisterForm implements DBConnection{
	String fname,lname,address,email,PhNo,password,username;
	int Id=0;
	public String registration() {
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://"+ICSI518_SERVER+":"+ICSI518_PORT+"/"+ICSI518_DB+"",ICSI518_USER,ICSI518_PASSWORD);
            
            PreparedStatement ps = con
                    .prepareStatement("insert into register(Name,address,phno,email,username,password) values(?,?,?,?,?,?)");
            ps.setString(1, fname+" "+lname);
            ps.setString(2, address);
            ps.setString(3, PhNo);
            ps.setString(4, email);
            
           ps.setString(5, username);
          ps.setString(6, password);
          PreparedStatement ps1=con.prepareStatement("insert into user(username,password) values (?,?);");
          ps1.setString(1, username);
          ps1.setString(2, password);
            int i=ps.executeUpdate();
            int i1=ps1.executeUpdate();
            	/*	 FacesContext facesContext=FacesContext.getCurrentInstance();
            		 Flash flash = facesContext.getExternalContext().getFlash();
            		 flash.setKeepMessages(true);
            		 flash.setRedirect(true);
            		 facesContext.addMessage("cbutton", new javax.faces.application.FacesMessage("Successfully registered")); 
            	*/
            if (i>0 && i1 >0)
            {
            return "registersuccess";
            }
            
            	
            
        } catch (Exception e2) {
            System.out.println(e2);
        }
		return "failed";
	}
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getPhNo()
	{
		return PhNo;
	}
	public void setPhNo(String PhNo)
	{
		this.PhNo = PhNo;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
