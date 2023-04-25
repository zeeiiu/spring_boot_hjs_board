package edu.global.ex.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import edu.global.ex.vo.BoardVO;
import edu.global.ex.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class EmpDAO {

	// private DataSource dataSource;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";

	public EmpDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<EmpVO> empSelect(){
		List<EmpVO> vos = new ArrayList<EmpVO>();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "Select * from emp";
			
			//con = DriverManager.getConnection(url, uid, upw);
			con =  DriverManager.getConnection(url, uid, upw);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Date hireDate = rs.getDate("hiredate");
				int empno  = rs.getInt("empno");
				
				EmpVO vo = new EmpVO();
				vo.setHiredate(hireDate);
				vo.setEmpno(empno);
				
				vos.add(vo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) 
					rs.close();
				
				if(stmt != null) 
					stmt.close();
				
				if(con != null) 
					con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return vos;	
		
	}
	
	
}
