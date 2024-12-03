package self.Basics.NestedClass;

public class StaticClassCode {
    static class staticClass{
        static void staticMethod(){
            System.out.println("Static class");
        }
    }
    public static void main(String[] args) {
        StaticClassCode obj=new StaticClassCode();
        StaticClassCode.staticClass.staticMethod();

    }
}
