package system.billing.rentManagement.model;

public class QuizData {
    private String name;
    private Integer questionCount;
    private String dificultyLevel;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getQuestionCount() {
        return questionCount;
    }
    public void setQuestionCount(Integer questionCount) {
        this.questionCount = questionCount;
    }
    public String getDificultyLevel() {
        return dificultyLevel;
    }
    public void setDificultyLevel(String dificultyLevel) {
        this.dificultyLevel = dificultyLevel;
    }
}
