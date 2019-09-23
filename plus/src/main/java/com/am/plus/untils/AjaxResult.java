package com.am.plus.untils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@Component
public class AjaxResult {
    private String code;
    private String msg;
    private Boolean success;
    private String url;
}
