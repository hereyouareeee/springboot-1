package com.demo.exception;

import lombok.Builder;
import lombok.Getter;

/**
 * Created by huguoju on 2017/4/13.
 */
@Builder
@Getter
public class RetryException extends RuntimeException {
    private String code;
    private String message;
}
