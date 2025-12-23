package content;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import util.XmlMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import dto.MapWrapper;

@WebServlet("/XmlServlet")
public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setContentType("application/xml; charset=UTF-8");
		
		// 요청
		// XML --> Map
		BufferedReader reader = request.getReader();
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while( (line = reader.readLine() ) != null ) {
			stringBuilder.append(line);
		}
		String xml = stringBuilder.toString();
		Map<String, Object> map = null;
		try {
			map = XmlMapper.toMap(xml);
		} catch (Exception e) {
			System.err.println("XML->Map 변환 중 에러 발생");
		}
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.println(key + " : " + map.get(key));
		}
		// 응답
		// Map --> XML
		JAXBContext context = null;
		try {
			// Map 을 MapWrapper로 포함
			MapWrapper wrapper = new MapWrapper(map);
			// JAXBContext 객체 생성
			context = JAXBContext.newInstance(MapWrapper.class);
			
			
			// 마샬링 : 객체 --> XML
			// 언마샬링 : XML --> 객체
			// 마샬러 : 객체를 XML로 변환해주는 객체
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
			StringWriter stringWriter = new StringWriter();
			
			// 객체 --> xml로 변환
			marshaller.marshal(wrapper, stringWriter);
			
			xml = stringWriter.toString();
		} catch (Exception e) {
			System.err.println("map --> xml 변환 시 에러");
		}
		System.out.println("map--> xml : ");
		System.out.println(xml);
		PrintWriter writer = response.getWriter();
		writer.println(xml);
	}
	

}
