package self.Basics;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface customAnotation{
    String name();
    int age()default 10;

}

public class CustomAnnotation {
    @customAnotation(name="Shiv",age=1)
    public void a(){
        System.out.println("hi");
    }
    public static void main(String[] args) {
    CustomAnnotation obj=new CustomAnnotation();
    try {
        java.lang.reflect.Method method=obj.getClass().getMethod("a");
        if(method.isAnnotationPresent(customAnotation.class)){
            customAnotation obj1=method.getAnnotation(customAnotation.class);
            System.out.println(obj1.age());
        }
    }
    catch (NoSuchMethodException e){
        e.printStackTrace();
    }
    }
}
