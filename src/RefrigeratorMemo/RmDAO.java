package RefrigeratorMemo;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

public class RmDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs;
	
	private String sql = "";
	RmVO vo = null;
	RmHwVO vo2 = null;
	Date now = new Date();

	public RmDAO() {
		try {
			String url="jdbc:mysql://localhost:3306/java06_psj";
			String user = "root";
			String password = "1234";
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패");
		} catch (SQLException e) {
			System.out.println("DB연동 실패");
			e.printStackTrace();
		}
	}

	public void connClose() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}
	public void pstmtClose() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {}
		}
	}
	public void rsClose() {
		if(rs != null) {
			try {
				rs.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {}
		}
	}
	
	// 로그인 처리
	public int Login(String mid, String pwd) {
		sql = "select pwd from RmHw where mid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(pwd)) {
					return 1;
				}
				else return 0;
			}
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -2;
	}
	// 회원가입 처리
	public void Join(RmHwVO vo2) {
		sql = "insert into RmHw values (default,?,?,?,?);";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo2.getMid());
			pstmt.setString(2, vo2.getPwd());
			pstmt.setString(3, vo2.getHwName());
			pstmt.setInt(4, vo2.getAge());
			pstmt.executeUpdate();
			System.out.println(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql에러: " + e.getMessage());
		}finally {
			pstmtClose();
		}
	}
	// 실행문 입력처리
	public void RmC(RmVO vo) {
		try {
			sql = "insert into RM values (default,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPutdate());
			pstmt.setString(3, vo.getPosition());
			pstmt.setInt(4, vo.getNum());
			pstmt.setString(5, vo.getKind());
			pstmt.setString(6, vo.getMemo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("sql에러: " + e.getMessage());
		}finally {
			pstmtClose();
		}
	}
	
	// 전체자료 조회
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Vector getList() {
			Vector vData = new Vector();
			try {
				sql = "select * from RM order by idx desc";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Vector vo = new Vector();
					vo.add(rs.getInt("idx"));
					vo.add(rs.getString("name"));
					vo.add(rs.getString("putdate"));
					vo.add(rs.getString("position"));
					vo.add(rs.getInt("num"));
					vo.add(rs.getString("kind"));
					vo.add(rs.getString("memo"));
					vData.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("sql에러: " + e.getMessage());
			}finally {
				rsClose();
			}
			return vData;
		}

		// 조건검색
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Vector getSearch(String str, String txtStr) {
			Vector vData = new Vector();
			try {
		//		sql = "select * from RM where "+str+" = ? order by idx desc";
				sql = "select * from RM where "+str+" like ? order by idx desc";
				pstmt = conn.prepareStatement(sql);
				if(str.equals(str)) {
					pstmt.setString(1, "%"+txtStr+"%");
				//	pstmt.setString(1, txtStr);
				}
				else {
				}
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Vector vo = new Vector();
					vo.add(rs.getInt("idx"));
					vo.add(rs.getString("name"));
					vo.add(rs.getString("putdate"));
					vo.add(rs.getString("position"));
					vo.add(rs.getInt("num"));
					vo.add(rs.getString("kind"));
					vo.add(rs.getString("memo"));
					vData.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("sql에러: " + e.getMessage());
			}finally {
				rsClose();
			}
			return vData;
		}

		// 삭제
		public void delete(String name) {
			sql ="delete from RM where name = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("sql 오류 : " + e.getMessage() + " : " + sql);
			}finally {
				pstmtClose();
			}
		}
		
		// 유통기한
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Vector getDate() {
			Vector vData = new Vector();
	        try {
	        	sql = "select * from RM where putdate < now()";
	        	pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Vector vo = new Vector();
					vo.add(rs.getInt("idx"));
					vo.add(rs.getString("name"));
					vo.add(rs.getString("putdate"));
					vo.add(rs.getString("position"));
					vo.add(rs.getInt("num"));
					vo.add(rs.getString("kind"));
					vo.add(rs.getString("memo"));
					vData.add(vo);
				}
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return vData;
		}
}
