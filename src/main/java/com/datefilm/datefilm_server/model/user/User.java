package com.datefilm.datefilm_server.model.user;

import com.datefilm.datefilm_server.constant.enums.Provider;
import com.datefilm.datefilm_server.model.album.Album;
import com.datefilm.datefilm_server.model.BaseEntity;
import com.datefilm.datefilm_server.model.record.Record;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;
import java.util.List;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment(value = "커플 id")
    @JoinColumn(name="couple_id",nullable = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Couple couple;

    @Comment(value = "파트너")
    @JoinColumn(name="user_id",nullable = true)
    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User partner;

    @Comment(value = "유저 이메일(로그인용/식별용)")
    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Comment(value = "유저 닉네임")
    @Column(name="nickname", nullable = false)
    private String nickname;

    @Comment(value = "유저 닉네임 태그")
    @Column(name="tag", nullable = false)
    private int tag;

    @Comment(value = "유저 성별")
    @Column(name="gender", nullable = false)
    private String gender;

    @Comment(value = "유저 생일")
    @Column(name="birthdate", nullable = false)
    private LocalDate birthdate;

    @Comment(value = "유저 프로필 이미지 링크")
    @Column(name="profile_img", nullable = false)
    private String profile_img;

    @Comment(value = "유저 가입 제공")
    @Enumerated(EnumType.STRING)
    @Column(name="provider", nullable = false)
    private Provider provider;

    @Comment(value = "새로운 기록 알림 설정")
    @Column(name="noti_record_status", nullable = false)
    private Boolean noti_record_status;

    @Comment(value = "새로운 댓글 알림 설정")
    @Column(name="noti_comment_status", nullable = false)
    private Boolean noti_comment_status;

    @ToString.Exclude
    @OneToMany(mappedBy = "ownUser", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Album> albumList;

    @ToString.Exclude
    @OneToMany(mappedBy = "ownUser", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Record> recordList;



}
