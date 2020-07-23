package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import dao.CityDAO;
import dao.TeamDAO;
import model.City;
import model.Team;

public class Main{
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		CityDAO citydao=new CityDAO();
		TeamDAO teamdao=new TeamDAO();
		
		System.out.println("Enter city name");
		String cityName=br.readLine();
		
		System.out.println("Enter city id");
		long id=Long.parseLong(br.readLine());
		
		City city=new City(id,cityName);
		
		System.out.println("Enter team name");
		String name=br.readLine();
		
		System.out.println("Enter coach name");
		String coachName=br.readLine();
		
		Team team = new Team(name, coachName,city);
		teamdao.createTeam(team);
		
		System.out.println("Enter name of city");
		String cityname = br.readLine();
		
		city = citydao.getCityByName(cityname);
		
		System.out.println("City id = "+city.getCityId());
		System.out.println("city name = "+city.getCityName());	
	}
}
