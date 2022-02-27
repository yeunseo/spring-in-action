package tacos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 타코 재료 도메인 클래스
 */
@Data	// Lombok이 getter, setter를 컴파일시 자동 생성
@RequiredArgsConstructor	// 초기화되지 않은 final 필드를 매개변수로 갖는 생성자 자동 생성
public class Ingredient {
	private final String id;
	private final String name;
	private final Type type;
	
	public static enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
}
