package com.datefilm.datefilm_server.model.reply;

import com.datefilm.datefilm_server.model.album.Album;
import com.datefilm.datefilm_server.model.BaseEntity;
import com.datefilm.datefilm_server.model.record.Record;
import com.datefilm.datefilm_server.model.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reply")
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment(value = "소속 앨범")
    @JoinColumn(name="album_id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Album album;

    @Comment(value = "소속 기록")
    @JoinColumn(name="record_id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Record record;

    @Comment(value = "발신 회원")
    @JoinColumn(name="user_id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User sender;

    @Comment(value = "내용")
    @Column(name="context", nullable = false)
    private String context;

}
