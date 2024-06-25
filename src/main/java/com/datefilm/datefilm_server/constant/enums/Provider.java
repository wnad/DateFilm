package com.datefilm.datefilm_server.constant.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum Provider implements Constant<Provider> {
    EMAIL, KAKAO, NAVER, APPLE, GOOGLE;

    private final String label;

    @JsonValue
    @Override
    public String getLabel() {
        return null;
    }

    @JsonCreator
    @Override
    public Provider findByLabel(String label) {
        return Arrays.stream(values())
                .filter(value->value.label.equals(label))
                .findAny()
                .orElse(null);
    }
}