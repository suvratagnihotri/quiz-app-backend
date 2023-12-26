package system.billing.rentManagement.model;

public class QuizEvaluation {
    private Integer totalScore;
    private Integer scored;
    private String title;
    public QuizEvaluation(Integer totalScore, Integer scored, String title) {
        this.totalScore = totalScore;
        this.scored = scored;
        this.title = title;
    }
    public Integer getTotalScore() {
        return totalScore;
    }
    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }
    public Integer getScored() {
        return scored;
    }
    public void setScored(Integer scored) {
        this.scored = scored;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
