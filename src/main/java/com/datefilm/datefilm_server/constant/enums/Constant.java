package com.datefilm.datefilm_server.constant.enums;

public interface Constant<T extends Enum> {
    String getLabel();

    T findByLabel(String label);
}
