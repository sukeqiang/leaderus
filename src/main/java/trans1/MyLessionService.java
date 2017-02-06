package trans1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import trans.test.CustomTransException;

@Component
@Transactional
public class MyLessionService {

	protected transient Log logger = LogFactory.getLog(getClass());
	
	@Resource(name = "live_datasource")
	private DataSource dataSource;
	
	public void addLession(String name, String price){
		Connection con = DataSourceUtils.getConnection(dataSource);
		PreparedStatement ps = null;
		try{
			String sql = "insert into lession(name,price) values (?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, price);
			ps.executeUpdate();
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DataSourceUtils.releaseConnection(con, dataSource);
		}
	}
	
	public void queryLession(String name) throws SQLException {
		Connection con = DataSourceUtils.getConnection(dataSource);
		try {
			String sql = "";
			if(name == null || name.equals("")) {
				sql = "select name,price from lession";
			}else {
				sql = "select name,price from lession where name = '" + name + "'";
				
			}
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				logger.info("course:" + rs.getString(1) + "  price:" + rs.getString(2));
			}
			ps.close();
		}finally {
			DataSourceUtils.releaseConnection(con, dataSource);
		}
	}
}
