package vn.alphabank.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class LinkPropsDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private StateDTO state;

    public StateDTO getState() {
        return state;
    }

    public void setState(StateDTO state) {
        this.state = state;
    }
}
