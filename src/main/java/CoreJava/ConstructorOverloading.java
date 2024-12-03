package CoreJava;
public class ConstructorOverloading {
    public ConstructorOverloading(int a){
//        this(10,20);
        System.out.println(a);
    }
    public ConstructorOverloading(int a,int b){
        System.out.println(a+b);
    }
    public static void main(String[] args) {
        ConstructorOverloading obj=new ConstructorOverloading(10);
        ConstructorOverloading obj1=new ConstructorOverloading(10,20);

    }
}
