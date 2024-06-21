package com.datefilm.datefilm_server.repository.reply;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import static com.datefilm.datefilm_server.model.user.QUser.user;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ReplyRepositoryCustomImpl implements ReplyRepositoryCustom {

    private final JPAQueryFactory queryFactory;


}