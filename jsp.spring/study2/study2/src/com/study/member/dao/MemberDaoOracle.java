package com.study.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.study.exception.DaoException;
import com.study.member.vo.MemberVO;

public class MemberDaoOracle implements IMemberDao{

	@Override
	public List<MemberVO> getMemberList() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");

			StringBuffer sb = new StringBuffer();
			
			sb.append("SELECT																");
			sb.append("    mem_id														");
			sb.append("    , mem_pass      , mem_name									");
			sb.append("	 , TO_CHAR(mem_bir,'YYYY-MM-dd') AS mem_bir				");
			sb.append("    , mem_zip       , mem_add1      , mem_add2				");
			sb.append("    , mem_hp        , mem_mail      							");
			sb.append("    , DECODE(MEM_JOB, 'JB01', '주부', 'JB02', '은행원', 'JB03', '공무원', 'JB04', '축산업', 'JB05', '회사원', 'JB06', '농업', 'JB07', '자영업', 'JB08', '학생', 'JB09', '교사', '알 수 없음') AS MEM_JOB				");
			sb.append("    , DECODE(MEM_HOBBY, 'HB01', '서예', 'HB02', '장기', 'HB03', '수영', 'HB04', '독서', 'HB05', '당구', 'HB06', '바둑', 'HB07', '볼링', 'HB08', '스키', 'HB09', '만화', 'HB10', '낚시', 'HB11', '영화감상', 'HB12', '등산', 'HB13', '개그', 'HB14', '카레이싱', '알 수 없음') AS MEM_HOBBY   					  			");
			sb.append("    , mem_mileage   , mem_del_yn								");
			sb.append(" FROM																");
			sb.append("    member														");
			sb.append(" ORDER BY REGEXP_REPLACE(mem_id, '[0-9]') , to_number(REGEXP_REPLACE(mem_id, '[^0-9]')) ");
			
