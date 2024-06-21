package com.datefilm.datefilm_server.repository.user;



public interface UserRepositoryCustom {


    // 동일 닉네임 유저 중 마지막 tag 검색
    int getLastTagForSameNickname(String nickname);

}