# hold-order

대용량 상품에 대하여 조회 속도를 최대한 빠르게 만들었습니다.  
SWAGGER를 사용하여 꼼꼼하게 작성했습니다.  
테스트 커버리지 n%.

## 사용 기술

- JAVA 17
- SpringBoot 3.2.5
- JUnit 5
- MySQL(AWS)
- SWAGGER

## API 기능

### 상품

- 단일상품 조회(상품 상세페이지 진입)
- 검색 조회(검색조건 + 페이징 조회)
- 단일 상품 등록
- 벌크 상품 등록
- 단일 상품 수정
- 벌크 상품 수정
- 상품 삭제

### 상품 옵션

- 옵션 추가
- 옵션 수정
- 옵션 삭제

## 상품 설계

![hold-order.png](src%2Fmain%2Fresources%2Fimage%2Fhold-order.png)

## swagger 설정

http://localhost/swagger-ui/index.html

![swagger.png](src%2Fmain%2Fresources%2Fimage%2Fswagger.png)