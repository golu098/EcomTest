package self.Basics.NestedClass;

public class LocalClassCode {
void localMethod(){
    class localClass{
        void local(){
            System.out.println("hi");
        }
    }
    localClass obj=new localClass();
    obj.local();

}
    public static void main(String[] args) {
        LocalClassCode obj1=new LocalClassCode();
        obj1.localMethod();
    }
}
