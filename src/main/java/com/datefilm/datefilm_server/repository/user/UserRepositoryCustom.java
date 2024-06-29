package com.datefilm.datefilm_server.repository.user;

public interface UserRepositoryCustom {

    int getLastTagForSameNickname(String nickname);

}
