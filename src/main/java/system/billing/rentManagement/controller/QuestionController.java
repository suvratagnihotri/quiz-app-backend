package system.billing.rentManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import system.billing.rentManagement.model.Question;
import system.billing.rentManagement.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    
    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Question>> getQuestionById(@PathVariable Integer id){
        return questionService.getQuestionById(id);
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @GetMapping("/getByLevel/{difficultyLevel}")
    public ResponseEntity<List<Question>> getQuestionByDifficultyLevel(@PathVariable String difficultyLevel){
         return questionService.getQuestionByDifficultyLevel(difficultyLevel.trim());
    }
}
