package com.datefilm.datefilm_server.repository.album;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class AlbumRepositoryCustomImpl implements AlbumRepositoryCustom {

    private final JPAQueryFactory queryFactory;


}