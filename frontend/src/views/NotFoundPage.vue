<template>
  <div>
    <!-- Header -->
    <div class="header bg-gradient-success py-7 py-lg-8 pt-lg-9">
      <b-container>
        <div class="header-body text-center mb-7">
          <b-row class="justify-content-center">
            <b-col xl="5" lg="6" md="8" class="px-5">
              <h1 class="text-white">Welcome!</h1>
            </b-col>
          </b-row>
        </div>
      </b-container>
      <div class="separator separator-bottom separator-skew zindex-100">
        <svg x="0" y="0" viewBox="0 0 2560 100" preserveAspectRatio="none" version="1.1"
             xmlns="http://www.w3.org/2000/svg">
          <polygon class="fill-default" points="2560 0 2560 100 0 100"></polygon>
        </svg>
      </div>
    </div>
    <!-- Page content -->
    <b-container class="mt--8 pb-5">
      <b-row class="justify-content-center">
        <b-col cols="12">
          <div no-body class="bg-transperent border-0 mb-0">
            <div class="px-lg-5 py-lg-5">
              <div class="text-center text-muted mb-4">
                <b-row>
                  <b-col>
                 <h1 class="text-white">납뜩이를 찾아주셔서 감사합니다.</h1>
                  <p class="text-lead text-white">해당 페이지를 찾을 수 없습니다.</p>
                  </b-col>       
                  <b-col cols="12" class="text-center">
                  <router-link to="/register" class="text-light"><small>로그인 화면으로 돌아가기 ></small></router-link>
                  </b-col>
                </b-row>
              </div>
            </div>
          </div>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>
<script>
  export default {
   
  };
</script>
