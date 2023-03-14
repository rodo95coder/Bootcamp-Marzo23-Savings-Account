package com.bootcamp.savingsaccount.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GlobalResponse {
    private Object data;
    private Object message;
}
