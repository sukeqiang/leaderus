package fourthLessons.mockTest.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fourthLessons.mockTest.pojo.TCourse;

@Component
public class MyCoureseService {	
	
	@Resource(name="live_datasource")
	DataSource dataSource;
	
	public List<TCourse> getAllCourse() throws Exception {
		List<TCourse> list = new ArrayList<TCourse>();
		Connection connection = dataSource.getConnection() ;
        Statement stmt = connection.createStatement() ;
        ResultSet rs = stmt.executeQuery("select id,name,mark from course") ;
        while(rs.next()){
			TCourse t = new TCourse();
			t.setId(Long.parseLong(String.valueOf((Integer)rs.getObject("id"))));
			t.setName((String)rs.getObject("name"));
			t.setMark(((Integer)rs.getObject("mark")).toString());
			list.add(t); 
        }
        return list;
    }
}
