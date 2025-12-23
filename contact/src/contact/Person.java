package contact;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private int no;				// 번호
	private String name;		// 이름
	private String phone;		// 전화번호
	private String memo;		// 메모
	
}
