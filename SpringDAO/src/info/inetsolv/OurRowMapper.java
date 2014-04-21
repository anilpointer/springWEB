package info.inetsolv;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OurRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNumber) throws SQLException {
		Employee e=new Employee();
		e.setEno(rs.getString("eno"));
		e.setName(rs.getString("name"));
		e.setSalary(rs.getString("salary"));
		return e;
	}
	
}
