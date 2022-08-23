# kurly-backend

###기술 스택
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

$ java -jarkurly-0.0.1-SNAPSHOT.jar
```