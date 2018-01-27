package com.king.timenotes.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.king.timenotes.jdbc.entity.Note;
import com.king.timenotes.jdbc.entity.UserInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Service
public class UserInfoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<UserInfo> login(String username ,String password){
        String sql = "select name,password,birthday,address from userinfo where name='"+username+"'";

        List<UserInfo> userinfoList = jdbcTemplate.query(sql, new RowMapper<UserInfo>() {
            @Override
            public UserInfo mapRow(ResultSet resultSet, int i) throws SQLException {
                UserInfo userinfo = new UserInfo();
                userinfo.setName(resultSet.getString("name"));
                userinfo.setPassword(resultSet.getString("password"));
                userinfo.setBirthday(resultSet.getString("birthday"));
                userinfo.setAddress(resultSet.getString("address"));
                return userinfo;
            }
        });

        return userinfoList;
    }
    
    public List<Note> queryNotes(String username){
        String sql = "select title,content,datetime  from note where username='"+username+"'";

        List<Note> noteList = jdbcTemplate.query(sql, new RowMapper<Note>() {
            @Override
            public Note mapRow(ResultSet resultSet, int i) throws SQLException {
            	Note note = new Note();
            	note.setTitle(resultSet.getString("title"));
            	note.setContent(resultSet.getString("content"));
            	note.setDatetime(resultSet.getString("datetime"));
                return note;
            }
        });

        return noteList;
    }
    
    public void addNote(String username,String title,String content){
    	String sql = "insert into note (username,title,content) values(\""+username+"\",\""+title+"\",\""+content+"\")";
    	jdbcTemplate.execute(sql);
    }

}
