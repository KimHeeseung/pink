package com.githrd.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.githrd.test.dao.AjaxDao;
import com.githrd.test.dao.AvatarDao;
import com.githrd.test.vo.AvatarVO;
import com.githrd.whistle.vo.MemberVO;

@WebServlet("/test/myInfo.pink")
public class MyInfo extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sno = req.getParameter("mno");
		int mno = Integer.parseInt(sno);
		// 2. 데이터베이스 작업해서 결과 받고
		AjaxDao aDao = new AjaxDao();
		MemberVO mVO = aDao.getMnoInfo(mno);
		// 3. 응답 문서 만들고(ano, savename, dir, gen)
		PrintWriter pw = resp.getWriter(); // 응답 문서 도구 가져오고...
		
		pw.print(mVO.getJson());
}
}