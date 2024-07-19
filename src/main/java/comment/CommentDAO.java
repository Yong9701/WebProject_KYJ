package comment;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.DBConnPool;

public class CommentDAO extends DBConnPool {

	public int selectCount(Map<String, Object> map) {

        int totalCount = 0;

        String query = "SELECT COUNT(*) FROM comm";

        try {
        	// 인파라미터가 없는 정적쿼리문을 실행하므로 Statement 인스턴스를 생성
            stmt = con.createStatement();
            // 쿼리문 실행 후 결과 반환
            rs = stmt.executeQuery(query);
            rs.next();
            totalCount = rs.getInt(1);
        } catch (Exception e) {
            System.out.println("댓글 수를 구하는 중 예외 발생");
            e.printStackTrace();
        }

        return totalCount;
    }
	
	public List<CommentDTO> selectListPage(Map<String, Object> map) {

    	// board 테이블을 대상으로 하므로 타입매개변수 확인 필요함
        List<CommentDTO> comm = new Vector<CommentDTO>();

        /*
         페이징 처리를 위한 서브쿼리문 작성. 게시물의 순차적인 일련번호를 부여하는
         rownum을 통해 게시물을 구간에 맞게 인출한다.
         */
        String query = " SELECT * FROM ( "
        		+ " SELECT Tb.*, ROWNUM rNum FROM ( "
        		+ " SELECT * FROM comm ";
        query += " ORDER BY idx DESC "
        		+ " ) Tb "
        		+ " ) "
        		+ " WHERE rNum BETWEEN ? AND ?";

        try {
        	// 인파라미터가 있는 동적쿼리문 실행
        	PreparedStatement psmt = con.prepareStatement(query);
            psmt.setString(1, map.get("start").toString());
            psmt.setString(2, map.get("end").toString());
            rs = psmt.executeQuery();
            while (rs.next()) {
                CommentDTO dto = new CommentDTO();

                dto.setIdx(rs.getString("idx"));
                dto.setBoardidx(rs.getString("boardidx"));
                dto.setName(rs.getString("name"));
                dto.setComm(rs.getString("comm"));
                dto.setPostdate(rs.getDate("postdate")); // 날짜이므로 getDate() 사용

                // List에 추가한다.
                comm.add(dto);
            }
        } catch (Exception e) {
            System.out.println("댓글을 조회 중 예외 발생");
            e.printStackTrace();
        }

        return comm;
    }
	
	public int insertWrite(CommentDTO dto) {
    	int result = 0;
    	try {
    		String query = "INSERT INTO comm ( "
    				+ " idx, boardidx, name, comm) "
    				+ " VALUES ( "
    				+ " seq_comm_num.NEXTVAL,?,?,?)";
    		
    		psmt = con.prepareStatement(query);
    		psmt.setString(1, dto.getBoardidx());
    		psmt.setString(2, dto.getName());
    		psmt.setString(3, dto.getComm());
    		result = psmt.executeUpdate();
    	}
    	catch (Exception e) {
    		System.out.println("댓글 입력 중 예외 발생");
    		e.printStackTrace();
    	}
    	return result;
    }
}
