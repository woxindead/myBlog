import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import Article from '@/components/Article'
import Books from '@/components/Books'
import Login from '@/components/admin/Login'
import AdminIndex from '@/components/admin/home/AdminIndex'

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index
    },
    {
      path: '/article',
      name: 'Article',
      component: Article
    },
    {
      path: '/books',
      name: 'Books',
      component: Books
    },
    {
      path: '/show/blog/admin',
      name: 'Login',
      component: Login
    },
    {
      path: '/show/blog/admin/index',
      name: 'AdminIndex',
      component: AdminIndex,
      meta:{
        title: '管理后台',
        requireAuth: true
      }
    }
  ]
})
