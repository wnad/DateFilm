package com.datefilm.datefilm_server.config;

import com.datefilm.datefilm_server.model.album.QAlbum;
import com.datefilm.datefilm_server.model.notification.QNotification;
import com.datefilm.datefilm_server.model.record.QRecord;
import com.datefilm.datefilm_server.model.reply.QReply;
import com.datefilm.datefilm_server.model.user.QCouple;
import com.datefilm.datefilm_server.model.user.QUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class QuerydslConfig {

    static{
        QUser user = QUser.user;
        QCouple couple = QCouple.couple;
        QRecord record = QRecord.record;
        QReply reply = QReply.reply;
        QNotification notification = QNotification.notification;
        QAlbum album = QAlbum.album;

//        log.info("[QuerydslConfig] qtype 초기화 완료");
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }

}