package com.mkyong.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.polimi.user.dao.UserDAO;
import com.polimi.user.model.User;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = 
    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	 
        UserDAO userDAO = (UserDAO) context.getBean("userDAO");
        User user = new User(1, "abc",28);
        userDAO.insert(user);
    	
        User usernew = userDao.findByUserId(1);
        System.out.println(usernew);
        
    }
}

//package com.polimi.awt;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class App {
//	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"Spring-Module.xml");
//
//		HelloUser obj = (HelloUser) context.getBean("helloBean");
//		obj.printHello();
//	}
//}
