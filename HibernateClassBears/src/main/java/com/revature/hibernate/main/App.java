package com.revature.hibernate.main;

import com.revature.hibernate.dao.BearDaoImpl;

public class App 
{
    public static void main( String[] args )
    {
//    	new BearDaoImpl().createBearsDemo();
//       new BearDaoImpl().criteriaDemo();
//    	new BearDaoImpl().queryDemo();
    	System.out.println(new BearDaoImpl().getBearById(55).getBearColor());
    	System.out.println("One");
    	new BearDaoImpl().getBearById(55);
    }
    
    
  
}
