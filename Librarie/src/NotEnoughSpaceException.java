public class NotEnoughSpaceException extends Exception{
    NotEnoughSpaceException(String errorMsg){
        super(errorMsg);
    }
}