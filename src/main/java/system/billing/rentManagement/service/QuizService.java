package system.billing.rentManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import system.billing.rentManagement.dao.QuestionDao;
import system.billing.rentManagement.dao.QuizDao;
import system.billing.rentManagement.model.Question;
import system.billing.rentManagement.model.Quiz;
import system.billing.rentManagement.model.QuizData;
import system.billing.rentManagement.model.QuizEvaluation;

import java.util.List;


@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired 
    QuestionDao questionDao;

    public ResponseEntity<Quiz> createQuiz(QuizData quizData) {
        List<Question> questionFromDb = questionDao.findByDifficultyLevel(quizData.getDificultyLevel().trim());
        Quiz quiz = new Quiz();
        quiz.setQuestions(questionFromDb);
        quiz.setTitle(quizData.getName());
        quizDao.save(quiz);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<List<Quiz>> getAllQuiz() {
        return new ResponseEntity<>(quizDao.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<Optional<Quiz>> getQuizById(Integer id) {
        return new ResponseEntity<>(quizDao.findById(id),HttpStatus.OK);
    }

    public ResponseEntity<QuizEvaluation> getTotalScore(Quiz quizToEvaluate) {
        Optional<Quiz> quiz = quizDao.findById(quizToEvaluate.getId());
        List<Question> questions = quiz.get().getQuestions();
        List<Question> questionToEvaluate = quizToEvaluate.getQuestions();
        Integer totalScore = questions.size();
        Integer scored = 0;
        for (int i = 0; i < questions.size(); i++) {
            if(questions.get(i).getRightAnswer().trim().equals(questionToEvaluate.get(i).getRightAnswer().trim())){
                scored++;
            }
        }
        return new ResponseEntity<>(new QuizEvaluation(totalScore, scored, quizToEvaluate.getTitle()),HttpStatus.OK);
    }
    
}
