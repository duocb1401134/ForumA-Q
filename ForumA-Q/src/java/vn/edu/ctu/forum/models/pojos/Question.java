/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.pojos;

import java.util.Date;

/**
 *
 * @author Ew
 */
public class Question {
    private Integer questionId;
    private Subject subject;
    private String subjectId;
    private Member member;
    private Integer memberId;   
    private String questionName;
    private String questionDecription;
    private String questionContent;
    private Date questionDate;
    private boolean questionAccept;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionDecription() {
        return questionDecription;
    }

    public void setQuestionDecription(String questionDecription) {
        this.questionDecription = questionDecription;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Date getQuestionDate() {
        return questionDate;
    }

    public void setQuestionDate(Date questionDate) {
        this.questionDate = questionDate;
    }

    public boolean isQuestionAccept() {
        return questionAccept;
    }

    public void setQuestionAccept(boolean questionAccept) {
        this.questionAccept = questionAccept;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public Question(Integer questionId, String subjectId, String questionName, String questionDecription, String questionContent) {
        this.questionId = questionId;
        this.subjectId = subjectId;
        this.questionName = questionName;
        this.questionDecription = questionDecription;
        this.questionContent = questionContent;
    }
    
    

    public Question(Integer questionId, String subjectId, Integer memberId, String questionName, String questionDecription, String questionContent) {
        this.questionId = questionId;
        this.subjectId = subjectId;
        this.memberId = memberId;
        this.questionName = questionName;
        this.questionDecription = questionDecription;
        this.questionContent = questionContent;
    }

    public Question(String subjectId , Integer memberId, String questionName, String questionDecription, String questionContent) {
        this.subjectId = subjectId;
        this.memberId = memberId;
        this.questionName = questionName;
        this.questionDecription = questionDecription;
        this.questionContent = questionContent;
    }
    
    public Question(Integer questionId, String subject, Integer member, String questionName, String questionDecription, String questionContent, Date questionDate, boolean questionAccept) {
        this.questionId = questionId;
        this.subjectId = subject;
        this.memberId = member;
        this.questionName = questionName;
        this.questionDecription = questionDecription;
        this.questionContent = questionContent;
        this.questionDate = questionDate;
        this.questionAccept = questionAccept;
    }
    public  Question(){
    }
    public  Question(Integer id){
        this.questionId= id;    
    }
    public  Question(Integer questionId, boolean  AcceptQuestion){
        this.questionId = questionId;
        this.questionAccept = AcceptQuestion;
    }
    
     public Question(Integer questionId, Member member, String questionName, String questionDecription, String questionContent, Date questionDate, boolean questionAccept) {
        this.questionId = questionId;
        this.member = member;
        this.questionName = questionName;
        this.questionDecription = questionDecription;
        this.questionContent = questionContent;
        this.questionDate = questionDate;
        this.questionAccept = questionAccept;
    }
}
