package Activities;

public class CustomException extends Exception{

    private String message = null;

    public String getMessage() {
        return message;
    }

    public CustomException(String message) {
        this.message = message;
    }

}
