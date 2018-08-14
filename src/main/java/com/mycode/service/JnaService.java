package com.mycode.service;

import java.util.ArrayList;
import java.util.List;

import com.sun.jna.Library;
import com.sun.jna.Structure;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;

public interface JnaService extends Library {
	public static class myStructur extends Structure {
		public static class ByReference extends myStructur implements Structure.ByReference {
		}

		public static class ByValue extends myStructur implements Structure.ByValue {
		}
		
		public int a;
		public int b;
		
        @Override  
        protected List<String> getFieldOrder() {  
            List<String> Field = new ArrayList<String>();  
            Field.add("a");  
            Field.add("b");  
  
            return Field;  
        }  
	}
	
	public static class myAdvance extends Structure{
		public static class ByReference extends myAdvance implements Structure.ByReference{
			
		}
		
		public static class ByValue extends myAdvance implements Structure.ByValue{
			
		}
		public IntByReference  len;
        @Override  
        protected List<String> getFieldOrder() {  
            List<String> Field = new ArrayList<String>();  
            Field.add("len");   
  
            return Field;  
        }  
	}
	
	
	int add(int num1, int num2);
	int addNormal(myStructur.ByValue ms);
	void addPrt(myStructur.ByReference pms,IntByReference sum);  
	int addRef(myStructur.ByReference rms); 
	int copyStr();
	int program(byte[] arr);
}
