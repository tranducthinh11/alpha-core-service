package vn.alphabank.web.controller;

import org.apache.logging.log4j.util.Strings;
import vn.alphabank.response.BaseResponse;

import java.util.Objects;

import static vn.alphabank.response.BaseResponse.*;

public class BaseException extends Throwable {
    protected BaseResponse<?> responseException;

    protected BaseException() {
    }

    protected BaseException(String message, Throwable ta) {
        super(message);
        if(Objects.nonNull(ta))
            this.addSuppressed(ta);
        responseException = new BaseResponse<>();
    }

    public static BaseException setGenericError(String message) {
        return setGenericError(message, null);
    }

    public static BaseException setGenericError(Throwable ta) {
        return setGenericError("", ta);
    }

    public static BaseException setGenericError(String message, Throwable ta) {
        String msg = Strings.isBlank(message) ? GENERIC_ERROR_NOTES : message;
        BaseException be = new BaseException(msg, ta);
        be.responseException.setErrorCode(GENERIC_ERROR);
        be.responseException.setDescription(msg);
        be.responseException.setData(null);
        return be;
    }

    public static BaseException setErrorDataNotFound() {
        return setErrorDataNotFound(null);
    }

    public static BaseException setErrorDataNotFound(Throwable ta) {
        BaseException be = new BaseException(DATA_NOT_FOUND_NOTES, ta);
        be.responseException.setErrorCode(DATA_NOT_FOUND);
        be.responseException.setDescription(DATA_NOT_FOUND_NOTES);
        be.responseException.setData(null);
        return be;
    }

    public static BaseException setErrorInvalidBackendRule(String errorDescription) {
        return setErrorInvalidBackendRule(errorDescription, null);
    }

    public static BaseException setErrorInvalidBackendRule(String errorDescription, Throwable ta) {
        BaseException be = new BaseException(INVALID_BACKEND_RULE_NOTES + ": " + errorDescription, ta);
        be.responseException.setErrorCode(INVALID_BACKEND_RULE);
        be.responseException.setDescription(INVALID_BACKEND_RULE_NOTES + ": " + errorDescription);
        be.responseException.setData(null);
        return be;
    }

    public static BaseException setErrorBackendTimeout() {
        return setErrorBackendTimeout(null);
    }

    public static BaseException setErrorBackendTimeout(Throwable ta) {
        BaseException be = new BaseException(BACKEND_TIMEOUT_NOTES, ta);
        be.responseException.setErrorCode(BACKEND_TIMEOUT);
        be.responseException.setDescription(BACKEND_TIMEOUT_NOTES);
        be.responseException.setData(null);
        return be;
    }

    public static BaseException setErrorInvalidCustomer() {
        return setErrorInvalidCustomer(null);
    }

    public static BaseException setErrorInvalidCustomer(Throwable ta) {
        BaseException be = new BaseException(INVALID_BACKEND_RULE_NOTES, ta);
        be.responseException.setErrorCode(INVALID_CUSTOMER);
        be.responseException.setDescription(INVALID_BACKEND_RULE_NOTES);
        be.responseException.setData(null);
        return be;
    }

    public static BaseException setErrorCanceledCustomerStatus() {
        return setErrorCanceledCustomerStatus(null);
    }

    public static BaseException setErrorCanceledCustomerStatus(Throwable ta) {
        BaseException be = new BaseException(CANCELED_CUSTOMER_STATUS_NOTES, ta);
        be.responseException.setErrorCode(CANCELED_CUSTOMER_STATUS);
        be.responseException.setDescription(CANCELED_CUSTOMER_STATUS_NOTES);
        be.responseException.setData(null);
        return be;
    }

    public static BaseException setErrorBlockCustomerStatus() {
        return setErrorBlockCustomerStatus(null);
    }

    public static BaseException setErrorBlockCustomerStatus(Throwable ta) {
        BaseException be = new BaseException(BLOCKED_CUSTOMER_STATUS_NOTES, ta);
        be.responseException.setErrorCode(BLOCKED_CUSTOMER_STATUS);
        be.responseException.setDescription(BLOCKED_CUSTOMER_STATUS_NOTES);
        be.responseException.setData(null);
        return be;
    }

    public BaseResponse<?> getResponseException() {
        return this.responseException;
    }
}
