package models.response;

public class ApiResponse {
    private int code;
    private String type;
    private String message;

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public int getCode() {
        return code;
    }
}
