package com.poly.util;

public class StackTraceUtil {

	
	  public static void getCaller()  
	    {  
	        StackTraceElement stack[] = (new Throwable()).getStackTrace();  
	        System.out.println("##############################################################debug begin");
	        for (int i = 0; i < stack.length; i++)  
	        {  
	            StackTraceElement s = stack[i];  
	            System.out.format(" ClassName:%d\t%s\n", i, s.getClassName());  
	            System.out.format("MethodName:%d\t%s\n", i, s.getMethodName());  
	            System.out.format("  FileName:%d\t%s\n", i, s.getFileName());  
	            System.out.format("LineNumber:%d\t%s\n\n", i, s.getLineNumber());  
	        }  
	        System.out.println("##############################################################debug end");
	    }
	  
	  public static void main(String[] args) {
		  getCaller();
		
	}
}
