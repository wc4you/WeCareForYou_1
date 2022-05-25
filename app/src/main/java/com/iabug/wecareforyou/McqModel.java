package com.iabug.wecareforyou;

public class McqModel {

    private String Qid;
    private String questions;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;
    private String Option5;
    private String answers;



    public McqModel(String qid, String questions, String option1, String option2, String option3, String option4, String option5, String answers) {
        Qid = qid;
        this.questions = questions;
        Option1 = option1;
        Option2 = option2;
        Option3 = option3;
        Option4 = option4;
        Option5 = option5;
        this.answers = answers;
    }


    public McqModel(String optionA, String optionB, String optionC, String optionD, String optionE, String questionlist) {
    }

    public String getQid() {
        return Qid;
    }

    public void setQid(String qid) {
        Qid = qid;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getOption1() {
        return Option1;
    }

    public void setOption1(String option1) {
        Option1 = option1;
    }

    public String getOption2() {
        return Option2;
    }

    public void setOption2(String option2) {
        Option2 = option2;
    }

    public String getOption3() {
        return Option3;
    }

    public void setOption3(String option3) {
        Option3 = option3;
    }

    public String getOption4() {
        return Option4;
    }

    public void setOption4(String option4) {
        Option4 = option4;
    }

    public String getOption5() {
        return Option5;
    }
    public void setOption5(String option5) {
        Option5 = option5;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }
}
