package com.githrd.test.dao;

	import java.sql.*;
	import com.githrd.test.db.*;
	import com.githrd.test.vo.*;
	import com.githrd.test.sql.*;
	public class AjaxDao {
		private GitJDBC db;
		private Connection con;
		private Statement stmt;
		private PreparedStatement pstmt;
		private ResultSet rs;
		private MemberSQL mSQL;
		
		
			public AjaxDao() {
				db = new GitJDBC();
				mSQL = new MemberSQL();
			}
			
			
			// 회원번호로 아바타 정보 조회 전담 처리함수
			public MemberVO getMnoInfo(int mno) {
				// 반환값 변수
				MemberVO mVO = new MemberVO();
				
				// 1. con
				con = db.getCon();
				// 2. sql
				String sql = mSQL.getSQL(mSQL.SEL_MEMBER_INFO);
				// 3. pstmt
				pstmt = db.getPstmt(con, sql);
				try{
					// 4. 질의명령 완성하고
					pstmt.setInt(1, mno);
					// 5. 질의명령 보내고 결과받고
					rs = pstmt.executeQuery();
					// 6. 데이터 꺼내고
					rs.next();
					String savename = rs.getString("savename");
					int amno = rs.getInt("mno");
					String name  = rs.getString("name");
					String id = rs.getString("id");
					String tel = rs.getString("tel");
					String mail = rs.getString("mail");
					String gen = rs.getString("gen");
					Date hdate = rs.getDate("joindate");

					// 7. 꺼낸데이터 VO 담고
					mVO.setSavename(savename);
					mVO.setMno(amno);
					mVO.setName(name);
					mVO.setId(id);
					mVO.setTel(tel);
					mVO.setMail(mail);
					mVO.setGen(gen);
					mVO.setSdate();
					
					
				} catch(Exception e) {
					e.printStackTrace();
				} finally {
					db.close(rs);
					db.close(pstmt);
					db.close(con);
				}
				// 데이터 반환하고
				return mVO;
			}

		}