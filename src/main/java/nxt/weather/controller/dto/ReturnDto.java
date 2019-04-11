package nxt.weather.controller.dto;

public class ReturnDto<E> {
    
    private int code;
    private String message;
    private E result;
    
    public ReturnDto(E result) {
        this(200, "Success", result);
    }
    
    public ReturnDto(int code, String message, E result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getResult() {
        return result;
    }

    public void setResult(E result) {
        this.result = result;
    }
    
}
