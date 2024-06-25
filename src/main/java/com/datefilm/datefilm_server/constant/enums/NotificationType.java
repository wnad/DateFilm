package com.datefilm.datefilm_server.constant.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum NotificationType implements Constant<NotificationType>{

    RECORD("기록"), REPLY("댓글");
    private final String label;

    @JsonValue
    @Override
    public String getLabel() {
        return null;
    }

    @JsonCreator
    @Override
    public NotificationType findByLabel(String label) {
        return Arrays.stream(values())
                .filter(value->value.label.equals(label))
                .findAny()
                .orElse(null);
    }
}
