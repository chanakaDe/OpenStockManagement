/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumbara.model;

/**
 *
 * @author ChanakaDe
 */
public class Question {
    private String id;
    private String question;

    public Question() {
    }

    public Question(String id, String question) {
        this.id = id;
        this.question = question;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }
    
    
}
