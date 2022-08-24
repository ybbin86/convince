# KURLY HACK FESTA - 납뜩이팀
영화 건축학개론 에서 나오는 ‘납뜩이’ 캐릭터는 영화의 내용을 더욱 풍부하게 만들어줌
마켓컬리에게 제안하는 아이디어와 팀원들이 추구하는 방향이 비슷하여 탄생

![image](https://user-images.githubusercontent.com/52481728/186303860-c49c3b8f-df22-4b8d-87f5-a42a192bb54c.png)

|준용|소현|영빈|나경|
|--|--|--|--|
|junyong6025@gmail.com|parksohyan@gmail.com|hust160251@gmail.com|nacoon53@gmail.com|

## 전체 아키텍처
![image](https://user-images.githubusercontent.com/52481728/186304600-8a949e87-ea4d-42af-a712-3250a36501da.png)

* 기술스택
  * FE
    * Vue.js 2
    * Axios
    * vue-cookie
    * vue-chartjs
    * vue-router
    * BootstrapVue
    * BootstrapVue Argon Template
  * BE
    * Spring Boot Framework
    * Spring Security
    * Lombok
    * JUnit
    * JPA
    * FastAPI
    * Airflow
    * Docker
  * DB
    * MySql 8.0

## 서비스 화면

![image](https://user-images.githubusercontent.com/52481728/186309760-f3f958f1-ea0b-42d5-bde8-fe5d631059b6.png)
![image](https://user-images.githubusercontent.com/52481728/186304712-483d094f-b250-49a4-8f86-52ba7ee22bc1.png)


## 모델링
![image](https://user-images.githubusercontent.com/52481728/186304825-9a654d3e-d048-4f2c-886e-e5cddf4c2d80.png)

### tag score
![image](https://user-images.githubusercontent.com/52481728/186310039-f8a42a7a-3cc2-4eb7-b9eb-3e86f859901f.png)
- 이벤트 해당일 하루 평균 매출액 과 연간 하루 평균 매출액을 나눠줌
- log를 씌워 변화가 없다면 0, 상승 했다면 가중치를 부여
- 아이템과 연관된 모든 활성 tag들에 대해 계산하여 합산

### Momentum
![image](https://user-images.githubusercontent.com/52481728/186310193-6662f0a2-7f8e-4ea9-8abc-75005ae555c4.png)
- 저녁 또는 새벽에(22시~04시) 거래량 감소하는 것을 대비를 위한
Momentum 계수를 활용 (다이니막 프라이싱 영향 Down)
- 거래량 감소시 상품의 적정가격이 변동 되는 것을 방지하기 위함


## 기대효과
![image](https://user-images.githubusercontent.com/52481728/186310452-095dea03-8602-421e-aa4a-8c9d4dab35fb.png)
