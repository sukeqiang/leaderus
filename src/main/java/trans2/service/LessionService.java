package trans2.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import trans.test.CustomTransException;

@Component
public class LessionService {

	protected transient Log logger = LogFactory.getLog(getClass());
	
	@Resource(name = "live_datasource")
	private DataSource dataSource;
	
	public void saveService(String name, String price){
		Connection con = DataSourceUtils.getConnection(dataSource);
		PreparedStatement ps = null;
		try{
			String sql = "insert into lession(name,price) values (?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, price);
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		LessionService s = (LessionService)AopContext.currentProxy();
		s.queryService("alice");
	}
	
	public void queryService(String name) {
		Connection con = DataSourceUtils.getConnection(dataSource);
		String sql = "";
		if(name == null || name.equals("")) {
			sql = "select name,price from lession";
		}else {
			sql = "select name,price from lession where name = '" + name + "'";
			
		}
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				logger.info("course:" + rs.getString(1) + "  price:" + rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
