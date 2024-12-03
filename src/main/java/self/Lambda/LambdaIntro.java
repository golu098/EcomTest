package self.Lambda;
@FunctionalInterface
//interface Name1{
//    void displayName();
//}
//interface Name1{
//    void displayName(int a);
//}

interface Name1{
    void displayName(int a,int b);
}

public class LambdaIntro {
    public static void main(String[] args) {
//        Name1 obj=()-> System.out.println("hi");
//        obj.displayName()''

//        Name1 obj=(int a)-> System.out.println(a);
//        obj.displayName(10);
        Name1 obj=(a,b)-> System.out.println(a+b);
        obj.displayName(10,20);
    }
}
