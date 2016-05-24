<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.design.jdbc.CreatDB"%>
<%@page import="java.sql.Connection"%>
<%
	String name=request.getParameter("author");
	int count=0;
	boolean b=false;
	try {
		Connection conn=CreatDB.getConnection_ZH();
		PreparedStatement ps=conn.prepareStatement("SELECT PName FROM publish WHERE PName=?");
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			count++;
		}
		
		if(count==0){
			PreparedStatement publish=conn.prepareStatement("INSERT INTO publish(PName) values(?)");
			publish.setString(1, name);
			b=publish.execute();
			publish.close();
		}
		ps.close();
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	out.print(b);

%>