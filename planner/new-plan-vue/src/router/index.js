import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import RecipeInfo from '../views/RecipeInfo.vue'


Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/home',
      name: 'home-view',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/",
      name: "login-page",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout-page",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register-page",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/recipes/:id/information",
      name: "recipe-info",
      component: RecipeInfo,
      meta: {
        requiresAuth: true
      }
    }
    
  ]
})

router.beforeEach((to, from, next) => {
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    next();
  }
});

export default router;