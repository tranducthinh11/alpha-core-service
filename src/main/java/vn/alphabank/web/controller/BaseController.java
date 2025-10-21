package vn.alphabank.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import vn.alphabank.response.BaseResponse;

import java.util.*;
import java.util.concurrent.Callable;

@RestController
public class BaseController {
    protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected ResponseEntity<?> getResponse(Callable<ResponseEntity<?>> fn) {
        try {
            ResponseEntity<?> call = fn.call();
            var response = (BaseResponse) call.getBody();

            if(Objects.isNull(response.getData()) && Objects.equals(response.getErrorCode(), BaseResponse.CODE_SUCCESS)){
                throw BaseException.setErrorDataNotFound();
            }

            return call;
        } catch (Throwable ta) {
            BaseException be = (ta instanceof BaseException) ? (BaseException) ta : BaseException.setGenericError(ta);
            return ResponseEntity.ok().body(be.getResponseException());
        }
    }
}