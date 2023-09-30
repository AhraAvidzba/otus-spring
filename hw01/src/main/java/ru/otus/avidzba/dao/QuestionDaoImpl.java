package ru.otus.avidzba.dao;

import lombok.RequiredArgsConstructor;
import ru.otus.avidzba.model.Question;
import ru.otus.avidzba.util.StudentTestResources;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class QuestionDaoImpl implements QuestionDao {
    private final String fileName;

    @Override
    public List<Question> findAll() {
        List<String> lines = StudentTestResources.getFileFromResourceAsList(fileName);
        List<Question> questions = new ArrayList<>();
        for (String line : lines) {
            String[] data = line.split(",");
            if (data[0].equals("id")) {
                continue;
            }
            Question question = new Question(Integer.parseInt(data[0]), data[1]);
            questions.add(question);
        }
        return questions;
    }
}
