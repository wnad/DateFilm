package com.datefilm.datefilm_server.repository.record;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RecordRepositoryCustomImpl implements RecordRepositoryCustom {

    private final JPAQueryFactory queryFactory;


}