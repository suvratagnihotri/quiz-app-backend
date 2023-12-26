package system.billing.rentManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import system.billing.rentManagement.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer>{
    
}
