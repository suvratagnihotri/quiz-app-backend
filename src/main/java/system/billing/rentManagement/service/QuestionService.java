package system.billing.rentManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.micrometer.core.ipc.http.HttpSender.Response;
import system.billing.rentManagement.dao.QuestionDao;
import system.billing.rentManagement.model.Question;

@Service
public class QuestionService {
    @Autowired 
    QuestionDao questionDao;

    public String addQuestion(Question question){
        questionDao.save(question);
        return "success";
    }

    public ResponseEntity<List<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<Optional<Question>> getQuestionById(Integer id) {
        return new ResponseEntity<>(questionDao.findById(id),HttpStatus.OK);
    }

    public ResponseEntity<List<Question>> getQuestionByDifficultyLevel(String difficultyLevel) {
        return new ResponseEntity<>(questionDao.findByDifficultyLevel(difficultyLevel),HttpStatus.OK);
    }
}
