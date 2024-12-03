package self.Basics.NestedClass;

public class OuterClass {
    int outerVar=10;
    public class innerClass{
        public void innerMethod(){
            System.out.println("Inner method"+outerVar);
        }
    }

    public static void main(String[] args) {
        OuterClass obj=new OuterClass();
        OuterClass.innerClass obj1=obj.new innerClass();
        obj1.innerMethod();

    }
}
