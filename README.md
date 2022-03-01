# Reminder ✔
이슈
1. /design에서 유효성 검증이 통과하지 못했을 때 체크박스 모두 사라짐
2. 1의 경우에서 유효성 검증 통과하지 못한 필드를 수정하여 제출했을 때 ingredient 값이 null값이 넘어옴
<hr>

### 1. 라이브러리
* Spring Boot DevTools
  >1. 코드 및 리소스 변경 시 애플리케이션 자동 재실행
  >2. 템플릿 캐시 자동 비활성화
  >3. H2 DB 사용 시 자동으로 H2 콘솔 활성화
  >4. 개발에만 사용되는 툴로 실 운영에선 자동 비활성화
* Lombok
    >1. 어노테이션 기반으로 코드를 자동완성해주는 라이브러리
    >2. 대표적으로 @Getter, @Setter를 사용할 수 있음
    >3. 코드의 가독성 향상, 유지보수성 향상시켜줌
* Thymeleaf
* Spring Web
* Spring Validation
* JdbcTemplate
* H2 Database

### 2. Maven/Gradle 프로젝트 구조
* src/main/java
* src/test/java
* src/main/resources
  
### 3. 그 외 파일
* mvnw, mvnw.cmd
    > Maven Wrapper. 별도의 Maven 설치 없이 Maven을 이용할 수 있게 해줌
* pom.xml
  > 메이븐 빌드를 위한 정보를 명세한 파일
* TacoCloudApplication.java
  > 메인 클래스, 부트스트랩(구동) 클래스

### 4. 스트링부트의 자동-구성 라이브러리 동작 순서
  1. Spring Application Context에 관련 Bean들을 구성하여 Spring MVC 활성화
  2. 내장된 톰캣 서버를 Spring Application Context에 구성
  3. Thymeleaf 템플릿을 사용하는 뷰를 그리기 위해 Thymeleaf View Resolver 구성

### 5. Java; Stream
  1. 스트림을 이용하면 배열이나 컬렉션에 함수 여러개를 조합해 원하는 결과를 필터링하여 가공된 결과를 얻을 수 있음
  2. 구조 : 객체.스트림생성().가공().결과만들기();
  -> 파이프라인 방식

### 6. Spring MVC 폼 유효성검사 API 적용법
  1. 유효성을 검사할 클래스에 검사 규칙 선언
  2. 검사가 동작 할 컨트롤러 메서드에 검사수행 지정
  3. 검사 결과(유효성 적합 유무)를 보여주도록 View 수정

### 7. 뷰 컨트롤러(tacos.web/WebConfig.java)
*  뷰에 요청을 전달하는 일만 하는 컨트롤러를 뷰 컨트롤러라고 함(모델 데이터나 사용자 입력 처리X)

### 8. 템플릿 캐싱 활성화/비활성화
* application.properties 파일에 `spring.thymeleaf.cache=false` 추가
* 배포 시 해당 옵션 삭제 또는 true로 변경해야 한다
* 물론 스프링 devtool을 사용하면 이 설정이 필요 없다(자동으로 해준다)

### 9. RowMapper
* jdbc.query()메서드는 SQL 실행 결과(ResultSet)를 자바 객체로 변환한 결과인 RowMapper로 반환한다
* 원하는 형태의 결과값 반환 가능
* SELECT로 나온 여러개의 값을 며 사용자가 원하는 형태로 반환 할 수 있다

### 10. schema.sql과 data.sql
* src/main/resources에 위치
* 스프링부트는 애플리케이션이 시작될 때 사용중인 DB에서 이 두 파일을 자동으로 실행한다.