package com.datefilm.datefilm_server.model.record;

import com.datefilm.datefilm_server.model.album.Album;
import com.datefilm.datefilm_server.model.base.BaseEntity;
import com.datefilm.datefilm_server.model.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Record extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment(value = "소유 회원")
    @JoinColumn(name="user_id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User ownUser;

    @Comment(value = "소속 앨범")
    @JoinColumn(name="album_id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Album album;

    @Comment(value = "제목")
    @Column(name="title", nullable = false)
    private String title;

    @Comment(value = "위치")
    @Column(name="location", nullable = true)
    private String location;

    @Comment(value = "날짜")
    @Column(name="date", nullable = true)
    private LocalDate date;

    @Comment(value = "공유 상태")
    @Column(name="share_status", nullable = false)
    private Boolean shareStatus;

    @Comment(value = "기록")
    @Column(name="context", nullable = true)
    private String context;

    @Comment(value = "이미지01")
    @Column(name="img01", nullable = true)
    private String img01;

    @Comment(value = "이미지02")
    @Column(name="img02", nullable = true)
    private String img02;

    @Comment(value = "이미지03")
    @Column(name="img03", nullable = true)
    private String img03;

    @Comment(value = "이미지04")
    @Column(name="img04", nullable = true)
    private String img04;

    @Comment(value = "이미지05")
    @Column(name="img05", nullable = true)
    private String img05;

    @Comment(value = "이미지06")
    @Column(name="img06", nullable = true)
    private String img06;

    @Comment(value = "이미지07")
    @Column(name="img07", nullable = true)
    private String img07;

    @Comment(value = "이미지08")
    @Column(name="img08", nullable = true)
    private String img08;

    @Comment(value = "이미지09")
    @Column(name="img09", nullable = true)
    private String img09;

    @Comment(value = "이미지10")
    @Column(name="img10", nullable = true)
    private String img10;


}
