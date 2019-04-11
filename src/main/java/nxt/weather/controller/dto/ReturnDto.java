package nxt.weather.controller.dto;

public class ReturnDto<E> {
    
    private int code;
    private String message;
    private E resultat;
    
    public ReturnDto(E result) {
        this(200, "Success", result);
    }
    
    public ReturnDto(int code, String message) {
        this(code, message, null);
    }
    
    public ReturnDto(int code, String message, E result) {
        this.code = code;
        this.message = message;
        this.resultat = result;
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

    public E getResultat() {
        return resultat;
    }

    public void setResultat(E result) {
        this.resultat = result;
    }
    
}
