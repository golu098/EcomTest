package CoreJava;

class Parent {
    int a;
    public Parent(){
        System.out.println("Default constructor");
    }
    public Parent(int a){
        this();
        this.a=a;
        System.out.println("Paramterized constructor of parent "+a);
    }
}
class Child extends Parent{
    public Child(){
        this(100);
    }
    public Child(int a){
//        this();// we can not use this and super
        super(a);
        System.out.println("child constructor "+a);
    }
}
public class ConstructorChaining  {

    public static void main(String[] args) {
Child obj=new Child();
    }
}
