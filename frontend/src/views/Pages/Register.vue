<template>
  <div>
    <!-- Header -->
    <div class="header bg-gradient-success py-7 py-lg-8 pt-lg-9">
      <b-container class="container">
        <div class="header-body text-center mb-7">
          <b-row class="justify-content-center">
            <b-col xl="5" lg="6" md="8" class="px-5">
              <h1 class="text-white">회원가입</h1>
              <p class="text-lead text-white">납뜩이</p>
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
      <!-- Table -->
      <b-row class="justify-content-center">
        <b-col lg="6" md="8" >
          <b-card no-body class="bg-secondary border-0">
            <b-card-body class="px-lg-5 py-lg-5">
              <div class="text-center text-muted mb-4">
                <small>반갑습니다!</small>
              </div>
              <validation-observer v-slot="{handleSubmit}" ref="formValidator">
                <b-form role="form" @submit.prevent="handleSubmit(onSubmit)">
                  <base-input alternative
                              class="mb-3"
                              prepend-icon="ni ni-hat-3"
                              placeholder="이름"
                              name="Name"
                              :rules="{required: true}"
                              v-model="model.name">
                  </base-input>

                  <base-input alternative
                              class="mb-3"
                              prepend-icon="ni ni-email-83"
                              placeholder="이메일"
                              name="Email"
                              :rules="{required: true, email: true}"
                              v-model="model.email">
                  </base-input>

                  <base-input alternative
                              class="mb-3"
                              prepend-icon="ni ni-lock-circle-open"
                              placeholder="비밀번호"
                              type="password"
                              name="Password"
                              :rules="{required: true, min: 4}"
                              v-model="model.password">
                  </base-input>
                  <div class="text-center">
                    <b-button type="submit" variant="primary" class="mt-4">회원가입</b-button>
                  </div>
                </b-form>
              </validation-observer>
            </b-card-body>
          </b-card>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>
<script>

  export default {
    name: 'register',
    data() {
      return {
        model: {
          name: '',
          email: '',
          password: '',
          role: 1,
        }
      }
    },
    methods: {
      onSubmit() {
        var url="/signup";
        var params = this.model;

        this.$axios.post(url, params)
          .then((res) => { //요청 성공
            this.$router.push('/login');

            this.$swal.fire({
              title: `Success`,
              text: '납뜩이 서비스의 회원이 되신 것을 축하드립니다 :)',
              buttonsStyling: false,
              confirmButtonClass: 'btn btn-success',
              icon: 'success'
            });
          })
          .catch((error) => { //요청 실패
            this.$swal.fire({
              title: `Fail`,
              text: `회원가입에 실패하였습니다.`,
              buttonsStyling: false,
              confirmButtonClass: 'btn btn-warning',
              icon: 'warning'
            });
          });
      }
    }

  };
</script>
<style></style>
