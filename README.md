# convince-backend

### 기능 목록
- 로그인
- 회원가입
- 상품 목록
- 상품 등록
- 카테고리 목록
- 해시태그 목록
- 해시태그 등록
- 상품 적정가 대시보드 

### 기술 스택
- Spring Boot Framework
- Spring Security 
- MySql 8.0
- Lombok
- JUnit

### 패키징

```bash
# 패키징
$ git clone git@github.com:ybbin86/convince.git

$ cd convince/backend

# 빌드 결과물은 ./build/libs/에 있음
$ ./gradlew build --exclude-task test

$ cd build/libs/

$ ls
kurly-0.0.1-SNAPSHOT.jar

$ java -jar kurly-0.0.1-SNAPSHOT.jar
```

### 트리구조
```bash
src
├── main
│ ├── java
│ │ └── com
│ │     └── festa
│ │         └── hack
│ │             └── kurly
│ │                 ├── KurlyApplication.java
│ │                 ├── config
│ │                 │ ├── ModelMapperConfig.java
│ │                 │ └── SecurityConfig.java
│ │                 ├── controller
│ │                 │ ├── CategoryController.java
│ │                 │ ├── DashboardController.java
│ │                 │ ├── GoodsController.java
│ │                 │ ├── TagController.java
│ │                 │ └── UserController.java
│ │                 ├── converter
│ │                 │ └── StringListConverter.java
│ │                 ├── custom
│ │                 │ └── CustomException.java
│ │                 ├── dto
│ │                 │ ├── GoodsDto.java
│ │                 │ └── TagDto.java
│ │                 ├── entity
│ │                 │ ├── BaseTimeEntity.java
│ │                 │ ├── Category.java
│ │                 │ ├── CreatedTimeEntity.java
│ │                 │ ├── Goods.java
│ │                 │ ├── GoodsTagMap.java
│ │                 │ ├── OrderHistory.java
│ │                 │ ├── PriceHistory.java
│ │                 │ ├── SeasonPoint.java
│ │                 │ ├── Tag.java
│ │                 │ └── User.java
│ │                 ├── handler
│ │                 │ ├── ErrorResponse.java
│ │                 │ └── GlobalExceptionHandler.java
│ │                 ├── impl
│ │                 ├── repository
│ │                 │ ├── CategoryRepository.java
│ │                 │ ├── GoodsRepository.java
│ │                 │ ├── GoodsTagMapRepository.java
│ │                 │ ├── OrderHistoryRepository.java
│ │                 │ ├── PriceHistoryRepository.java
│ │                 │ ├── TagRepository.java
│ │                 │ └── UserRepository.java
│ │                 ├── security
│ │                 │ ├── JwtAuthenticationFilter.java
│ │                 │ └── JwtTokenProvider.java
│ │                 ├── service
│ │                 │ ├── CategoryService.java
│ │                 │ ├── CustomUserDetailService.java
│ │                 │ ├── DashboardService.java
│ │                 │ ├── GoodsService.java
│ │                 │ ├── TagService.java
│ │                 │ └── UserService.java
│ │                 ├── specific
│ │                 │ └── GoodsSpecific.java
│ │                 └── type
│ │                     ├── CategoryDepth.java
│ │                     ├── ErrorCode.java
│ │                     └── Role.java
│ └── resources
│     ├── application.yml
│     ├── static
│     └── templates
```
