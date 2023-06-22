package co.kr.smhrd.mvc_maven_20230621.model.service;

import co.kr.smhrd.mvc_maven_20230621.dto.UsersDto;

public interface UsersService {
    /*로그인, 개인정보 조회, 개인정보수정, 회원가입,탈퇴, 회원조회리스트(팔로우)*/
    //* dao 쿼리 실행단위
    //* service 유저에게 제공되는 서비스의 단위 (==transaction)
    //은행 업무
    //계좌이체 (서비스)
    //내계좌의 돈을 업데이트 (dao)
    //은행에 계좌이체 내역 저장 (dao)
    //받는 사람의 계좌의 돈을 업데이트 (dao)

    //webapp 을 만들다 보면 (dao : service = 1:1) 대부분 1:1
    //하지만 아닌것들도 존재해서 꼭 서비스를 만든다.
    //게시판 상세내역 ->게시판내역조회, 게시판의 조회수 업데이트
    UsersDto login(String uId,String pw);
    UsersDto detail(String uId);
    int modify(UsersDto user);
    int signup(UsersDto user);
    int remove(String uId,String pw);
}
