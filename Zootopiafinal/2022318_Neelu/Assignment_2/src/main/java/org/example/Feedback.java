package org.example;

import static org.example.zoo.feedback;

public class Feedback {
    private String feedbacks;

    public Feedback(String feedback) {
        this.feedbacks = feedback;
    }

    public String getFeedback() {
        return feedbacks;
    }
    void give_feedback(Feedback f){
        feedback.add(f);
    }
}
