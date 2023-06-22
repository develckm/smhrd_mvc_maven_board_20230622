<%@ page import="co.kr.smhrd.mvc_maven_20230621.dto.UsersDto" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Maven MVC 좋아요 게시판</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/webjars/bootstrap/5.3.0/dist/css/bootstrap.min.css">
    <script src="<%=request.getContextPath()%>/webjars/bootstrap/5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">Features</a>
                </li>
            </ul>
            <%//jsp 동적리소스
                Object loginUserObj=session.getAttribute("loginUser"); //Object
                if(loginUserObj!=null){


                    UsersDto loginUser=(UsersDto) loginUserObj;
            %>
            <div>
                <%=loginUser.getName()%> 님 로그인
            </div>
            <%}%>
        </div>
    </div>
</nav>
    <h1 class="h1">Maven MㅕVC 좋아요 게시판</h1>
    <h2>MVC 게시판 목록</h2>
    <ul>
        <li><a href="./user/login.do">로그인 페이지</a></li>
        <li><a href=""></a></li>
        <li><a href=""></a></li>
    </ul>


    <h2>인텔리제이 사용법</h2>
    <ul>
        <li>워크스페이스를 자동 저장한다 (저장버튼을 누르면 더 빠르게 저장 후 반영)</li>
        <li>**프로젝트를 1개만 실행하는 것을 권장한다.</li>
        <li>대부분의 인코딩이 utf-8로 되어 있다.</li>
        <li>서버는 동적리소스(서블릿)의 자동저장을 반영하지 않는다.
            (코드를 작성할때마다 매번 배포해야하기 때문에 자동배포가 아니라 직접 배포를 권장)</li>
    </ul>
</body>
</html>