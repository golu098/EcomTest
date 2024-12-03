//package self.OOPs;
//
//abstract class Parent {
//    private int a;
//    public  void concreteMethod() {
//        System.out.println("Concrete method"+a);
//    }
//
//    abstract void abstractMethod();
//    abstract void abstractMethod1();
//
//    Parent() {
//        this(10, 2);
//        System.out.println("1st constructor");
//    }
//
//    Parent(int a, int b) {
//        System.out.println(a + b);
//    }
//
//    static {
//        System.out.println("Static initialization block");
//    }
//
//    {
//        System.out.println("Instance initializers");
//    }
//}
//
//abstract class Child extends Parent {
//    Child() {
//        super(5, 3);
//        System.out.println("Child constructor");
//    }
//
//    @Override
//    public void abstractMethod() {
//        System.out.println("Abstract method implemented in Child");
//    }
//}
//
//class GrandChild extends Child {
//    @Override
//    public void abstractMethod1() {
//        System.out.println("Abstract method1 implemented in GrandChild");
//    }
//}
//
//public class AbstractionCode {
//    public static void main(String[] args) {
//        GrandChild obj = new GrandChild();
//        obj.abstractMethod();
//        obj.abstractMethod1();
//        obj.concreteMethod();
//    }
//}
