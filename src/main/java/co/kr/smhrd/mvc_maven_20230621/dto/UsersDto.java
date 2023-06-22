package co.kr.smhrd.mvc_maven_20230621.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/*
* 팩토리 메서드 패턴 dto, vo
* PlanOloJavaObject(POJO) : 자바에서 옛날 부터 사용하던 디자인 패턴이다.
* boolean 은 is로 함수 이름을 정의
* ** jdbc 패키지 에서 Date 객체를 제공하고 있는데 많은 개발자들이 사용하지 않는다!
* */
@Getter@Setter@ToString //롬복 컴파일시 자동완성
public class UsersDto {

    private String uId;
    //u_id : db는 대소문자 구분을 하지 않아서 _ 규칙
    //자바에서 변수는 낙타표기법
    private String name;
    private String pw;
    private java.util.Date hireDate;
    private Date birth; //String 인 것을 권장!! (생일은 1970 이하가 있고 오라클에 date 객체는 문자열에 가깝다.)
    private String profilePath;
    private char gender;
    private String state;
    private boolean isPrivate; //oracle char(1) -> java boolean
}
