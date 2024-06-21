package com.datefilm.datefilm_server.repository.user;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import static com.datefilm.datefilm_server.model.user.QUser.user;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public int getLastTagForSameNickname(String nickname) {

        Integer lastTag = queryFactory
                .select(user.tag)
                .from(user)
                .where(eqNickname(nickname))
                .orderBy(user.tag.desc())
                .limit(1)
                .fetchOne();

        if (lastTag == null) {
            return 1;
        } else {
            return lastTag;
        }
    }

    public static BooleanExpression eqNickname(String nickname) {
        return nickname!=null ?  user.nickname.eq(nickname) : null;
    }
}