			pstmt=conn.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			
			List<MemberVO> MemberList = new ArrayList<>();
			while(rs.next()){
				MemberVO member = new MemberVO();
				member.setMemId(rs.getString("mem_id"));
				member.setMemPass(rs.getString("mem_pass"));
				member.setMemName(rs.getString("mem_name"));
				member.setMemBir(rs.getString("mem_bir"));
				member.setMemZip(rs.getString("mem_zip"));
				member.setMemAdd1(rs.getString("mem_add1"));
				member.setMemAdd2(rs.getString("mem_add2"));
				member.setMemHp(rs.getString("mem_hp"));
				member.setMemMail(rs.getString("mem_mail"));
				member.setMemJob(rs.getString("mem_job"));
				member.setMemHobby(rs.getString("mem_hobby"));
				member.setMemMileage(rs.getInt("mem_mileage"));
				member.setMemDelYn(rs.getString("mem_del_yn"));
				MemberList.add(member);
			}
			return MemberList;
				
		}catch(SQLException e){
			throw new DaoException("getMemberList : " + e.getMessage());
		}finally{
			// 연결종료
			if(rs !=null) {try{ rs.close();}catch(Exception e){}}
			if(pstmt !=null) {try{ pstmt.close();}catch(Exception e){}}
			if(conn !=null) {try{ conn.close();}catch(Exception e){}}
		}
	}

	@Override
	public MemberVO getMember(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb = new StringBuffer();
			
			sb.append(" SELECT											");
			sb.append("     mem_id  , mem_pass  , mem_name			");
			sb.append("     , mem_bir   , mem_zip   , mem_add1		");
			sb.append("     , mem_add2  , mem_hp    , mem_mail		");
			sb.append("     , mem_job   , mem_hobby , mem_mileage	");
			sb.append("     , mem_del_yn								");
			sb.append(" FROM												");
			sb.append("     member										");
			sb.append(" WHERE mem_id= ?									");
			
			pstmt=conn.prepareStatement(sb.toString());
			
			int idx = 1;
			pstmt.setString(idx++, memId);
			rs = pstmt.executeQuery();
			
			// rs가 1줄
			if(rs.next()){
				MemberVO member = new MemberVO();
				
				member.setMemId(rs.getString("mem_id"));
				member.setMemPass(rs.getString("mem_pass"));
				member.setMemName(rs.getString("mem_name"));
				member.setMemBir(rs.getString("mem_bir"));
				member.setMemZip(rs.getString("mem_zip"));
				member.setMemAdd1(rs.getString("mem_add1"));
				member.setMemAdd2(rs.getString("mem_add2"));
				member.setMemHp(rs.getString("mem_hp"));
				member.setMemMail(rs.getString("mem_mail"));
				member.setMemJob(rs.getString("mem_job"));
				member.setMemHobby(rs.getString("mem_hobby"));
				member.setMemMileage(rs.getInt("mem_mileage"));
				member.setMemDelYn(rs.getString("mem_del_yn"));
				
				return member;
			}
		}catch(SQLException e){
			throw new DaoException("getMember : " + e.getMessage());
		}finally{
			// 연결종료
			if(rs !=null) {try{ rs.close();}catch(Exception e){}}
			if(pstmt !=null) {try{ pstmt.close();}catch(Exception e){}}
			if(conn !=null) {try{ conn.close();}catch(Exception e){}}
		}
		return null;
	}

	@Override
	public int updateMember(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb = new StringBuffer();
			
			sb.append(" UPDATE member	 				");
			sb.append(" SET 								");
			sb.append("		 mem_pass = ?				");
			sb.append("		 ,mem_name = ?			");
			sb.append("		 ,mem_zip = ?				");
			sb.append("		 ,mem_add1 = ?			");
			sb.append("		 ,mem_add2 = ?			");
			sb.append("		 ,mem_bir = ?				");
			sb.append("		 ,mem_mail = ?			");
			sb.append("		 ,mem_hp = ?				");
			sb.append("		 ,mem_job = ?				");
			sb.append("		 ,mem_hobby = ?			");
			sb.append(" WHERE mem_id = ?				");
			
			pstmt = conn.prepareStatement(sb.toString());
			int idx = 1;
			pstmt.setString(idx++, member.getMemPass());
			pstmt.setString(idx++, member.getMemName());
			pstmt.setString(idx++, member.getMemZip());
			pstmt.setString(idx++, member.getMemAdd1());
			pstmt.setString(idx++, member.getMemAdd2());
			pstmt.setString(idx++, member.getMemBir());
			pstmt.setString(idx++, member.getMemMail());
			pstmt.setString(idx++, member.getMemHp());
			pstmt.setString(idx++, member.getMemJob());
			pstmt.setString(idx++, member.getMemHobby());
			pstmt.setString(idx++, member.getMemId());
			
			int cnt = pstmt.executeUpdate();
			return cnt;
			
		}catch (SQLException e){
			throw new DaoException("updateMember : "+ e.getMessage());
		}finally{
			if(rs !=null) {try{ rs.close();}catch(Exception e){}}
			if(pstmt !=null) {try{ pstmt.close();}catch(Exception e){}}
			if(conn !=null) {try{ conn.close();}catch(Exception e){}}
		}
	}

	@Override
	public int deleteMember(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb = new StringBuffer();
			
			sb.append(" UPDATE member	 				");
			sb.append(" SET 								");
			sb.append("		 mem_del_yn = 'Y'			");
			sb.append(" WHERE mem_id = ?				");
			
			pstmt = conn.prepareStatement(sb.toString());
			int idx = 1;
			pstmt.setString(idx++, member.getMemId());
			
			int cnt = pstmt.executeUpdate();
			return cnt;
		}catch (SQLException e){
			throw new DaoException("deleteMember: " + e.getMessage());
		}finally{
			if(rs !=null) {try{ rs.close();}catch(Exception e){}}
			if(pstmt !=null) {try{ pstmt.close();}catch(Exception e){}}
			if(conn !=null) {try{ conn.close();}catch(Exception e){}}
		}
	}

	@Override
	public int insertMember(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb = new StringBuffer();
			
			sb.append(" INSERT INTO member (							");
			sb.append("	    mem_id      ,mem_pass   ,mem_name		");
			sb.append("	  , mem_bir     ,mem_zip    ,mem_add1		");
			sb.append("	  , mem_add2    ,mem_hp     ,mem_mail		");
			sb.append("	  , mem_job     ,mem_hobby  ,mem_mileage	");
			sb.append("	  , mem_del_yn								");
			sb.append("	    ) VALUES (								");
			sb.append("	     		   ?		   ,?					");
			sb.append("	            , ?         ,?       ,?		");
			sb.append("	            , ?         ,?       ,?		");
			sb.append("	            , ?         ,?       ,?		");
			sb.append("	            , 0         ,'N'				");
			sb.append("	    )											");
			
			pstmt = conn.prepareStatement(sb.toString());
			int idx = 1;
			pstmt.setString(idx++, member.getMemId());
			pstmt.setString(idx++, member.getMemPass());
			pstmt.setString(idx++, member.getMemName());
			pstmt.setString(idx++, member.getMemBir());
			pstmt.setString(idx++, member.getMemZip());
			pstmt.setString(idx++, member.getMemAdd1());
			pstmt.setString(idx++, member.getMemAdd2());
			pstmt.setString(idx++, member.getMemHp());
			pstmt.setString(idx++, member.getMemMail());
			pstmt.setString(idx++, member.getMemJob());
			pstmt.setString(idx++, member.getMemHobby());
			int cnt = pstmt.executeUpdate();
			return cnt;
			
			
		}catch (SQLException e){
			throw new DaoException("insertMember : " + e.getMessage());
		}finally{
			if(rs !=null) {try{ rs.close();}catch(Exception e){}}
			if(pstmt !=null) {try{ pstmt.close();}catch(Exception e){}}
			if(conn !=null) {try{ conn.close();}catch(Exception e){}}
		}
	}
	
	

}
