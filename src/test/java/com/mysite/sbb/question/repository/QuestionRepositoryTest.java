package com.mysite.sbb.question.repository;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.mysite.sbb.question.entity.Question;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void test(){
        System.out.println("테스트 확인중...");
    }

//    @Test
//    @Transactional
    void testSave(){
        Question q1 = new Question();
        q1.setSubject("SBB가 뭔가요?");
        q1.setContent("sbb에 대해서 알고 싶어요");
        Question saved = questionRepository.save(q1);
        assertEquals(1, saved.getId());

        Question q2 = Question.builder()    // 빌더를 활용해서 하면 순서를 맞추지 않아도 상관 없음
                .content("스프링은 왜 어렵다고 하는거죠?")
                .subject("스프링 부트도 어려운가요?")
                .build();
        Question saved2 = questionRepository.save(q2);
        assertEquals(2, saved2.getId());
    }

    @Test
    void testFindAll(){
        List<Question> questionList = questionRepository.findAll(); // shift + alt + l
        assertEquals(2, questionList.size());
        Question question = questionList.get(0);
        assertEquals("SBB가 뭔가요?", question.getSubject());
    }

    @Test
    void testFindById(){
        Optional<Question> byId = questionRepository.findById(1L); // Optional : NULL 값 가져오는걸 방지하기 위해 사용
        if (byId.isPresent()){
            Question question = byId.get();
            assertEquals(1, question.getId());
        }

        Question question = questionRepository.findById(1L)
                .orElseThrow(() -> new EntityNotFoundException("해당 객체가 없습니다")); // 해당 객체가 있는지 파악하기 위해 활용가능
        assertEquals(1, question.getId());
    }
}