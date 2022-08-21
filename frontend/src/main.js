/*!

=========================================================
* BootstrapVue Argon Dashboard - v1.0.0
=========================================================

* Product Page: https://www.creative-tim.com/product/bootstrap-vue-argon-dashboard
* Copyright 2020 Creative Tim (https://www.creative-tim.com)

* Coded by www.creative-tim.com

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

*/
import Vue from 'vue';
import DashboardPlugin from './plugins/dashboard-plugin';
import App from './App.vue';

// router setup
import router from './routes/router';

import axios from "axios";

import swal from 'sweetalert2'
import 'sweetalert2/dist/sweetalert2.css'

import sample from './sample.Vue'

// plugin setup
Vue.use(DashboardPlugin);

axios.defaults.baseURL = "http://localhost:8000";
axios.defaults.headers.post["Content-Type"] = "application/json; charset=utf-8"

const _axios = axios.create({
  withCredentials: true
});

Vue.prototype.$axios = axios;

Vue.prototype.$swal = swal;

Vue.prototype.$sample = sample;



//필터
//숫자 3자리 단위마다 콤마를 찍는다.
Vue.filter('numCommaFilter', function (value) {
  return String(value).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
})
//단위값 '원'을 붙인다.
Vue.filter('moneyFilter', function (value) {
  return value + '원';
})
//숫자를 시간 단위로 변환한다.
Vue.filter('numToTimeFilter', function (value) {
  return Math.floor(value) + '시간 ' + (value%1 == 0? '' : '30분');
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router
});
