package system.billing.rentManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import system.billing.rentManagement.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer>{
    List<Question> findByDifficultyLevel(String difficultyLevel);
}
