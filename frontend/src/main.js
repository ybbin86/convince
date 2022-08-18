import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App.vue'

import routes from './routes/routes'

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.config.productionTip = false

Vue.use(VueRouter)
Vue.use(BootstrapVue)

const router = new VueRouter({
  routes, // short for routes: routes
  scrollBehavior: (to) => {
    if (to.hash) {
      return {selector: to.hash}
    } else {
      return { x: 0, y: 0 }
    }
  }
})

new Vue({
  render: h => h(App),
  router
}).$mount('#app')
