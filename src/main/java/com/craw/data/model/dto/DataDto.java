package com.craw.data.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class DataDto {
    private boolean isSuccess;
    private int status;
    private String message;
}
