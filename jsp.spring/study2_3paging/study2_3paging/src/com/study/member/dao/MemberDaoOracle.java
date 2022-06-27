package com.study.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.study.exception.DaoException;
import com.study.free.vo.FreeBoardSearchVO;
import com.study.member.vo.MemberSearchVO;
import com.study.member.vo.MemberVO;

public class MemberDaoOracle implements IMemberDao{
	
	@Override
	public int getTotalRowCount(MemberSearchVO searchVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb = new StringBuffer();
			
			sb.append(" SELECT count(*)  		");
			sb.append(" FROM member		  		");
			sb.append(" WHERE mem_del_yn = 'N'	");
			
			if(StringUtils.isNotBlank(searchVO.getSearchWord())) {
				// 검색어가 있을때만 해당
				switch (searchVO.getSearchType()) {
				case "NM":
					sb.append(" AND mem_name LIKE '%' || ? || '%'");
					break;
				case "ID":
					sb.append(" AND mem_id LIKE '%' || ? || '%'");
					break;
				case "HP":
					sb.append(" AND mem_hp LIKE '%' || ? || '%'");
					break;
				}
			} // 검색어가 있을 때
			
			if(StringUtils.isNotBlank(searchVO.getSearchJob())){
				sb.append(" AND mem_job = ? ");
			}//직업
			
			if(StringUtils.isNotBlank(searchVO.getSearchHobby())){
				sb.append(" AND mem_hobby = ? ");
			}//취미
			
			
			pstmt=conn.prepareStatement(sb.toString());
			
			int idx = 1;
			if(StringUtils.isNotBlank(searchVO.getSearchWord())) {
				pstmt.setString(idx++, searchVO.getSearchWord());
			}//검색어가 있을때
			
			if(StringUtils.isNotBlank(searchVO.getSearchJob())) {
				pstmt.setString(idx++, searchVO.getSearchJob());
			}//직업
			
			if(StringUtils.isNotBlank(searchVO.getSearchHobby())) {
				pstmt.setString(idx++, searchVO.getSearchHobby());
			}//취미
			
			rs = pstmt.executeQuery();
			
			int count = 0;
			if(rs.next()) {
				//count=rs.getInt("count(*)");
				count=rs.getInt(1);
			}
			return count;
		} catch(SQLException e){
			throw new DaoException("getTotalRowCount : " + e.getMessage());
		} finally {
			if(rs !=null) {try{ rs.close();}catch(Exception e){}}
			if(pstmt !=null) {try{ pstmt.close();}catch(Exception e){}}
			if(conn !=null) {try{ conn.close();}catch(Exception e){}}
		}
	}

	@Override
	public List<MemberVO> getMemberList(MemberSearchVO searchVO) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");

			StringBuffer sb = new StringBuffer();
			
			sb.append(" SELECT * 															");
			sb.append(" FROM (																");
			
			sb.append(" SELECT a.*, ROWNUM as rnum   										");
			sb.append(" FROM (																");
			
			sb.append(" SELECT																");
			sb.append("    mem_id														");
			sb.append("    , mem_pass      , mem_name									");
			sb.append("	 , TO_CHAR(mem_bir,'YYYY-MM-dd') AS mem_bir				");
			sb.append("    , mem_zip       , mem_add1      , mem_add2				");
			sb.append("    , mem_hp        , mem_mail      							");
			sb.append("    , mem_job														");
			sb.append("    , mem_hobby   					  							");
			sb.append("    , mem_mileage   , mem_del_yn								");
			
			sb.append("	 , b.comm_nm	AS mem_job_nm							");
			sb.append("	 , c.comm_nm	AS mem_hobby_nm							");
			
			sb.append(" FROM	member a, comm_code b, comm_code c						");
			sb.append(" WHERE 1=1														");
			sb.append(" AND a.mem_job = b.comm_cd 										");
			sb.append(" AND a.mem_hobby = c.comm_cd 										");
			
			if(StringUtils.isNotBlank(searchVO.getSearchWord())) {
				// 검색어가 있을때만 해당
				switch (searchVO.getSearchType()) {
				case "NM":
					sb.append(" AND mem_name LIKE '%' || ? || '%'");
					break;
				case "ID":
					sb.append(" AND mem_id LIKE '%' || ? || '%'");
					break;
				case "HP":
					sb.append(" AND mem_hp LIKE '%' || ? || '%'");
					break;
				}
			} // 검색어가 있을 때
			
			if(StringUtils.isNotBlank(searchVO.getSearchJob())){
				sb.append(" AND mem_job = ? ");
			}//직업
			
			if(StringUtils.isNotBlank(searchVO.getSearchHobby())){
				sb.append(" AND mem_hobby = ? ");
			}//취
			
			
			sb.append(" ORDER BY mem_id desc												");
			sb.append("	)	a																");
			sb.append("	)	b																");
			sb.append(" WHERE rnum between ? and ?											");
			
			pstmt=conn.prepareStatement(sb.toString());
			
			int idx = 1;
			
			if(StringUtils.isNotBlank(searchVO.getSearchWord())) {
				pstmt.setString(idx++, searchVO.getSearchWord());
			}//검색어가 있을때
			
			if(StringUtils.isNotBlank(searchVO.getSearchJob())) {
				pstmt.setString(idx++, searchVO.getSearchJob());
			}//직업
			
			if(StringUtils.isNotBlank(searchVO.getSearchHobby())) {
				pstmt.setString(idx++, searchVO.getSearchHobby());
			}//취미
			
			
			pstmt.setInt(idx++, searchVO.getFirstRow());
			pstmt.setInt(idx++, searchVO.getLastRow());
			
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
				
				member.setMemJobNm(rs.getString("mem_job_nm"));
				member.setMemHobbyNm(rs.getString("mem_hobby_nm"));
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
			
			sb.append("	 , b.comm_nm	AS mem_job_nm			");
			sb.append("	 , c.comm_nm	AS mem_hobby_nm			");
			
			sb.append(" FROM	member a, comm_code b, comm_code c					");
			sb.append(" WHERE 1=1										");
			sb.append(" AND mem_id = ?									");
			sb.append(" AND a.mem_job = b.comm_cd 						");
			sb.append(" AND a.mem_hobby = c.comm_cd 						");
			
			
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
				
				member.setMemJobNm(rs.getString("mem_job_nm"));
				member.setMemHobbyNm(rs.getString("mem_hobby_nm"));
				
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
