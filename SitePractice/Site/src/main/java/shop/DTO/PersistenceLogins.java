package shop.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersistenceLogins {
	private int no;					// 번호
	private String id;				// ID
	private String username;		// 회원 아이디
	private String token;			// 인증 토큰
	private Date expiryDate;		// 만료 기간
	private Date createdAt;			// 등록 일자
	private Date updatedAt;			// 수정 일자
}










