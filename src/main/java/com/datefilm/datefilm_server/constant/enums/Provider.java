package com.datefilm.datefilm_server.constant.enums;

public enum Provider implements Constant<NotificationType>{

    EMAIL("이메일"), KAKAO("카카오"), NAVER("네이버"), APPLE("애플"), GOOGLE("구글");
    private final String label;

    Provider(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public NotificationType findByLabel(String label) {
        return null;
    }
}
