# Reminder ✔

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