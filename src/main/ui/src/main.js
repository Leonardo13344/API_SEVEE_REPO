import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import VueRouter from 'vue-router'
import routes from './routers/routers'


Vue.use(VueRouter);

const router = new VueRouter({
  routes :routes,
  mode: 'history'
});
Vue.config.productionTip = false

new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')
