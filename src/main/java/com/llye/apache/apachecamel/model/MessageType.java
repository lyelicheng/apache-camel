package com.llye.apache.apachecamel.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum MessageType {
    JSON,
    XML,
    @JsonEnumDefaultValue UNKNOWN;
}
