package info.inetsolv;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;


public class OurResultSetExtractor implements ResultSetExtractor<List<Employee>> {

	@Override
	public List<Employee> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
			
		ArrayList<Employee> list=new ArrayList<Employee>();
		 while(rs.next()){
			 Employee e=new Employee();
			 e.setEno(rs.getString("eno"));
			 e.setName(rs.getString("name"));
			 e.setSalary(rs.getString("salary"));
			 list.add(e);
		 }
		return list;
	}

}
