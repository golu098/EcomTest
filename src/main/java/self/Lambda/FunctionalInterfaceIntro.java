package self.Lambda;
@FunctionalInterface
interface Name{
    void displayName();

}
public class FunctionalInterfaceIntro {
    public static void main(String[] args) {

        Name obj=new Name(){
            public void displayName(){
                System.out.println("hi");
            }
        };
        obj.displayName();
    }
}
