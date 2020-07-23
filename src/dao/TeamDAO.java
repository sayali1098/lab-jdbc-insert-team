package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.City;
import model.Team;
import utility.ConnectionManager;

public class TeamDAO {
	
	public void createTeam(Team team) throws ClassNotFoundException, SQLException, IOException {
		
		System.out.println("Create team dao");
		
		String name = team.getName();
		String coach = team.getCoach();
		Long cityid = team.getCity().getCityId(); // to get value 
		
		ConnectionManager cm = new ConnectionManager();
		
		String sql = "insert into TEAM(NAME,COACH,CITY)VALUES(?,?,?)";
		
		PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);
		
		st.setString(1, name);
		st.setString(2, coach);
		st.setLong(3, cityid);
		
		st.executeUpdate();
		ConnectionManager.getConnection().close();
	}
}
