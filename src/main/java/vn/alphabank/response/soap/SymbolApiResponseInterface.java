package vn.alphabank.response.soap;

import lombok.SneakyThrows;
import vn.alphabank.web.controller.BaseException;

import java.util.Objects;

public interface SymbolApiResponseInterface {
    public String getResponse_code();
    public String getDescription();
    public final String SuccessCode = "00";
    public final String ErrorCode01 = "01";
    public final String ErrorCode02 = "02";
    public final String ErrorCode03 = "03";
    public final String ErrorCode09 = "09";


    @SneakyThrows
    default BaseException checkError(boolean throwError){
        BaseException be = null;

        switch (getResponse_code()){
            case SuccessCode:
                break;
            case ErrorCode01:
                be = BaseException.setErrorDataNotFound();
                break;
            case ErrorCode09:
                be = BaseException.setErrorInvalidBackendRule(getDescription());
                break;
            default:
                be = BaseException.setGenericError("");
        }

        if(throwError && Objects.nonNull(be))
            throw be;
        return be;
    }
}
