package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.DBConnPool;

// 커넥션풀을 통한 DB연결을 위해 클래스 상속
public class BoardDAO extends DBConnPool {
	
	// 디폴트 생성자(직접 정의하지 않아도 자동으로 삽입된다)
    public BoardDAO() {
        super();
    }

    // 게시물의 갯수를 카운트. 검색어가 있는 경우 where절을 동적으로 추가한다.
    public int selectCount(Map<String, Object> map) {

        int totalCount = 0;

        String query = "SELECT COUNT(*) FROM board";

        if (map.get("searchWord") != null) {
            query += " WHERE " + map.get("searchField") + " " +
                    " LIKE '%" + map.get("searchWord") + "%'";
        }

        try {
        	// 인파라미터가 없는 정적쿼리문을 실행하므로 Statement 인스턴스를 생성
            stmt = con.createStatement();
            // 쿼리문 실행 후 결과 반환
            rs = stmt.executeQuery(query);
            rs.next();
            totalCount = rs.getInt(1);
        } catch (Exception e) {
            System.out.println("게시물 수를 구하는 중 예외 발생");
            e.printStackTrace();
        }

        return totalCount;
    }

    // 목록에 출력할 게시물을 페이지 단위로 얻어오기 위한 메서드
    public List<BoardDTO> selectListPage(Map<String, Object> map) {

    	// board 테이블을 대상으로 하므로 타입매개변수 확인 필요함
        List<BoardDTO> board = new Vector<BoardDTO>();

        /*
         페이징 처리를 위한 서브쿼리문 작성. 게시물의 순차적인 일련번호를 부여하는
         rownum을 통해 게시물을 구간에 맞게 인출한다.
         */
        String query = " SELECT * FROM ( "
        		+ " SELECT Tb.*, ROWNUM rNum FROM ( "
        		+ " SELECT * FROM board ";
        
        if (map.get("searchWord") != null) {
            query += " WHERE " + map.get("searchField") + " " +
                    " LIKE '%" + map.get("searchWord") + "%'";
        }
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
                BoardDTO dto = new BoardDTO();

                dto.setIdx(rs.getString("idx"));
                dto.setName(rs.getString("name"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setPostdate(rs.getDate("postdate")); // 날짜이므로 getDate() 사용
                dto.setOfile(rs.getString("ofile"));
                dto.setSfile(rs.getString("sfile"));
                dto.setVisitcount(rs.getInt("visitcount")); // 숫자이므로 getInt() 사용
                dto.setLikeboard(rs.getInt("likeboard"));

                // List에 추가한다.
                board.add(dto);
            }
        } catch (Exception e) {
            System.out.println("게시물을 조회 중 예외 발생");
            e.printStackTrace();
        }

        return board;
    }
    // 글쓰기 페이지에서 전송한 폼값을 테이블에 insert
    public int insertWrite(BoardDTO dto) {
    	int result = 0;
    	try {
    		/*
    		 쿼리문에서 사용한 시퀀스는 모델1 게시판에서 생성한 것을 그대로
    		 사용한다. 나머지 값들은 컨트롤러에서 받은 후 모델(DAO)로 전달한다.
    		 */
    		String query = "INSERT INTO board ( "
    				+ " idx, name, title, content, ofile, sfile) "
    				+ " VALUES ( "
    				+ " seq_board_num.NEXTVAL,?,?,?,?,?)";
    		
    		psmt = con.prepareStatement(query);
    		psmt.setString(1, dto.getName());
    		psmt.setString(2, dto.getTitle());
    		psmt.setString(3, dto.getContent());
    		psmt.setString(4, dto.getOfile()); // 원본파일명
    		psmt.setString(5, dto.getSfile()); // 서버에 저장된 파일명
    		result = psmt.executeUpdate();
    	}
    	catch (Exception e) {
    		System.out.println("게시물 입력 중 예외 발생");
    		e.printStackTrace();
    	}
    	return result;
    }
    // 상세보기를 위해 일련번호에 해당하는 레코드 1개를 인출해서 반환
    public BoardDTO selectView(String idx) {
    	BoardDTO dto = new BoardDTO();
    	// 인파라미터가 있는 select쿼리문 
    	String query = "SELECT * FROM board WHERE idx=?";
    	try {
    		// 인파라미터 설정 및 쿼리실행
            psmt = con.prepareStatement(query);
            psmt.setString(1, idx);
            rs = psmt.executeQuery();
            // 결과를 DTO에 저장
            if (rs.next()) {
                dto.setIdx(rs.getString(1));
                dto.setName(rs.getString(2));
                dto.setTitle(rs.getString(3));
                dto.setContent(rs.getString(4));
                dto.setPostdate(rs.getDate(5)); // 날짜이므로 getDate() 사용
                dto.setOfile(rs.getString(6));
                dto.setSfile(rs.getString(7));
                dto.setVisitcount(rs.getInt(8)); // 숫자이므로 getInt() 사용
                dto.setLikeboard(rs.getInt(9));
            }
        } catch (Exception e) {
            System.out.println("게시물 상세보기 중 예외 발생");
            e.printStackTrace();
        }
    	return dto;
    }
    // 게시물의 조회수를 증가
    public void updateVisitCount(String idx) {
    	String query = "UPDATE board SET "
    			+ " visitcount=visitcount+1 "
    			+ " WHERE idx=?";
    	
    	try {
    		psmt = con.prepareStatement(query);
    		psmt.setString(1, idx);
    		psmt.executeQuery();
    	}
    	catch (Exception e) {
    		System.out.println("게시물 조회수 증가 중 예외 발생");
    		e.printStackTrace();
    	}
    }
    
    // 일련번호에 해당하는 게시물을 삭제
    public int deletePost(String idx) {
    	int result = 0;
    	try {
    		String query = "DELETE FROM board WHERE idx=?";
    		psmt = con.prepareStatement(query);
    		psmt.setString(1, idx);
    		result = psmt.executeUpdate();
    	}
    	catch (Exception e) {
    		System.out.println("게시물 삭제 중 예외 발생");
    		e.printStackTrace();
    	}
    	return result;
    }
    
    public int updatePost(BoardDTO dto) {
    	int result = 0;
    	try {
    		String query = "UPDATE board"
    				+ " SET title=?, content=?, ofile=?, sfile=? "
    				+ " WHERE idx=?";
    		
    		psmt = con.prepareStatement(query);
    		psmt.setString(1, dto.getTitle());
    		psmt.setString(2, dto.getContent());
    		psmt.setString(3, dto.getOfile());
    		psmt.setString(4, dto.getSfile());
    		psmt.setString(5, dto.getIdx());
    		
    		result = psmt.executeUpdate();
    	}
    	catch (Exception e) {
    		System.out.println("게시물 수정 중 예외 발생");
    		e.printStackTrace();
    	}
		return result;
    }
    
    public boolean updateLikeCount(String idx) {
        PreparedStatement pstmt = null;
        boolean success = false;
        try {
            String sql = "UPDATE board SET likeboard = likeboard + 1 WHERE idx = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, idx);
            int rows = pstmt.executeUpdate();
            success = (rows > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}