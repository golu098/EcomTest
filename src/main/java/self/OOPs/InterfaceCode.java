package self.OOPs;

interface Parent1 {
    void interfaceMethod();
}

class Child12 implements Parent1 {
    public void interfaceMethod() {
        System.out.println("interface method");
    }
}

public class InterfaceCode {  // The class name should match the file name
    public static void main(String[] args) {
        Child12 obj = new Child12();
        obj.interfaceMethod();
    }
}
