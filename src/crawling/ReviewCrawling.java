package crawling;

	import java.io.IOException;
	import java.util.Iterator;

	import org.jsoup.Jsoup;
	import org.jsoup.nodes.Document;
	import org.jsoup.nodes.Element;
	import org.jsoup.select.Elements;

	// 해당 페이지 html코드 (f12), 파이썬 띄워서 비교하면서 설명

	// jsoup 은 실제 HTML 작업을 위한 Java 라이브러리입니다. HTML5 DOM 메서드와 CSS 선택기를 사용하여 URL을 가져오고 데이터를 추출하고 조작하기 위한 매우 편리한 API를 제공합니다.

	public class ReviewCrawling {
	        public static void main(String[] args) {
	            String url = "https://movie.naver.com/movie/bi/mi/review.naver?code=198413"; // 리뷰 페이지 url
	            Document doc;

	            try { // connect에서 잘못된 url로 오류가 발생할 수 있으니 try사용
	                doc = Jsoup.connect(url).get(); // 해당 url에서 html전체 구조를 가져옴
	                Elements elements = doc.select("ul.rvw_list_area");    // doc.select를 통해 원하는 부분 <ul class="rvw_list_area"> 만 선택해서 elements변수에 저장
	                Iterator<Element> lis = elements.select("strong").iterator(); // 리뷰부분만 뽑아서 저장한 elements에서 <strong>으로 감싸져있는 제목 부분만 lis변수에 저장

	                int i =0;
	                while(lis.hasNext()) { // Iterator변수 lis에 값이 남아있을 때 까지 반복하며 리뷰의 제목 출력
	                    i++;
	                    System.out.println(i+". "+lis.next().text());

	                }
	                System.out.println(i + "개의 리뷰를 찾았습니다.");
	            } catch (IOException e) {
	                System.out.println("실행 오류");
	                e.printStackTrace();
	            }
	        }
	    } 
