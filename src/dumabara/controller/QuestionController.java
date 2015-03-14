/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumabara.controller;

import dumbara.db.DBConnection;
import dumbara.model.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ChanakaDe
 */
public class QuestionController {
    public static int addQuestion(ArrayList<Question> arrayList) throws ClassNotFoundException, SQLException{
        int res=0;
        for (Question question : arrayList) {
            String sql="insert into questions values (?,?)";
            Connection conn=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, question.getId());
            preparedStatement.setString(2, question.getQuestion());
            res=preparedStatement.executeUpdate();
        }
        return res;
    }
    public static int updateQuestion(ArrayList<Question> arrayList) throws ClassNotFoundException, SQLException{
        int executeUpdate=0;
        for (Question question : arrayList) {
            String sql="update questions set question = ? where questionID = ? ";
            Connection conn=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, question.getQuestion());
            preparedStatement.setString(2, question.getId());
            executeUpdate = preparedStatement.executeUpdate();
        }
        return executeUpdate;
    }
    public static Question[] getQuestions() throws ClassNotFoundException, SQLException{
        String sql="select * from questions";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        Question[]  question=new Question[count];
        rst.beforeFirst();
        
        for (int i = 0;rst.next(); i++) {
            String id=rst.getString("questionid");
            String ques=rst.getString("question");
            Question question1=new Question(id, ques);
            question[i]=question1;
        }
        return question;
    }
}
