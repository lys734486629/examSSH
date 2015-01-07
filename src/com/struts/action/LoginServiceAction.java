package com.struts.action;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.StuDao;
import com.model.users.StuInfo;
import com.opensymphony.xwork2.ActionSupport;

public class LoginServiceAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	private Long stuid;
	private String username;
	private String password;
	private String identity;
	private HttpServletRequest request;
	private HttpServletResponse response;
//	private InputStream inputStream;
	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	StuDao stuDao=(StuDao)ctx.getBean("stuDao");
	
	public Long getStuid(){
		return stuid;
	}
	public void setStuid(Long id){
		this.stuid=id;
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getIdentity(){
		return identity;
	}
	public void setIdentity(String identity){
		this.identity=identity;
	}
	@Override
	public void setServletRequest(HttpServletRequest hsr) {
		// TODO Auto-generated method stub
		try {
			hsr.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request=hsr;
	}
	public void setServletResponse(HttpServletResponse hsp) {
		// TODO Auto-generated method stub
		hsp.setContentType("text/html;charset=UTF-8");
		response=hsp;
	}
//	public InputStream getInputStream() {  
//        return inputStream;  
//    }
//	public void setInputStream(InputStream input) {
//        this.inputStream = input;
//    }
  
    public String execute() throws Exception {  
        return SUCCESS;}
    
	public String excuteAjax() throws Exception{
		//student login
		PrintWriter out = response.getWriter();

		//System.out.println(username+","+password+","+identity);
		if(identity.equals("1")){
			stuid=Long.parseLong(username);
		List<StuInfo>stulist=stuDao.findByID(stuid);
		//id find or not?
		if(stulist.isEmpty()){

			out.print("iderror");
		}
		else{
		for (StuInfo stu:stulist) {
			
				if(stu.getStupwd().equals(password)){
				HttpSession session = request.getSession();
				session.setAttribute("stuname", stu.getStuname());
				session.setAttribute("stuinfo", stulist);
				return "success";
			    }else{
				out.print("pwderror");
				
			}
		}}
	}else if(identity.equals("2"))//teacher login
	{
		
	}else if(identity=="")
	{
		return "error";
	}
		return null;
	}
//	private String transcoding(String str) {  
//        try {  
//            return new String(str.getBytes("utf-8"), "iso-8859-1");  
//        } catch (UnsupportedEncodingException e) {  
//            e.printStackTrace();  
//        }  
//        return str;  
//    }  
}
