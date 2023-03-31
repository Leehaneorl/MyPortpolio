package com.pettaming.animal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.pettaming.entity.action;
import com.pettaming.entity.action_line;

//animalActionService로 기능을 보내기 위한 DAO
public class animalActionDAO {
	
	//DataBase를 연결을 저장하기 위한 커넥션변수
    private Connection conn;
    
    //DataBase를 연결하기위한 매서드
    @SuppressWarnings("deprecation")
	public boolean open() {
    	
    	String id = "root";
    	String pw ="admin";
    	
        try {

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/animal_action_db?serverTimezone=Asia/Seoul", id, pw);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }
	
	//SQL닫기
	public void SQLClose(
			Connection conn,
			Statement mySt,
			ResultSet myRs) throws SQLException {
		try {
			if(myRs != null)
				myRs.close();
			if(mySt != null)
				mySt.close();
			if(conn != null) 
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	//애니멀 액션 테이블을 반환하기 위한 메서드
	public action get_animal(String animal,String actionNum) throws Exception {
		
		//애니멀 액션 객체의 한 줄을 담을 개체
		action_line Animal_Object = null;
		//완성된 action_line 객체를 순차적으로 모아두는 객체
		List<action_line> Animal = null;
		Statement mySt = null;
		ResultSet myRs = null;
		
		//애니멀 액션 테이블을 불러오는 쿼리문
		String animal_sql = "SELECT * FROM " + animal + "_" + actionNum;
		open();
		
		try {
		mySt = conn.createStatement();
		myRs = mySt.executeQuery(animal_sql);
		//애니멀 테이블 초기화
		Animal = new ArrayList<>();
		
		while(myRs.next()) {
			//y좌표값을 변수로 저장
			int y_Axis = myRs.getInt("Y");
			//작업에는 컬럼의 최대개수가 필요하기 때문에 컬럼의 개수를 저장
			int x_Axis = myRs.getMetaData().getColumnCount();
			//도트 한줄을 저장하기 위해 리스트 초기화
			List<String> x_Axis_list = new ArrayList<>(); 
			//컬럼의 개수만큼 반복하여 테이블의 x_ + i에 저장된 문자열을 리스트에 저장
			for(int i = 0; i < 21 ; i++) {
				String x = myRs.getString("x" + i);
				x_Axis_list.add(x);
			}
			
			//저장된 도트 한줄과 작업에 필요한 모든 정보를 객체화후 리스트에 저장
			Animal_Object = new action_line(y_Axis,x_Axis_list);
			Animal.add(Animal_Object);
		}
		//모든 도트를 저장한 애니멀 객체를 반환
		return new action(Animal);
		}
		finally {
			SQLClose(conn, mySt, myRs);
		}	
	}
	
}
