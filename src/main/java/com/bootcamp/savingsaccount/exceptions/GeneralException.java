package com.bootcamp.savingsaccount.exceptions;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GeneralException {
    private String message;
}
