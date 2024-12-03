package self.Lambda;

import java.util.HashMap;

interface classInterface{
    void classMethod();
}
public class MethodReferenceCode {
    public static void staticMethod(){
        System.out.println("Static method");
    }
    public void instanceMethod(){
        System.out.println("Instance method");
    }
    public MethodReferenceCode(){
        System.out.println("Constrcutor");
    }
    public static void main(String[] args) {
        classInterface staticMethodRef=MethodReferenceCode::staticMethod;
        staticMethodRef.classMethod();
        MethodReferenceCode obj=new MethodReferenceCode();
        classInterface instanceRef=obj::instanceMethod;
        instanceRef.classMethod();

        classInterface constructorRef=MethodReferenceCode::new;
        constructorRef.classMethod();


    }
}
