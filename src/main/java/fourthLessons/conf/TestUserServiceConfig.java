package fourthLessons.conf;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import fourthLessons.mockTest.pojo.TCourse;


@Profile(value = "testConf")
@Configuration
public class TestUserServiceConfig {
	
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(TestUserServiceConfig.class);
	
	boolean started = false ;
    Iterator<Map<String,Object>> iterator ; 
    Map<String,Object> currentMap ;
    
    List<Map<String,Object>> datas = new ArrayList<>();
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
    
    public class TCourseMapper implements RowMapper<TCourse>{

    	@Override
    	public TCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
    		TCourse tCourse = new TCourse();
    		tCourse.setId(rs.getInt("id"));
    		tCourse.setName(rs.getString("name"));
    		tCourse.setMark(rs.getString("mark"));
    		return tCourse;
    	}
    }
	
	@Bean(value="live_datasource")
	public DataSource dataSource() {
		DataSource dataSource = Mockito.mock(DataSource.class);
        Connection conn = Mockito.mock(Connection.class);
        Statement stmt = Mockito.mock(Statement.class);
        ResultSet rs = Mockito.mock(ResultSet.class);
        try {
        	Mockito.when(dataSource.getConnection()).then(t -> {
        		logger.info("get connection!");
        		return conn;
        	});
        	Mockito.when(dataSource.getConnection()).thenReturn(conn); 
        	Mockito.when(conn.createStatement()).thenReturn(stmt); 
            Mockito.when(stmt.executeQuery(Mockito.anyString())).thenReturn(rs);
            Mockito.doAnswer(t -> {
                if(!started){
                    started = true;
                    iterator = datas.iterator();
                }
                boolean flag = iterator.hasNext();
                if(!flag){
                    started = false ;
                    iterator = null ;
                }
                if(started){
                    currentMap = iterator.next();
                }
                return flag ;
            }).when(rs).next();
            
            Mockito.doAnswer(t->{
                Object[] params = t.getArguments();
                return currentMap.get( params[0] ) ; 
            }).when(rs).getObject(Mockito.anyString()) ;
            
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return dataSource;
	}
}
