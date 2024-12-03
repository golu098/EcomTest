package self.Basics;



class Parent {
    public void parent(){
        System.out.println("Parent Method");
    }
}
class Child extends Parent{
    public void parent(){
        System.out.println("Child method");
    }
}
public class UpcastingDownCasting {
    public static void main(String[] args) {
        System.out.println("upcasting:- subclass object && superclass ref");
        Parent subClassObject1=new Child();
        subClassObject1.parent();

        System.out.println("downcasting :- superclass ref back to its subclass");
        if(subClassObject1 instanceof Child) {
            Child obj1 = (Child) subClassObject1;
            obj1.parent();
        }
    }


}
