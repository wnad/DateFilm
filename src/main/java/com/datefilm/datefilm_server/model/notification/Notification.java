package com.datefilm.datefilm_server.model.notification;

import com.datefilm.datefilm_server.model.BaseEntity;
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
@Table(name = "notification")
public class Notification extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment(value = "읽기 여부")
    @Column(name="read_status", nullable = false)
    private Boolean readStatus;

    @Comment(value = "알림 타입")
    @Column(name="type", nullable = false)
    private String type;

    @Comment(value = "알림 내용")
    @Column(name="context", nullable = true)
    private String context;


}
