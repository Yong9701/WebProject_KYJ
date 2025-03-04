package utils;

public class BoardPage {
	
	// List.jsp에서 전달해준 인수를 매개변수를 통해 받는다/
    public static String pagingStr(int totalCount, int pageSize, int blockPage,
            int pageNum, String reqUrl) {
    	
    	// 페이지 바로가기 링크를 저장할 문자열 변수
        String pagingStr = "";
        
        // 전체 페이지수를 계산
        int totalPage = (int) (Math.ceil(((double) totalCount / pageSize)));
        
        /*
         * 현재 페이지 블럭에서 사용할 첫번째 페이지번호를 계산한다.
         * 한블럭당 출력할 페이지 번호의 갯수는 현재 5로 설정됨.
         * 	현재 1페이지 가정하면
         * 		(((1 - 1) / 5) * 5) + 1 = 1
         * 	현재 4페이지라 가정하면
         * 		(((4 - 1) / 5) * 5) + 1 = 1
         * 		=> 즉 1~5페이지인 경우에는 해당 블럭의 첫페이지는 1이다.
         * 	현재 6페이지라 가정하면
         * 		(((6 - 1) / 5) * 5) + 1 = 6
         * 		=> 즉 6~10페이지인 경우에는 해당 블럭의 첫페이지는 6이다.
         */
        int pageTemp = (((pageNum - 1) / blockPage) * blockPage) + 1;
        
        /*
         * pageTemp가 1이 아닐때만, 즉 첫번째 블록이 아닌 경우에만
         * 이전 블록 바로가기 링크를 화면에 출력한다.
         */
        if (pageTemp != 1) {
            pagingStr += "<a class='page_btn first' href='" + reqUrl + "?pageNum=1'></a>";
            pagingStr += "&nbsp;";
            pagingStr += "<a class='page_btn prev' href='" + reqUrl + "?pageNum=" + (pageTemp - 1)
                    + "'></a>";
        }
        
        /*
         * 각 페이지 번호로 바로가기 링크 출력
         * 앞에서 계산한 pageTemp를 blockPage만큼 반복해서 출력한다.
         * 이때 1씩 증가시켜준다. 즉 한 블록당 5페이지를 출력하게 된다.
         */
        int blockCount = 1;
        while (blockCount <= blockPage && pageTemp <= totalPage) {
            if (pageTemp == pageNum) {
            	// 만약 현재페이지라면 링크를 걸지 않는다.
                pagingStr += "<p class='num active'>" + pageTemp + "</p>";
            } else {
            	// 현재페이지가 아닌 경우에만 링크를 추가한다.
                pagingStr += "<a class='num' href='" + reqUrl + "?pageNum=" + pageTemp
                        + "'>" + pageTemp + "</a>";
            }
            //반복하면서 1씩 증가시켜 순차적인 페이지번호를 출력한다.
            pageTemp++;
            blockCount++;
        }
        /*
         * 다음 페이지 블록 바로가기 링크 추가
         * 마지막 페이지가 아닌 경우에만 다음 블럭 링크를 출력한다.
         */
        if (pageTemp <= totalPage) {
            pagingStr += "<a class='page_btn next' href='" + reqUrl + "?pageNum=" + pageTemp
                    + "'></a>";
            pagingStr += "&nbsp;";
            pagingStr += "<a class='page_btn last' href='" + reqUrl + "?pageNum=" + totalPage
                    + "'></a>";
        }

        return pagingStr;
    }
}
