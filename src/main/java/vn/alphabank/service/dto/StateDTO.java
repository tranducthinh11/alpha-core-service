package vn.alphabank.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;

public class StateDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<GrantFunctionDTO> functions;

    public List<GrantFunctionDTO> getFunctions() {
        return functions;
    }

    public void setFunctions(List<GrantFunctionDTO> functions) {
        this.functions = functions;
    }
}
