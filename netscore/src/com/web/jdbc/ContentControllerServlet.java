package com.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ContentControllerServlet
 */
@WebServlet("/ContentControllerServlet")
public class ContentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContentDbUtil contentDbUtil;
	
	@Resource(name = "jdbc/netscore")
	private DataSource dataSource;
	

    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		contentDbUtil = new ContentDbUtil(dataSource);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try{
			String theCommand = request.getParameter("command");
			
			if(theCommand == null) {
				theCommand="MAIN";
			}
			switch(theCommand) {
			case "MAIN":
				listPopular(request, response);
				break;
			case "LIST":
				listContents(request, response);
				break;
			case "SEARCH":
				searchContents(request, response);
				break;
			case "LOAD":                               //load review page
				loadReviews(request, response);
				break;
			case "DELETE":								//delete review & refresh
				deleteReviews(request, response);
				break;
			}
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	private void deleteReviews(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int theReview_id = Integer.parseInt(request.getParameter("review_id"));
		int theContent_id = Integer.parseInt(request.getParameter("content_id"));
		contentDbUtil.deleteReview(theReview_id);
		response.sendRedirect(request.getContextPath() + "/ContentControllerServlet?command=LOAD&content_id="+theContent_id);
		
	}



	// shows content's inform and reviews
	private void loadReviews(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String theContent_id = request.getParameter("content_id");
		try {
			List<Contents> content_info = contentDbUtil.getContents(" WHERE id = "+ theContent_id);
			request.setAttribute("content_info", content_info);
			List<Contents> reivews = contentDbUtil.getReviews(" WHERE content_id = " + theContent_id);
			request.setAttribute("content_reviews", reivews);
		}catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Review.jsp");
		dispatcher.forward(request, response);
		
	}
	

	private void searchContents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String searchItem = request.getParameter("search");
		try {
			List<Contents> contents = contentDbUtil.getContents(" WHERE title LIKE '%" + searchItem + "%'");
			if(contents.isEmpty()) {
				request.setAttribute("contents_list", "no_result");
			}else {
				request.setAttribute("contents_list", contents);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/List.jsp");
		dispatcher.forward(request, response);
	}

	// contents list ordered by category(1.movie, 2.series, 3.variety)
	private void listContents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String theCategory_id = request.getParameter("category_id");
		try {
			List<Contents> contents = contentDbUtil.getContents(" WHERE category_id = "+ theCategory_id);
			request.setAttribute("contents_list", contents);
		}catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/List.jsp");
		dispatcher.forward(request, response);
	}
	

	// contents list of top score (1st~10th)
	private void listPopular(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			List<Contents> contents = contentDbUtil.getContents(" ORDER BY avg_score DESC LIMIT 10");
			request.setAttribute("contents_list", contents);
		}catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Main.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try{
			String theCommand = request.getParameter("command");
			
			if(theCommand == null) {
				theCommand="MAIN";
				response.sendRedirect(request.getContextPath() + "/ContentControllerServlet");
			}
			switch(theCommand) {
			case "LOGIN":
				checkUser(request, response);
				break;
			case "JOIN":
				joinUser(request, response);
				break;
			case "REVIEW":
				addReview(request, response);
				break;
			}
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}


	private void joinUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String UserEmail = request.getParameter("userEmail");
		String UserPW = request.getParameter("userPassword");
		String UserName = request.getParameter("userName");
		String NickName = request.getParameter("userNick");
		try {
			if(contentDbUtil.getUser(UserEmail).isEmpty()) {    //if there is no same email, then save user and auto login
				Contents newUser = new Contents(UserEmail, UserPW, UserName, NickName);
				contentDbUtil.addUser(newUser);
				List<Contents> user = contentDbUtil.getUser(UserEmail);
				request.setAttribute("loginCheck", user);
			}else {
				request.setAttribute("loginCheck", "same_email");  //if there is same email, then go back to join_form
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginAction.jsp");
		dispatcher.forward(request, response);
	}


	private void addReview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int content_id= Integer.parseInt(request.getParameter("content_id"));
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String review = request.getParameter("review");
		float score = Float.parseFloat(request.getParameter("score"));
		Contents newReview = new Contents(content_id, user_id, review, score);
		contentDbUtil.addReview(newReview);
		response.sendRedirect(request.getContextPath() + "/ContentControllerServlet?command=LOAD&content_id="+content_id);
	}


	private void checkUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String checkEmail = request.getParameter("userEmail");
		String checkPassword = request.getParameter("userPassword");
		List<Contents> user = contentDbUtil.getUser(checkEmail);
		try {
			if(user.isEmpty()) {                                           // no matching email
				request.setAttribute("loginCheck", "wrong_email");
			}else if(!user.get(0).getUserPassword().equals(checkPassword)){    // wrong password
				request.setAttribute("loginCheck", "wrong_password");
			}else if(user.get(0).getUserPassword().equals(checkPassword)) {    // match password
				request.setAttribute("loginCheck", user);
			}else {
				request.setAttribute("loginCheck", "wrong_something");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginAction.jsp");
		dispatcher.forward(request, response);
	}
	
}
