package com.resturant;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/myServlet")
public class ResturantServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In doGet");
		
		String parameterValue = request.getParameter("todo");
		System.out.println("parameter value "+parameterValue);
		
		if(parameterValue.contentEquals("resturant")) {
			System.out.println("in resturant");
			String location = request.getParameter("location");
			System.out.println("location value "+location);
			Resturant resturant = new Resturant();
			System.out.println("create resturant obj");
			resturant = ResturantQueries.findResturantByLocation(location);
			if (!resturant.getResturantName().isEmpty()) {
				JSONObject jsonObject = Resturant.makeJSONObject(resturant);
				PrintWriter pw = response.getWriter();
				System.out.println(jsonObject.toString());
				pw.print(jsonObject.toString());
			}
		}
		else if(parameterValue.contentEquals("allResturant"))
		{
			System.out.println("all Resturant");
			List<Resturant> listOfAllResturant = ResturantQueries.findAllResturant();
			if(!listOfAllResturant.isEmpty())
			{
				JSONArray arr = Resturant.makeJSONArrayObject(listOfAllResturant);
				PrintWriter pw = response.getWriter();
				System.out.println(arr.toString());
				pw.print(arr.toString());
			}
		}
		else if(parameterValue.contentEquals("find"))
		{
			System.out.println("find closest");
			String location = request.getParameter("location");
			int loc = Integer.valueOf(location);
			List<Resturant> resturants = Resturant.findResturantClosest(loc);
			if(!resturants.isEmpty())
			{
				JSONArray obj = Resturant.makeJSONArrayObject(resturants);
				PrintWriter pw = response.getWriter();
				pw.print(obj.toString());
			}
			
		}
		
		else if(parameterValue.contentEquals("resturantname"))
		{
			System.out.println("in resutrantName");
			String name = request.getParameter("name");
			System.out.println("resturant name-> "+name);
			System.out.println("create resturant obj");
			List<Resturant> list = ResturantQueries.findResturantByName(name);
			if (!list.isEmpty()) {
				JSONArray obj = Resturant.makeJSONArrayObject(list);
				PrintWriter pw = response.getWriter();
				pw.print(obj.toString());
			}
		}	
		else if(parameterValue.contentEquals("franchiseName"))
		{
			System.out.println("in franchiseName");
//			String name = request.getParameter("name");
			PrintWriter pw = response.getWriter();
			pw.print("in franchiseName");	
		}

		else if(parameterValue.contentEquals("menu"))
		{
			System.out.println("in menu");
			
			String restuarantLocation = request.getParameter("resturantlocation");
			int i = Integer.valueOf(restuarantLocation);
			System.out.println("menu from "+restuarantLocation);
			Menu m = MenuQueries.findAllMenuByLocation(i);
			System.out.println(m);
			if(m!=null)
			{
				JSONObject obj = Menu.makeJSONObject(m);
				PrintWriter pw = response.getWriter();
				pw.write(obj.toString());
			}
		}
		else if(parameterValue.contentEquals("menucalories"))
		{
			String resturantName = request.getParameter("resturantname");
			String calories = request.getParameter("calories");
			
			System.out.println("resurant name -> "+resturantName +" & calories "+calories);
			
			Float cal =Float.valueOf(calories);
			Menu m = MenuQueries.findMenuByResturantNameAndByCalories(resturantName, cal);
			System.out.println(m);
			if(m!=null)
			{
				JSONObject obj = Menu.makeJSONObject(m);
				PrintWriter pw = response.getWriter();
				pw.print(obj.toString());
			}
		}
		else if(parameterValue.contentEquals("servedAt"))
		{
			String resturantname = request.getParameter("resturantname");
			String mealtime = request.getParameter("meal");
			
			System.out.println("resturant name ->"+resturantname +" & mealtime" +mealtime );
			
			Menu m = MenuQueries.findMenuServedAt(resturantname, mealtime);
			if(m!=null)
			{
				JSONObject obj = Menu.makeJSONObject(m);
				PrintWriter pw = response.getWriter();
				pw.print(obj.toString());
			}
		}
		
//		else if(parameterValue.equals("login"))
//		{
//			System.out.println("in login");
//			PrintWriter pw = response.getWriter();
//			pw.println("in login");	
////			String username = request.getParameter("username");
////			String password = request.getParameter("password");
////			
////			int i = AdminQueries.LogInAsAdmin(username, password);
////			PrintWriter pw = response.getWriter();
////			pw.println("Logged In "+i);	
//		}
		else {
			System.out.println("in default else stamtnet");
			PrintWriter pw = response.getWriter();
			pw.print("cant understand the parameterValue");	
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("in do Post");
		String parameterValue = request.getParameter("todo");
		
		if(parameterValue.equals("Login"))
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			JSONObject obj =  AdminQueries.LogInAsAdmin(username, password);
			PrintWriter pw = response.getWriter();
			pw.print(obj.toString());	
		}
		
		else if(parameterValue.equals("create"))
		{
			

		}
	}
}
