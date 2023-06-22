package co.kr.smhrd.mvc_maven_20230621.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectionTest {
    //jnunit defatul 테스트 통과 : 오류가 발생하지 않으면
    @Test
    void getInstance() throws Exception {
        System.out.println(DBConnection.getInstance());
    }
}