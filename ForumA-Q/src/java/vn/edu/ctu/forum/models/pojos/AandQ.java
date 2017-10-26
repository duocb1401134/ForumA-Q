/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.pojos;

/**
 *
 * @author PC
 */
public class AandQ {
    private String anwser_id;
    private String question_id;

    public AandQ(String anwser_id, String question_id) {
        this.anwser_id = anwser_id;
        this.question_id = question_id;
    }

    public String getAnwser_id() {
        return anwser_id;
    }

    public String getQuestion_id() {
        return question_id;
    }
    
    
}
