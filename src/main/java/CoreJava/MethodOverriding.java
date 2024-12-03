package CoreJava;
class ParentClass{
    void parentMethod(){
        System.out.println("Parent Method");
    }
}
class ChildClass extends ParentClass{
    void parentMethod(){
        System.out.println("Child Method");
    }
    void childMethod(){
        System.out.println("Child method");
    }
}
public class MethodOverriding {
    public static void main(String[] args) {
    //upcasting
    ParentClass obj=new ChildClass();
    obj.parentMethod();
    //downcasting
    if(obj instanceof  ChildClass) {
        ChildClass obj1 = (ChildClass) obj;
        obj1.parentMethod();
        obj1.childMethod();
    }



    }
}
