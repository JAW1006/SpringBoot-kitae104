package com.mysite.sbb.answer.entity;

import com.mysite.sbb.question.entity.Question;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity


public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "Text")
    private String content;

    private LocalDateTime created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
}
