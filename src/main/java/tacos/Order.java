package tacos;

import lombok.Data;

// 주문된 타코의 정보를 가지는 클래스
@Data
public class Order {
	private String deliveryName;
	private String deliveryStreet;
	private String deliveryCity;
	private String deliveryState;
	private String deliveryZip;
	private String ccNumber;
	private String ccExpiration;
	private String ccCVV;
}
