// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

import store from './store'

//设置反向代理，前端请求默认发送到http://localhost:8443/api
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8443/api'
//全局注册
Vue.prototype.$axios = axios

Vue.use(ElementUI)
Vue.config.productionTip = false
//引入babel-polyfill转换es6
import 'babel-polyfill'

//全局导航守卫
router.beforeEach((to,from,next)=>{
  if(to.meta.requireAuth){
    if(store.state.user.user){
      next()
    } else {
      next({
        path: '/show/blog/admin',
        query: {redirect:to.fullPath}
      })
    }
  } else {
    next()
  }
})
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
