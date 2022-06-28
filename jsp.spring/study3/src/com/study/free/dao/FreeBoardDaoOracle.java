package com.study.free.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.study.common.vo.PagingVO;
import com.study.exception.DaoException;
import com.study.free.vo.FreeBoardSearchVO;
import com.study.free.vo.FreeBoardVO;

public class FreeBoardDaoOracle implements IFreeBoardDao{

	
	@Override
	public int getTotalRowCount(FreeBoardSearchVO searchVO) {
		//firstRow, lastRwo가 세팅된 pagingVO
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb = new StringBuffer();
			
			sb.append(" SELECT count(*)  		");
			sb.append(" FROM free_board  		");
			sb.append(" WHERE bo_del_yn = 'N'	");
			
			//if(searchVO.getSearchWord() !=null && !searchVO.getSearchWord().isEmpty())
			if(StringUtils.isNotBlank(searchVO.getSearchWord())) {
				// 검색어가 있을때만 해당
				switch (searchVO.getSearchType()) {
				case "T":
					sb.append(" AND bo_title LIKE '%' || ? || '%'");
					break;
				case "W":
					sb.append(" AND bo_writer LIKE '%' || ? || '%'");
					break;
				case "C":
					sb.append(" AND bo_content LIKE '%' || ? || '%'");
					break;
				}
				
			} // 검색어가 있을 때
			if(StringUtils.isNotBlank(searchVO.getSearchCategory())){
				sb.append(" AND bo_category = ? ");
			}//분류가 있을 때
			
			
			pstmt=conn.prepareStatement(sb.toString());
			
			int idx = 1;
			if(StringUtils.isNotBlank(searchVO.getSearchWord())) {
				pstmt.setString(idx++, searchVO.getSearchWord());
			}//검색어가 있을때
			
			if(StringUtils.isNotBlank(searchVO.getSearchCategory())) {
				pstmt.setString(idx++, searchVO.getSearchCategory());
			}//분류가 있을때
			
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
	public List<FreeBoardVO> getBoardList(FreeBoardSearchVO searchVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			//쿼리문 만들기 StringBuffer
			StringBuffer sb = new StringBuffer();
			
			sb.append(" SELECT * 															");
			sb.append(" FROM (																");
			
			sb.append(" SELECT a.*, ROWNUM as rnum   										");
			sb.append(" FROM (																");
			
			
			sb.append(" SELECT																");
			sb.append("      bo_no,        bo_title,     bo_category  					");
			sb.append("    , bo_writer, 	bo_pass,      bo_content    				");
			sb.append("    , bo_hit															");
			sb.append("    , to_char(bo_reg_date,'YYYY-MM-dd') AS bo_reg_date			");
			sb.append("    , to_char(bo_mod_date,'YYYY-MM-dd') AS bo_mod_date			");
			sb.append("    , bo_del_yn														");
			
			sb.append("	, b.comm_nm	AS bo_category_nm									");
			
			sb.append(" FROM	free_board a, comm_code b									");
			sb.append(" WHERE 1=1															");
			sb.append(" AND a.bo_category = b.comm_cd										");
			sb.append(" AND bo_del_yn = 'N'													");
			
			//if(searchVO.getSearchWord() !=null && !searchVO.getSearchWord().isEmpty())
			if(StringUtils.isNotBlank(searchVO.getSearchWord())) {
				// 검색어가 있을때만 해당
				switch (searchVO.getSearchType()) {
				case "T":
					sb.append(" AND bo_title LIKE '%' || ? || '%'");
					break;
				case "W":
					sb.append(" AND bo_writer LIKE '%' || ? || '%'");
					break;
				case "C":
					sb.append(" AND bo_content LIKE '%' || ? || '%'");
					break;
				}
			} // 검색어가 있을 때
			if(StringUtils.isNotBlank(searchVO.getSearchCategory())){
				sb.append(" AND bo_category = ? ");
			}//분류가 있을 때
			
			
			sb.append(" ORDER BY bo_no desc													");
			sb.append("	)	a																");
			sb.append("	)	b																");
			sb.append(" WHERE rnum between ? and ?											");
			
			pstmt=conn.prepareStatement(sb.toString());
			int idx = 1;
			
			if(StringUtils.isNotBlank(searchVO.getSearchWord())) {
				pstmt.setString(idx++, searchVO.getSearchWord());
			}//검색어가 있을때
			
			if(StringUtils.isNotBlank(searchVO.getSearchCategory())) {
				pstmt.setString(idx++, searchVO.getSearchCategory());
			}//분류가 있을때
			
			
			pstmt.setInt(idx++, searchVO.getFirstRow());
			pstmt.setInt(idx++, searchVO.getLastRow());
					
			rs = pstmt.executeQuery();
			
			List<FreeBoardVO> freeBoardList = new ArrayList<>();
			while(rs.next()){
				FreeBoardVO freeBoard = new FreeBoardVO();
				freeBoard.setBoNo(rs.getInt("bo_no"));
				freeBoard.setBoTitle(rs.getString("bo_title"));
				freeBoard.setBoCategory(rs.getString("bo_category"));
				freeBoard.setBoWriter(rs.getString("bo_writer"));
				freeBoard.setBoPass(rs.getString("bo_pass"));
				freeBoard.setBoContent(rs.getString("bo_content"));
				freeBoard.setBoHit(rs.getInt("bo_hit"));
				freeBoard.setBoRegDate(rs.getString("bo_reg_date"));
				freeBoard.setBoModDate(rs.getString("bo_mod_date"));
				freeBoard.setBoDelYn(rs.getString("bo_del_yn"));
				
				freeBoard.setBoCategoryNm(rs.getString("bo_category_nm"));
				freeBoardList.add(freeBoard);
			}
			return freeBoardList;
			
		}catch (SQLException e){
			// 1번. 아무것도 안함 -> 상사한테 불려감
			// 2번. //e.printStackTrace(); 콘솔에 찍히긴 하는데, 코드는 정상 실행?
			// 		SQLException났는데 정상 실행되면 안되지 않나?.. 원래는 파란색화면^~^
			// 3번. 예외 전환 -> 파란화면 까짓거 띄우면 되징
			//SQLException을 DaoException으로 바꿔서 던지자
			//throw를 해도 메소드가 끝남 (=return)
			throw new DaoException("getBoardList : " + e.getMessage());
			
		}finally{
			//종료
			if(rs !=null) {try{ rs.close();}catch(Exception e){}}
			if(pstmt !=null) {try{ pstmt.close();}catch(Exception e){}}
			if(conn !=null) {try{ conn.close();}catch(Exception e){}}
		}
	}

