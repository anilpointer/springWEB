package info.inetsolv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MyApp {

	public static void main(String[] args) {
		ApplicationContext container=new ClassPathXmlApplicationContext("spring.xml");
		JdbcTemplate jt=container.getBean("jdbcTemplate",JdbcTemplate.class);
		List<Employee> records=jt.query("select * from emp",
				new RowMapper<Employee>(){
					@Override
					public Employee mapRow(ResultSet rs, int rowNum)
							throws SQLException {
							Employee e=new Employee();
							e.setEno(rs.getString("eno"));
							e.setName(rs.getString("name"));
							e.setSalary(rs.getString("salary"));
						return e;
					}
					
				});
		for(Employee e:records){
			System.out.print(e.getEno()+"\t");
			System.out.print(e.getName()+"\t");
			System.out.print(e.getSalary()+"\n");
		}
		}
	}
