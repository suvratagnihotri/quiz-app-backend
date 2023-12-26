package system.billing.rentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import system.billing.rentManagement.model.Quiz;
import system.billing.rentManagement.model.QuizData;
import system.billing.rentManagement.model.QuizEvaluation;
import system.billing.rentManagement.service.QuizService;

@CrossOrigin
@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<Quiz> createQuiz(@RequestBody QuizData quizData){
        return quizService.createQuiz(quizData);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuiz(){
        return quizService.getAllQuiz();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Quiz>> getQuizByID(@PathVariable Integer id){
        return quizService.getQuizById(id);
    }

    @PostMapping("/evaluate")
    public ResponseEntity<QuizEvaluation> getTotalScore(@RequestBody Quiz quiz){
        return quizService.getTotalScore(quiz);
    }
}
