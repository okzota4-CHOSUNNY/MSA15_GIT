package lombok.basic;

import lombok.Builder;
import lombok.Data;


@Data				// @Getter, @Setter, @ToString
					// @RequiredArgsConstructor
					// @EqualsHashCode
@Builder
public class Pikachu {
	// 필수 생성자로 지정되려면, @NonNull 또는 final 선언
	final int energy;
	String type;
	int level;
}