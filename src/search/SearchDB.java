package search;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Pattern;

import common.DBConnection;

public class SearchDB {	
	private Connection con = null;
	
	public ArrayList<WorkInfo> SearchByWork(String work){
		ArrayList<WorkInfo> wi_list = new ArrayList<WorkInfo>();
		ResultSet rs=null;
        Statement sql=null;
        try {
        	con=DBConnection.getConnection();
			sql=con.createStatement();
			  rs=sql.executeQuery("select works.*,userinfo.UserName from works inner join userinfo on works.WriterId=userinfo.UserId");
		        while(rs.next()) {
		        	if(rs.getString("content").matches(".*"+work+".*")||rs.getString("Title").matches(".*"+work+".*"))
		        	{
				        WorkInfo wi=new WorkInfo();
				        wi.setWriterName(rs.getString("UserName"));
				        wi.setId(rs.getInt("Id"));
				        wi.setWriterId(rs.getString("WriterId"));
				        wi.setTitle(rs.getString("Title"));
				        wi.setContent(rs.getString("content"));
				        wi.setSummary(rs.getString("summary"));
				        wi.setTypes(rs.getString("types"));
				        wi_list.add(wi);
		        	}
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wi_list;
	}
	public ArrayList<WorkInfo> SearchByWriter (String writer){
		ArrayList<WorkInfo> wi_list = new ArrayList<WorkInfo>();
		ResultSet rs=null;
        Statement sql=null;
        try {
        	con=DBConnection.getConnection();
			sql=con.createStatement();
			  rs=sql.executeQuery("select works.*,userinfo.UserName from works inner join userinfo on works.WriterId=userinfo.UserId");
		        while(rs.next()) {
		        	if(Pattern.matches(".*"+writer+".*", rs.getString("UserName")))
		        	{
				        WorkInfo wi=new WorkInfo();
				        wi.setWriterName(rs.getString("UserName"));
				        wi.setId(rs.getInt("Id"));
				        wi.setWriterId(rs.getString("WriterId"));
				        wi.setTitle(rs.getString("Title"));
				        wi.setContent(rs.getString("content"));
				        wi.setSummary(rs.getString("summary"));
				        wi.setTypes(rs.getString("types"));
				        wi_list.add(wi);
		        	}
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wi_list;
	}
	public ArrayList<WorkInfo> SearchByType (String type){
		ArrayList<WorkInfo> wi_list = new ArrayList<WorkInfo>();
		ResultSet rs=null;
        Statement sql=null;
        try {
        	con=DBConnection.getConnection();
			sql=con.createStatement();
			  rs=sql.executeQuery("select works.*,userinfo.UserName from works inner join userinfo on works.WriterId=userinfo.UserId");
		        while(rs.next()) {
		        	if(rs.getString("types").equals(type))
		        	{
				        WorkInfo wi=new WorkInfo();
				        wi.setWriterName(rs.getString("UserName"));
				        wi.setId(rs.getInt("Id"));
				        wi.setWriterId(rs.getString("WriterId"));
				        wi.setTitle(rs.getString("Title"));
				        wi.setContent(rs.getString("content"));
				        wi.setSummary(rs.getString("summary"));
				        wi.setTypes(rs.getString("types"));
				        wi_list.add(wi);
		        	}
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wi_list;
	}
	public ArrayList<WorkInfo> GetAll(){
		ArrayList<WorkInfo> wi_list = new ArrayList<WorkInfo>();
		ResultSet rs=null;
        Statement sql=null;
        try {
        	con=DBConnection.getConnection();
			sql=con.createStatement();
			  rs=sql.executeQuery("select works.*,userinfo.UserName from works inner join userinfo on works.WriterId=userinfo.UserId");
		        while(rs.next()) {
				        WorkInfo wi=new WorkInfo();
				        wi.setWriterName(rs.getString("UserName"));
				        wi.setId(rs.getInt("Id"));
				        wi.setWriterId(rs.getString("WriterId"));
				        wi.setTitle(rs.getString("Title"));
				        wi.setContent(rs.getString("content"));
				        wi.setSummary(rs.getString("summary"));
				        wi.setTypes(rs.getString("types"));
				        wi_list.add(wi);
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wi_list;
	}
}
