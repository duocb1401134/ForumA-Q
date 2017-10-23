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
public class Answer {
    private Integer anwserId;
    private String anwserContent;
    private Date anwserDate;

    public Answer(Integer anwserId, String anwserContent, Date anwserDate) {
        this.anwserId = anwserId;
        this.anwserContent = anwserContent;
        this.anwserDate = anwserDate;
    }

    public Integer getAnwserId() {
        return anwserId;
    }

    public void setAnwserId(Integer anwserId) {
        this.anwserId = anwserId;
    }

    public String getAnwserContent() {
        return anwserContent;
    }

    public void setAnwserContent(String anwserContent) {
        this.anwserContent = anwserContent;
    }

    public Date getAnwserDate() {
        return anwserDate;
    }

    public void setAnwserDate(Date anwserDate) {
        this.anwserDate = anwserDate;
    }
    
}
