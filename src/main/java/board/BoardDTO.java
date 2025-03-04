package board;

// board 테이블의 레코드를 저장하기 위한 DTO 클래스
public class BoardDTO {
	// 멤버변수
	private String idx;
	private String name;
	private String title;
	private String content;
	private java.sql.Date postdate; // 날짜타입이므로 Date형
	private String ofile;
	private String sfile;
	private int visitcount; // 조회수 int형
	private int likeboard;
	
	// 생성자는 정의하지 않아도 됨.
	
	// getter / setter 메서드
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public java.sql.Date getPostdate() {
		return postdate;
	}
	public void setPostdate(java.sql.Date postdate) {
		this.postdate = postdate;
	}
	public String getOfile() {
		return ofile;
	}
	public void setOfile(String ofile) {
		this.ofile = ofile;
	}
	public String getSfile() {
		return sfile;
	}
	public void setSfile(String sfile) {
		this.sfile = sfile;
	}
	public int getVisitcount() {
		return visitcount;
	}
	public void setVisitcount(int visitcount) {
		this.visitcount = visitcount;
	}
	public int getLikeboard() {
		return likeboard;
	}
	public void setLikeboard(int likeboard) {
		this.likeboard = likeboard;
	}
	
}
