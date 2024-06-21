package com.datefilm.datefilm_server.model.user;

import com.datefilm.datefilm_server.model.base.BaseEntity;
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
@Table(name = "couple")
public class Couple extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "couple_id")
    private Long id;

    @Comment(value = "커플 기념일")
    @Column(name="anniversary_date", nullable = false)
    private LocalDate anniversary_date;

}
