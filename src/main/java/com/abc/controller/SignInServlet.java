package com.abc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.bean.Customer;
import com.abc.bean.SignInPOJO;
import com.abc.model.EmployeeSignIn;
import com.abc.model.OperationClass;
import com.google.gson.Gson;

/**
 * Servlet implementation class SignInServlet
 */
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	//List<Customer> empList = new LinkedList<Customer>();
    static Map<String,Object> map  = new HashMap<String,Object>();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. get recieved data from json request
		boolean isValid = false;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		System.out.println("json vlaue is "+json);
		
		SignInPOJO signInPOJO = new Gson().fromJson(json, SignInPOJO.class);
		System.out.println("sign in pojo value "+signInPOJO.getEmail());
		if(OperationClass.userValidate(signInPOJO)){
			ArrayList<Customer> arrList= (ArrayList<Customer>) OperationClass.getUserName(signInPOJO.getEmail());
			System.out.println(arrList);
			map.put("username", arrList);
			isValid = true;
		}
		map.put("isValid", isValid);
		/// return json back to js
		write(request,response);
	
		
	}
	private static void write(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(new Gson().toJson(map));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
