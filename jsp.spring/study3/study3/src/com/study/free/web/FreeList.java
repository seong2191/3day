package com.study.free.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.study.code.service.CommCodeServiceImpl;
import com.study.code.service.ICommCodeService;
import com.study.code.vo.CodeVO;
import com.study.free.service.FreeBoardServiceImpl;
import com.study.free.service.IFreeBoardService;
import com.study.free.vo.FreeBoardSearchVO;
import com.study.free.vo.FreeBoardVO;
import com.study.servlet.Handler;


public class FreeList implements Handler{
	

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//원래 freeList에서 하던 코드 작성
		
		// <jsp:useBean id="searchVO" class="com.study.free.vo.FreeBoardSearchVO">
       // </jsp:useBean> <jsp:setPropertyproperty="*" name="searchVO" />
				 
		//파라미터들 전부 VO에 한번에 세팅해주는건데, 요거를 대신해주는 lib가 필요
		FreeBoardSearchVO searchVO = new FreeBoardSearchVO(); //값이 없는 searchVO
		
							//(vo	  , map<String, object>)
		BeanUtils.populate(searchVO, req.getParameterMap());
		//이후부터는 searchVO에 값이 세팅되어 있다.
		req.setAttribute("searchVO", searchVO);
		
		//34번, 37번은 같은 searchVO객체를 향하고 있는 것이기 때문에 순서가 서로 바뀌어도 같다.
		
		IFreeBoardService freeBoardService = new FreeBoardServiceImpl();
		List<FreeBoardVO> freeBoardList = freeBoardService.getBoardList(searchVO);
		req.setAttribute("freeBoardList", freeBoardList);
		
		ICommCodeService codeService = new CommCodeServiceImpl();
		List<CodeVO> cateList = codeService.getCodeListByParent("BC00");
		req.setAttribute("cateList", cateList);
		
		// 3번 viewName 반환
		return "free/freeList";
	}
	

	
	

}
