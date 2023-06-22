package co.kr.smhrd.mvc_maven_20230621.model.dao;

import co.kr.smhrd.mvc_maven_20230621.dto.UsersDto;

/*
* DAO Db Access Object
* 서비스할 내역의 상세로 쿼리단위로 정의
* 함수 이름을 쿼리와 유사하게 짓는 것이 유행(JPA : ORM 함수이름만 사용하면 쿼리 및 파싱을 자동 생성)
* find : select
* findByUId(String uId) : where u_id=?
* findByUIdAndPw : where u_id=? and pw=?
* insertOne(save) : 하나만 등록
* updateOne : pk로 하나 수정
* deleteOne : pk로 하나 삭제
* deleteByName(name) : delete From users where name=?
*
** 인터페이스를 정의하는 이유!
* 1. 셀계 : 팀장님이 부하직원들에 지시할때, 모듈설계
* 2. 하위(파생) 클래스가 많을 때 List -> ArrayList,LinkedList,Vector
* 3. 구현을 다른 라이브러리가 해줄때 : mybatis(파라미터 파싱),jpa(쿼리생성+파라미터 파싱)
*                                    UsersDaoImp를 자동으로 한다.
* */
public interface UsersDao {
    /*로그인, 개인정보 조회, 개인정보수정, 회원가입,탈퇴, 회원조회리스트(팔로우)*/
    UsersDto findByUIdAndPw(String uId,String pw) throws Exception;
    UsersDto findByUId(String uId) throws Exception;
    int updateOne(UsersDto user) throws Exception;
    int insertOne(UsersDto user) throws Exception;
    int deleteByUIdAndPw(String uId,String pw) throws Exception;
}
