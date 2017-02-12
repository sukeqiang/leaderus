package launcher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.mockito.Mockito;
import org.springframework.jdbc.core.RowMapper;

import mybatis.domain.TBUser;
import userservice.bean.User;

public class TestApp<T> {
	static boolean started = false ;
    static Iterator<Map<String,Object>> iterator ; 
    static Map<String,Object> currentMap ;
    
    static List<Map<String,Object>> datas = new ArrayList<>();
    {
        Map<String,Object> row1 = new HashMap<String, Object>();
        row1.put("id", 1);
        row1.put("name", "gary1");
        row1.put("mark", 90 );
        datas.add(row1) ;

        Map<String,Object> row2 = new HashMap<String, Object>();
        row2.put("id", 2);
        row2.put("name", "gary");
        row2.put("mark", 80 );
        datas.add(row2) ;
    }

	public static <T> T rowMapper(ResultSet rs,RowMapper<T> rowMapper) {
		try {
			T t = rowMapper.mapRow(rs, rs.getRow());
			return t;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		DataSource dataSource = Mockito.mock(DataSource.class);
        Connection conn = Mockito.mock(Connection.class);
        Statement stmt = Mockito.mock(Statement.class);
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        try {
        	Mockito.when(dataSource.getConnection()).then(t -> {
        		return conn;
        	});
        	Mockito.when(dataSource.getConnection()).thenReturn(conn); 
        	Mockito.when(conn.createStatement()).thenReturn(stmt); 
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		TBUser listUser = TestApp.rowMapper(resultSet,(ResultSet rs, int row) -> {
			TBUser user = new TBUser();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setEnabled(rs.getBoolean(3));		
			return user;
		});
		System.out.println(listUser.toString());
	}

}
