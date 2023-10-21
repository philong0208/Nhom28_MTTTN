package com.laptrinhjavaweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity {
    @Column()
    private String content;
    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private ChapterEntity chapter;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
