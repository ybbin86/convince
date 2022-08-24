# convince-frontend

### 기술 스택
- Vue.js 2
- Axios
- vue-cookie
- vue-chartjs
- vue-router
- BootstrapVue
- BootstrapVue Argon Template

### 페이지 목록
- 회원가입
- 로그인
- 상품 목록
- 상품 등록
- 해시태그 관리
- 상품 실시간 가격 차트

### 실행 명령어
```
$ git clone git@github.com:ybbin86/convince.git

$ cd convince/frontend

$ npm install

$ npm run serve
```

### 트리 구조
```
\---src
    \---views
        |   NotFoundPage.vue
        |
        +---Layout
        |       Content.vue
        |       ContentFooter.vue
        |       DashboardLayout.vue
        |       DashboardNavbar.vue
        |
        +---Pages
        |       AuthLayout.vue
        |       Chart.vue
        |       GoodsAdd.vue
        |       HashtagSetting.vue
        |       List.vue
        |       Login.vue
        |       Register.vue
        |
        \---Tables
                GoodsTable.vue
                HashtagTable.vue
 ```
