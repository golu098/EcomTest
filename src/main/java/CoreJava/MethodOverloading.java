package CoreJava;
public class MethodOverloading {
    void method(int a){
        System.out.println(a);
    }
    void method(int a,int b){
        System.out.println(a+b);
    }
    public static void main(String[] args) {
        MethodOverloading obj=new MethodOverloading();
        obj.method(10);
        obj.method(10,20);
    }
}
