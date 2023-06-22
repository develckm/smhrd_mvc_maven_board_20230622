package co.kr.smhrd.mvc_maven_20230621.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//싱글톤 패톤 : 객체를 하나 만들고 계속 제사용하는 디자인 패턴
public class DBConnection {
    private static Connection conn;
    private static String url="jdbc:oracle:thin:@localhost:1521:XE";
    private static String user="c##smart01";
    private static String password="oracle01";
    private static String driver="oracle.jdbc.driver.OracleDriver";

    public static Connection getInstance() throws Exception{
        if( conn==null || conn.isClosed()){
            Class.forName(driver);
            conn= DriverManager.getConnection(url,user,password);
        }
        return conn;
    }
}
