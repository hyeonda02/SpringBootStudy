package hello.jdbc.repository;

import hello.jdbc.connection.DBConnectionUtil;
import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
/**
 * JDBC를 사용해서 회원 객체를 EB에 저장
 */
@Slf4j
public class MemberRepositoryV0 {
    public Member save(Member member) throws SQLException{
        String sql = "insert into member(member_id,money) values(?,?)";

        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getMemberId()); //파라미터 바인딩
            pstmt.setInt(2, member.getMoney()); //파라미터 바인딩
            pstmt.executeUpdate(); // 실행 쿼리가 실제 데이터 베이스에 실행된다.
            //참고로 숫자를 반환하는데, 영향을 받은 row의 수만큼 숫자로 반환해준다.
            return member;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null); //외부 리소스를 꼭 닫아줘야 한다.
        }
    }

    //리소스 정리 finally에서 해야됨 ( 항상 호출이 부장되도록.. ) 리소스 누수 발생 가능
    //리소스 정리는 항상 역순으로 해주어야 한다. ResultSet은 결과를 조회할떼 사용함
    private void close(Connection con, Statement pstmt, ResultSet rs) {
        //연 것과 반대 순서로 닫아주기
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
    }
    private Connection getConnection(){
        return DBConnectionUtil.getConnection();
    }

}
