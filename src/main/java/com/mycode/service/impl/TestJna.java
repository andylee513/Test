package com.mycode.service.impl;


import com.mycode.service.JnaService;
import com.sun.jna.Native;
import com.sun.jna.ptr.ByReference;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;


public class TestJna {


	public static void main(String[] args) {
		JnaService service = (JnaService) Native.loadLibrary("E:/vs2012_pro/jna/CreateDll/x64/Debug/CreateDll.dll",
				JnaService.class);
		System.out.println("=======基本值传递==========");
		int result = service.add(3, 5);
		System.out.println(result);
		
		
		System.out.println("=======结构体值传递==========");
		JnaService.myStructur.ByValue vmysStructur = new JnaService.myStructur.ByValue();
		vmysStructur.a = 1;  
        vmysStructur.b = 3;  
        System.out.println(service.addNormal(vmysStructur));
        
        System.out.println("=======结构体指针传递==========");
        JnaService.myStructur.ByReference pmysStructur = new JnaService.myStructur.ByReference();  
        pmysStructur.a = 1;  
        pmysStructur.b = 3;  
        IntByReference ib = new IntByReference();
        service.addPrt(pmysStructur, ib);
        System.out.println(ib.getValue());
        
        System.out.println("=======结构体引用传递==========");
        System.out.println(service.addRef(pmysStructur)); 
        System.out.println(pmysStructur.a);
        
        System.out.println("=======高级用法==========");
        //JnaService.myAdvance.ByReference ma = new JnaService.myAdvance.ByReference();
       
        int result1 = service.copyStr();
        System.out.println(result1);
        //ByteByReference bb = new ByteByReference();
        //service.program();
        byte[] arr = new byte[30] /*= new byte[30]*/;
        service.program(arr);
        System.out.println(new String(arr));
       
        
	}
}
