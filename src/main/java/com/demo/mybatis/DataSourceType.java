package com.demo.mybatis;

import lombok.Getter;

/**
 * Created by huguoju on 2016/12/29.
 */
public enum DataSourceType {
    read("read", "从库"),
    write("write", "主库");
    @Getter
    private String type;
    @Getter
    private String name;

    DataSourceType(String type, String name) {
        this.type = type;
        this.name = name;
    }
}
