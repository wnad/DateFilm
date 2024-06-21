package com.datefilm.datefilm_server.model.base;

import com.datefilm.datefilm_server.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    //TODO: on delete set null
    @JsonIgnore
    @Comment("최초 생성자 user id")
    @JoinColumn(name="first_created_user_id",nullable = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @CreatedBy
    private User createdBy;

    //TODO: on delete set null
    @JsonIgnore
    @Comment("최종 수정자 user id")
    @JoinColumn(name="last_modified_user_id",nullable = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @LastModifiedBy
    private User lastModifiedBy;

    @Comment("최초 생성 시간")
    @Column(name = "created_at",nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Comment("최근 수정 시간")
    @Column(name = "updated_at",nullable = false)
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
