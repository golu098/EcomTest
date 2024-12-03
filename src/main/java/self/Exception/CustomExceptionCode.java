package self.Exception;

class customException extends  RuntimeException{
    public customException(String message){
        super(message);
    }
}

public class CustomExceptionCode {
    public static void main(String[] args) {
        int age=19;
        try{
            if(age>18){
                System.out.println("not legal age");
                throw new customException("Not legal age");
            }
        }
        catch (customException e){
            e.printStackTrace();
        }
    }
}