	@Override
	public FreeBoardVO getBoard(int boNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb = new StringBuffer();
			
			sb.append(" SELECT																");
			sb.append("      bo_no,        bo_title,     bo_category  					");
			sb.append("    , bo_writer, 	bo_pass,      bo_content    				");
			sb.append("    , bo_hit															");
			sb.append("    , to_char(bo_reg_date,'YYYY-MM-dd') AS bo_reg_date			");
			sb.append("    , to_char(bo_mod_date,'YYYY-MM-dd') AS bo_mod_date			");
			sb.append("    , bo_del_yn														");
			
			sb.append("	, b.comm_nm	AS bo_category_nm									");
			
			sb.append(" FROM	free_board a, comm_code b									");
			sb.append(" WHERE 1=1															");
			sb.append(" AND bo_no = ?														");
			sb.append(" AND a.bo_category = b.comm_cd										");
			
			pstmt=conn.prepareStatement(sb.toString());
			
			int idx = 1;
			pstmt.setInt(idx++, boNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				FreeBoardVO freeBoard = new FreeBoardVO();
				
				freeBoard.setBoNo(rs.getInt("bo_no"));
				freeBoard.setBoTitle(rs.getString("bo_title"));
				freeBoard.setBoCategory(rs.getString("bo_category"));
				freeBoard.setBoWriter(rs.getString("bo_writer"));
				freeBoard.setBoPass(rs.getString("bo_pass"));
				freeBoard.setBoContent(rs.getString("bo_content"));
				freeBoard.setBoHit(rs.getInt("bo_hit"));
				freeBoard.setBoRegDate(rs.getString("bo_reg_date"));
				freeBoard.setBoModDate(rs.getString("bo_mod_date"));
				freeBoard.setBoDelYn(rs.getString("bo_del_yn"));
				freeBoard.setBoCategoryNm(rs.getString("bo_category_nm"));
				return freeBoard;
			}
		}catch(SQLException e){
			throw new DaoException("getBoard : " + e.getMessage());
		}finally{
			if(rs !=null) {try{ rs.close();}catch(Exception e){}}
			if(pstmt !=null) {try{ pstmt.close();}catch(Exception e){}}
			if(conn !=null) {try{ conn.close();}catch(Exception e){}}
		}
		return null;
	}

	@Override
	public int increaseHit(int boNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb = new StringBuffer();
			sb.append(" UPDATE free_board SET   ");
			sb.append(" bo_hit = bo_hit+1   	 ");
			sb.append(" WHERE bo_no = ?		   	 ");
			
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setInt(1, boNo);
			int cnt = pstmt.executeUpdate();
			return cnt;
			
		}catch (SQLException e){
			throw new DaoException("increaseHit: " + e.getMessage());
		}finally {
			if(rs !=null) {try{ rs.close();}catch(Exception e){}}
			if(pstmt !=null) {try{ pstmt.close();}catch(Exception e){}}
			if(conn !=null) {try{ conn.close();}catch(Exception e){}}
		}
	}

	@Override
	public int updateBoard(FreeBoardVO freeBoard) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb = new StringBuffer();
			
			sb.append(" UPDATE free_board 				");
			sb.append(" SET 								");
			sb.append("		 bo_title = ?				");
			sb.append("		,bo_category = ?			");
			sb.append("		,bo_content = ?			");
			sb.append("		,bo_mod_date=sysdate		");
			sb.append(" WHERE bo_no = ?					");
			pstmt = conn.prepareStatement(sb.toString());
			int idx = 1;
			pstmt.setString(idx++, freeBoard.getBoTitle());
			pstmt.setString(idx++, freeBoard.getBoCategory());
			pstmt.setString(idx++, freeBoard.getBoContent());
			pstmt.setInt(idx++, freeBoard.getBoNo());
			
			int cnt = pstmt.executeUpdate(); // update이지만 update, delete, insert 다 가능
			return cnt;
			
			
		}catch (SQLException e){
			throw new DaoException("updateBoard : "+ e.getMessage());
		}finally{
			if(rs !=null) {try{ rs.close();}catch(Exception e){}}
			if(pstmt !=null) {try{ pstmt.close();}catch(Exception e){}}
			if(conn !=null) {try{ conn.close();}catch(Exception e){}}
		}
	}
	

	@Override
	public int deleteBoard(FreeBoardVO freeBoard) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb = new StringBuffer();
			
			sb.append(" UPDATE free_board 				");
			sb.append(" SET 								");
			sb.append("		 bo_del_yn = 'Y'			");
			sb.append(" WHERE bo_no = ?					");
			
			pstmt = conn.prepareStatement(sb.toString());
			
			int idx = 1;
			pstmt.setInt(idx++, freeBoard.getBoNo());
			
			// int리턴이랑 cnt가 의미하는건 db에서 업데이트했을때 ~행이 업데이트되었다
			// ~는 숫자라서
			int cnt = pstmt.executeUpdate(); // update이지만 update, delete, insert 다 가능
			return cnt;
		}catch (SQLException e){
			throw new DaoException("deleteBoard: " + e.getMessage());
		}finally{
			if(rs !=null) {try{ rs.close();}catch(Exception e){}}
			if(pstmt !=null) {try{ pstmt.close();}catch(Exception e){}}
			if(conn !=null) {try{ conn.close();}catch(Exception e){}}
		}
		
	}

	@Override
	public int insertBoard(FreeBoardVO freeBoard) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb = new StringBuffer();
			
			sb.append(" INSERT INTO free_board (									");
			sb.append("	     bo_no    	,bo_title  	    ,bo_category		");
			sb.append("	   , bo_writer 	,bo_pass 		    ,bo_content		");
			sb.append("	   , bo_hit   	,bo_reg_date		 ,bo_mod_date		");
			sb.append("	   , bo_del_yn											");
			sb.append("	   ) VALUES (												");
			sb.append("  		seq_free_board.nextval, 		? 	 ,		?			");
			sb.append("      , ?   	       ,?     	 	     ,   	?			");
			sb.append("      , 0            ,sysdate 			 ,		null		");
			sb.append("      ,'N'													");
			sb.append("	   )														");
			
			
			pstmt = conn.prepareStatement(sb.toString());
			int idx = 1;
			pstmt.setString(idx++, freeBoard.getBoTitle());
			pstmt.setString(idx++, freeBoard.getBoCategory());
			pstmt.setString(idx++, freeBoard.getBoWriter());
			pstmt.setString(idx++, freeBoard.getBoPass());
			pstmt.setString(idx++, freeBoard.getBoContent());
			int cnt = pstmt.executeUpdate();
			return cnt;
			
		}catch (SQLException e){
			throw new DaoException("insertBoard : " + e.getMessage());
		}finally{
			if(rs !=null) {try{ rs.close();}catch(Exception e){}}
			if(pstmt !=null) {try{ pstmt.close();}catch(Exception e){}}
			if(conn !=null) {try{ conn.close();}catch(Exception e){}}
		}
	}


}
