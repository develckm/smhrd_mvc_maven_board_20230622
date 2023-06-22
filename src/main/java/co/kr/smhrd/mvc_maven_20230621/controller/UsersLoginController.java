package co.kr.smhrd.mvc_maven_20230621.controller;

import co.kr.smhrd.mvc_maven_20230621.dto.UsersDto;
import co.kr.smhrd.mvc_maven_20230621.model.service.UsersService;
import co.kr.smhrd.mvc_maven_20230621.model.service.UsersServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/user/login.do")
public class UsersLoginController extends HttpServlet {
    @Override //login form
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/templates/user/login.jsp").forward(req,resp);
    }

    @Override //login action (처리)
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uId=req.getParameter("uId");
        String pw=req.getParameter("pw");

        UsersDto loginUser=null;
        UsersService usersService=new UsersServiceImp();
        loginUser=usersService.login(uId,pw);

        if(loginUser==null){
            resp.sendRedirect("./login.do");
        }else{
            HttpSession session=req.getSession();
            session.setAttribute("loginUser",loginUser);
            //클라이언트 서버에 요청(접속)하면 세션 객체를 만들고 유지(30분)
            //다시(30분안에) 해당 클라이언트가 서버에 요청하면 동적리소스에 클라언트와 대응되는 센션 객체를 전달
            resp.sendRedirect(req.getContextPath()+"/"); //index
        }
        //동적리소스를 자동저장하면 서버가 매번 재시작해서 자동으로 재시작하지 않는다.
        //서비스에 톰캣을 누르면 모두배포를 누르면된다.
        //*http은 비연결성 통신이기 때문에 로그인 상태를 유지할 방법이 없다.
        //전화나 소켓 통신처럼 연결성 통신이 로그인 상태를 유지할 수 있다.
        //서버에 객체를 저장 유지한다.
        //로그인을 하면 서버에 로그인한 유저 객체를 저장하고 (session)
        //동적리소스에서 해당 객체가 있는지 물어보고 존재하면 로그인이 되어 있는것

    }
}
