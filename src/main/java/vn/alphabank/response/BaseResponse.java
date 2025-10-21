package vn.alphabank.response;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String CODE_SUCCESS = "00";
    public static final String DATA_NOT_FOUND = "01";
    public static final String BLOCKED_CUSTOMER_STATUS = "11";
    public static final String CANCELED_CUSTOMER_STATUS = "12";
    public static final String INVALID_CUSTOMER = "19";
    public static final String INVALID_BACKEND_RULE = "80";
    public static final String BACKEND_TIMEOUT = "90";
    public static final String GENERIC_ERROR = "99";

    public static final String DATA_NOT_FOUND_NOTES = "Data not found";
    public static final String GENERIC_ERROR_NOTES = "General error";
    public static final String INVALID_BACKEND_RULE_NOTES = "Invalid backend rule";
    public static final String BACKEND_TIMEOUT_NOTES = "Backend Timeout";
    public static final String CANCELED_CUSTOMER_STATUS_NOTES = "Canceled customer status";
    public static final String BLOCKED_CUSTOMER_STATUS_NOTES = "Blocked customer status";

    private String errorCode = "00";
    private String description = "success";

    private T data;

    public BaseResponse() {
        // TODO Auto-generated constructor stub
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
