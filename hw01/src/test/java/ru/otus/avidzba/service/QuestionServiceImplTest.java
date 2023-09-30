package ru.otus.avidzba.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.avidzba.dao.QuestionDao;
import ru.otus.avidzba.dao.QuestionDaoImpl;
import ru.otus.avidzba.model.Question;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.when;

class QuestionServiceImplTest {
    private final QuestionDao questionDao = Mockito.mock(QuestionDaoImpl.class);
    private final QuestionServiceImpl questionService = new QuestionServiceImpl(questionDao);

    @Test
    void findAll_whenInvoke_returnAllQuestions() {
        when(questionDao.findAll()).thenReturn(List.of(new Question(1, "question1"), new Question(1, "question2")));
        assertThat(questionService.findAll().size(), equalTo(2));
        assertThat(questionService.findAll().get(0).getQuestion(), equalTo("question1"));
        assertThat(questionService.findAll().get(1).getQuestion(), equalTo("question2"));
    }
}