package com.web.jdbc;

import java.util.Date;

public class Contents {
	
	//------------------------------contents values------------------------------------
	private int content_id;

	private  String title;
	
	private String describtion;
	
	private float avg_score;
	
	private String img_path;
	
	private int year;
	
	private int category_id;       // 1.movie 2.series 3.variety
	
	private int genre_id;          // 1.action 2.romance 3.comedy 
	
	private int country_id;           // 1.Korea 2.USA 3.Japan.....
	
	private int run_time;           //minutes

	public Contents(int content_id, String title, String describtion, float avg_score, String img_path, int year, int category_id,
			int genre_id, int country_id, int run_time) {
		super();
		this.content_id = content_id;
		this.title = title;
		this.describtion = describtion;
		this.avg_score = avg_score;
		this.img_path = img_path;
		this.year = year;
		this.category_id = category_id;
		this.genre_id = genre_id;
		this.country_id = country_id;
		this.run_time = run_time;
	}
	
	public int getContent_id() {
		return content_id;
	}

	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

	public float getAvg_score() {
		return avg_score;
	}

	public void setAvg_scroe(float avg_scroe) {
		this.avg_score = avg_scroe;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public int getRun_time() {
		return run_time;
	}

	public void setRun_time(int run_time) {
		this.run_time = run_time;
	}

	
	//------------------------------users values------------------------------------
	private int user_id;

	@Override
	public String toString() {
		return "Contents [user_id=" + user_id + ", userEmail=" + userEmail + ", userPassword=" + userPassword
				+ ", userName=" + userName + ", userNick=" + userNick + "]";
	}


	private  String userEmail;
	
	private String userPassword;
	
	private String userName;
	
	private String userNick;
	

	public Contents(int user_id, String userEmail, String userPassword, String userName, String userNick) {
		super();
		this.user_id = user_id;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userNick = userNick;
	}
	
	public Contents(String userEmail, String userPassword, String userName, String userNick) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userNick = userNick;
	}
	

	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserNick() {
		return userNick;
	}


	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	
	
	//------------------------------reviews values------------------------------------	
		
		private int review_id;
		
		private String review;
		
		private float score;
		
		private Date review_at;
		

		//constructor for list of reviews 
		public Contents(int review_id, int content_id, int user_id, String userNick , String review, float score, Date review_at) {
			super();
			this.review_id = review_id;
			this.content_id = content_id;
			this.user_id = user_id;
			this.userNick = userNick;
			this.review = review;
			this.score = score;
			this.review_at = review_at;
		}
		
		public Contents(int content_id, int user_id, String review, float score) {
			super();
			this.content_id = content_id;
			this.user_id = user_id;
			this.review = review;
			this.score = score;
		}

		public int getReview_id() {
			return review_id;
		}

		public void setReview_id(int review_id) {
			this.review_id = review_id;
		}

		public String getReview() {
			return review;
		}

		public void setReview(String review) {
			this.review = review;
		}

		public float getScore() {
			return score;
		}

		public void setScore(float score) {
			this.score = score;
		}

		public Date getReview_at() {
			return review_at;
		}

		public void setReview_at(Date review_at) {
			this.review_at = review_at;
		}

		public void setAvg_score(float avg_score) {
			this.avg_score = avg_score;
		}
		

	
}

