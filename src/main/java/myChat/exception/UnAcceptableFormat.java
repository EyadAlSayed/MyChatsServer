package myChat.exception;

public class UnAcceptableFormat extends Exception{

    private final String EXCEPTION_MESSAGE = "The format can't be handling";
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.out.println(EXCEPTION_MESSAGE);
    }
}
