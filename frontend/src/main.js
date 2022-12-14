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
import aws_info from './aws_info.Vue'

import VueCookie from 'vue-cookie';

// plugin setup
Vue.use(DashboardPlugin);

Vue.use(VueCookie);

const _axios = axios.create({
  // withCredentials: true
});

_axios.defaults.headers.common['Access-Control-Allow-Headers'] = '*';
_axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
_axios.defaults.headers.common['Content-Type'] = "application/json";
_axios.defaults.headers.common['Access-Control-Request-Methods'] = "GET, POST, PUT";

_axios.interceptors.request.use((config) => {
  var token = VueCookie.get("token");
  _axios.defaults.headers.common['jwt-auth-token'] = token;
  return config;
}, function (error) {
  return Promise.reject(error);
});

Vue.prototype.$axios = _axios;

Vue.prototype.$swal = swal;

Vue.prototype.$sample = sample;

Vue.prototype.$aws_info = aws_info;


//필터
//숫자 3자리 단위마다 콤마를 찍는다.
Vue.filter('numCommaFilter', function (value) {
  return String(value).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router
});
