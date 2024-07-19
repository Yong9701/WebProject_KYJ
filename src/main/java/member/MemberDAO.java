package member;

import common.DBConnPool;
import common.JDBConnect;
import jakarta.servlet.ServletContext;

/*
DAT(Data Access Object)
: 실제 데이터베이스에 접근하여 기본적인 CRUD 작업을 하기위한 객체이다.
DB접속 및 select와 같은 쿼리문을 실행한 후 결과를 반환받는 기능을
수행한다.
*/

// JDBC를 위한 클래스를 상속하여 DB에 연결한다.
public class MemberDAO extends DBConnPool {

    // 생성자 1 : 드라이버, 커넥션URL 등 4개의 매개변수로 정의
    public MemberDAO(String drv, String url, String id, String pw) {
        super();
    }

    public MemberDAO() {
        super();
    }

    /*
     * 사용자가 입력한 아이디, 패스워드를 통해 회원테이블을 select한 후
     * 존재하는 회원정보인 경우 DTO객체에 레코드를 저장한 후 반환한다.
     */
    public MemberDTO getMemberDTO(String uid, String upass) {
        // 회원인증을 위한 쿼리문을 실행 후 회원정보를 저장하기 위한 인스턴스
        MemberDTO dto = new MemberDTO();
        /*
         * 로그인 폼에서 입력한 아이디, 패스워드를 통해 인파라미터를
         * 설정할 수 있도록 쿼리문을 작성
         */
        String query = "SELECT * FROM member WHERE id=? AND pass=?";

        try {
            // 쿼리문 실행을 위한 prepared 인스턴스 생성
            psmt = con.prepareStatement(query);
            // 쿼리문의 인파라미터 설정(아이디와 비번)
            psmt.setString(1, uid);
            psmt.setString(2, upass);
            // 쿼리문 실행 후 결과는 ResultSet으로 반환받는다.
            rs = psmt.executeQuery();
            // 반환된 ResultSet객체에 정보가 저장되어 있는지 확인한다.
            if (rs.next()) {
                // 회원정보가 있다면 DTO객체에 저장한다.
                dto.setId(rs.getString("id"));
                dto.setPass(rs.getString("pass"));
                dto.setName(rs.getString(3));
                dto.setEmail(rs.getString(4));
                dto.setTel(rs.getString(5));
                dto.setRegidate(rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 회원정보를 저장한 DTO 객체를 반환한다.
        return dto;
    }
    
    public int insertMember(MemberDTO dto) {
    	int result = 0;
    	try {
    		String query = "INSERT INTO member ( "
    				+ " id, pass, name, email, tel, regidate) "
    				+ " VALUES ( "
    				+ " ?,?,?,?,?, sysdate)";
    		
    		psmt = con.prepareStatement(query);
    		psmt.setString(1, dto.getId());
    		psmt.setString(2, dto.getPass());
    		psmt.setString(3, dto.getName());
    		psmt.setString(4, dto.getEmail());
    		psmt.setString(5, dto.getTel());
    		result = psmt.executeUpdate();
    	} catch (Exception e) {
    		System.out.println("회원가입 중 예외 발생");
    		e.printStackTrace();
    	}
    	return result;
    }
    
    public boolean ischeckId(String id) {
    	boolean isCorr = true;
    	try {
    		/*
    		 패스워드와 일련번호 두 가지 조건에 만족하는 게시물이 있는지 확인.
    		 게시물을 인출할 목적이 아니므로 count() 함수면 충분하다.
    		 */
    		String sql ="SELECT COUNT(*) FROM member WHERE id=?";
    		psmt = con.prepareStatement(sql);
    		psmt.setString(1, id);
    		rs = psmt.executeQuery();
    		// count() 함수는 항상 결과가 있으므로 조건문 없이 호출한다.
    		rs.next();
    		if(rs.getInt(1)==0) {
    			// 조건에 맞는 게시물이 없다면 false로 변경
    			isCorr = false;
    		}
    	}
    	catch (Exception e) {
    		// 예외가 발생하여 확인이 불가한 경우에도 false를 반환해야한다.
    		isCorr = false;
    		e.printStackTrace();
    	}
    	return isCorr;
    }
    
    public MemberDTO selectView(String id) {
    	MemberDTO dto = new MemberDTO();
    	// 인파라미터가 있는 select쿼리문 
    	String query = "SELECT * FROM member WHERE id=?";
    	try {
    		// 인파라미터 설정 및 쿼리실행
            psmt = con.prepareStatement(query);
            psmt.setString(1, id);
            rs = psmt.executeQuery();
            // 결과를 DTO에 저장
            if (rs.next()) {
                dto.setId(rs.getString(1));
                dto.setPass(rs.getString(2));
                dto.setName(rs.getString(3));
                dto.setEmail(rs.getString(4));
                dto.setTel(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("회원정보 불러오기 중 예외 발생");
            e.printStackTrace();
        }
    	return dto;
    }
    
    public int updateUser(MemberDTO dto) {
    	int result = 0;
    	try {
    		String query = "UPDATE member"
    				+ " SET pass=?, name=?, email=?, tel=? "
    				+ " WHERE id=?";
    		
    		psmt = con.prepareStatement(query);
    		psmt.setString(1, dto.getPass());
    		psmt.setString(2, dto.getName());
    		psmt.setString(3, dto.getEmail());
    		psmt.setString(4, dto.getTel());
    		psmt.setString(5, dto.getId());
    		
    		result = psmt.executeUpdate();
    	}
    	catch (Exception e) {
    		System.out.println("회원정보 수정 중 예외 발생");
    		e.printStackTrace();
    	}
		return result;
    }
}
