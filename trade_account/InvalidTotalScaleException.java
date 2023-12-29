package trade_account;

public class InvalidTotalScaleException extends Exception {
    public int currentScale;
    public static final int validScale = 2;
    InvalidTotalScaleException(String name, int scale){
        super(name);
        currentScale = scale;
    }
}
