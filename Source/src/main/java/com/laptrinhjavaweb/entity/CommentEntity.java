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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ChapterEntity getChapter() {
        return chapter;
    }

    public void setChapter(ChapterEntity chapter) {
        this.chapter = chapter;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
