package self.Basics.NestedClass;
interface   AnonymousClass{
    void a();
}
public class AnonymousClassCode {

    public static void main(String[] args) {
        AnonymousClass obj=new AnonymousClass(){
            public void a(){
                System.out.println(" AnonymousClass");
            }
        };
        obj.a();
    }
}
