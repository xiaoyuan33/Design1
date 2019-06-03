package com;
import javax.jws.WebService;  
@WebService(endpointInterface = "com.Login", serviceName = "Login")
public class LoginImpl implements Login { 
  public String login(String name, String password) {  
    String result = "登录CXF 服务端成功!";   
     if (!"cxf".equalsIgnoreCase(name) || !"cxf".equalsIgnoreCase(password)) {
         result = "用户名或密码不正确，请重新登录!";   
  } 
   return result; 
    }  
}