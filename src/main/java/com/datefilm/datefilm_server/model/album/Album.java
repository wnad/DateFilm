package com.datefilm.datefilm_server.model.album;

import com.datefilm.datefilm_server.model.BaseEntity;
import com.datefilm.datefilm_server.model.user.Couple;
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
@Table(name = "album")
public class Album extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment(value = "소유 회원")
    @JoinColumn(name="own_user_id",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User ownUser;

    @Comment(value = "소유 커플")
    @JoinColumn(name="couple_id",nullable = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Couple couple;

    @Comment(value = "공유 회원")
    @JoinColumn(name="shared_user_id",nullable = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User sharedUser;

    @Comment(value = "커플 공유 여부")
    @Column(name="share_status", nullable = false)
    private Boolean shareStatus;

    @Comment(value = "앨범명")
    @Column(name="title", nullable = false)
    private String title;

    @Comment(value = "대표이모티콘")
    @Column(name="emoji", nullable = true)
    private String emoji;

}
