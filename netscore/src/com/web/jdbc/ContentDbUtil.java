package com.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

public class ContentDbUtil {
	
	private DataSource dataSource;
	
	public ContentDbUtil(DataSource thedataSource) {
		dataSource = thedataSource;
	}
	
	private Connection conn;
	private Statement mySt;
	private PreparedStatement myPrSt;
	private ResultSet myRs;

	// jdbc close method
	public void close(Connection conn, Statement mySt, ResultSet myRs){
		try {
			if(myRs != null) {
				myRs.close();
			}
			if(mySt != null) {
				mySt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
	
	}
	
	//get contents for list
	public List<Contents> getContents(String sortingBy) throws Exception {
		List<Contents> contents = new ArrayList<>();
		StringBuilder stb = new StringBuilder("SELECT * FROM contents");
		stb.append(sortingBy);
		String sql = stb.toString();
		try {
			conn = dataSource.getConnection();
			mySt = conn.createStatement();
			myRs = mySt.executeQuery(sql);
			
			while(myRs.next()) {
				int content_id = myRs.getInt("id");
				String title = myRs.getString("title");
				String describtion = myRs.getString("describtion");
				float avg_score = myRs.getFloat("avg_score");
				String img_path = myRs.getString("img_path");
				int year = myRs.getInt("year");
				int category_id = myRs.getInt("category_id");
				int genre_id = myRs.getInt("genre_id");
				int country_id = myRs.getInt("country_id");
				int run_time = myRs.getInt("run_time_mm");
				Contents tempContents = new Contents(content_id, title, describtion, avg_score, img_path, year, category_id, genre_id, country_id, run_time);
				contents.add(tempContents);
			}
			return contents;
		}finally {
			close(conn, mySt, myRs);
		}
		
	}
	
	// get user data for login
	public List<Contents> getUser(String theUserEmail)  throws Exception{
		List<Contents> user = new ArrayList<>();
		String sql = "SELECT * FROM users WHERE userEmail = ?";
		try {
			conn = dataSource.getConnection();
			myPrSt = conn.prepareStatement(sql);
			myPrSt.setString(1, theUserEmail);
			myRs = myPrSt.executeQuery();
			if(myRs == null) {
				return null;
			}else {
				while(myRs.next()) {
					int user_id = myRs.getInt("id");
					String userEmail = myRs.getString("userEmail");
					String userPassword = myRs.getString("userPassword");
					String userName = myRs.getString("userName");
					String userNick = myRs.getString("userNick");
					Contents tempuser = new Contents(user_id, userEmail, userPassword, userName, userNick);
					user.add(tempuser);
				}
				return user;
			}		
		}finally {
			close(conn, myPrSt, myRs);
		}
	}
	
	public void addUser(Contents newUser) throws Exception{
		Connection conn = null;
		PreparedStatement myPrSt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO users"
						+ "(userEmail, userPassword, userName, userNick)"
						+ " VALUES(?,?,?,?)";
			myPrSt = conn.prepareStatement(sql);
			myPrSt.setString(1, newUser.getUserEmail());
			myPrSt.setString(2, newUser.getUserPassword());
			myPrSt.setString(3, newUser.getUserName());
			myPrSt.setString(4, newUser.getUserNick());			
			myPrSt.execute();		
			
		}
		finally {
			close(conn,myPrSt,null);
		}
		
	}
	// get list reviews
	public List<Contents> getReviews(String sortingBy) throws Exception {
		List<Contents> reviews = new ArrayList<>();
		StringBuilder stb = new StringBuilder("SELECT reviews.id, content_id, user_id, userNick, review, score, review_at "
											+ "FROM reviews LEFT JOIN users ON users.id = reviews.user_id");
		stb.append(sortingBy);
		String sql = stb.toString();
		try {
			conn = dataSource.getConnection();
			mySt = conn.createStatement();
			myRs = mySt.executeQuery(sql);
			
			while(myRs.next()) {
				int review_id = myRs.getInt("id");
				int content_id = myRs.getInt("content_id");
				int user_id = myRs.getInt("user_id");
				String userNick = myRs.getString("userNick");
				String review = myRs.getString("review");
				float score = myRs.getFloat("score");
				Date review_at = myRs.getDate("review_at");
				Contents tempReviews = new Contents(review_id, content_id, user_id, userNick, review, score, review_at);
				reviews.add(tempReviews);
			}
			return reviews;
		}finally {
			close(conn, mySt, myRs);
		}
		
	}
	
	//insert new review
	public void addReview(Contents contents) throws Exception {
		Connection conn = null;
		PreparedStatement mySt = null;
		int parameter = contents.getContent_id();
		int parameter2 = contents.getUser_id();
		String parameter3 = contents.getReview();
		float parameter4 = contents.getScore();
		try {
			conn = dataSource.getConnection();
			String insertSql = "INSERT INTO reviews (content_id, user_id, review, score) VALUES(?, ?, ?, ?)";
			mySt = conn.prepareStatement(insertSql);
			mySt.setInt(1,parameter);
			mySt.setInt(2,parameter2);
			mySt.setString(3,parameter3);
			mySt.setFloat(4,parameter4);
			mySt.execute();
			autoUpdateScore(parameter);
		}
		catch(Exception e){
			e.printStackTrace();
		}finally {
			close(conn, mySt, null);
		}
	}
	
	public void deleteReview(int theReview_id) throws Exception {
		Connection conn = null;
		PreparedStatement mySt = null;
		String sql = "DELETE FROM reviews WHERE id=?";
		try {
			conn = dataSource.getConnection();
			mySt = conn.prepareStatement(sql);
			mySt.setInt(1, theReview_id);
			mySt.execute();
			autoUpdateScore(theReview_id);
		}finally {
			close(conn, mySt, null);
		}
	}
	
	//update avg_score on contents table when new review added and deleted
	public void autoUpdateScore(int content_id) throws Exception {
		Connection conn = null;
		PreparedStatement mySt = null;
		try {
			String sql = "UPDATE contents SET avg_score="
						+ "(SELECT AVG(score) AS avg_score FROM reviews WHERE content_id = ?) WHERE id = ?";
			conn = dataSource.getConnection();
			mySt = conn.prepareStatement(sql);
			mySt.setInt(1,content_id);
			mySt.setInt(2,content_id);
			mySt.execute();
		}finally {
			close(conn, mySt, null);
		}
	}
	
	
}
	



