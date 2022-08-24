import Vue from 'vue';
import VueCookie from 'vue-cookie';
import VueRouter from 'vue-router';
import routes from './routes';

Vue.use(VueRouter);
Vue.use(VueCookie);

// configure router
const router = new VueRouter({
  routes, // short for routes: routes
  linkActiveClass: 'active',
  mode: "history",
  scrollBehavior: (to, from ,savedPosition) => {
    if (savedPosition) {
      return savedPosition;
    }
    if (to.hash) {
      return { selector: to.hash };
    }
    return { x: 0, y: 0 };
  }
});


router.beforeEach((to, from, next) => {
  if (to.matched.some(r => r.meta.auth)) {
    if (!VueCookie.get("token")) {
      next('/login');
    } else {
      next();
    }
  } else {
    next();
  }
});
export default router;
