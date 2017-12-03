import Vue from 'vue'
import App from './App.vue'
import {store} from "./store"
import {router} from "./router"

import axios from 'axios'
import VueAxios from 'vue-axios'
Vue.use(VueAxios, axios)

new Vue({
  el: '#app',
  render: h => h(App),
  router: router,
  store: store
})
