package com.iabug.wecareforyou;

public class ModelClass {
    String Question;
    String Choice1;
    String Choice2;
    String Choice3;
    String Choice4;
    String Choice5;

    public ModelClass(){}

    public ModelClass(String question, String choice1, String choice2, String choice3, String choice4, String choice5) {
        Question = question;
        Choice1 = choice1;
        Choice2 = choice2;
        Choice3 = choice3;
        Choice4 = choice4;
        Choice5 = choice5;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getChoice1() {
        return Choice1;
    }

    public void setChoice1(String choice1) {
        Choice1 = choice1;
    }

    public String getChoice2() {
        return Choice2;
    }

    public void setChoice2(String choice2) {
        Choice2 = choice2;
    }

    public String getChoice3() {
        return Choice3;
    }

    public void setChoice3(String choice3) {
        Choice3 = choice3;
    }

    public String getChoice4() {
        return Choice4;
    }

    public void setChoice4(String choice4) {
        Choice4 = choice4;
    }

    public String getChoice5() {
        return Choice5;
    }

    public void setChoice5(String choice5) {
        Choice5 = choice5;
    }
}
