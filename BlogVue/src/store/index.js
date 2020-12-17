import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    //状态
    state:{
        user: window.localStorage.getItem('user') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]'))
    },
    //方法
    mutations:{
        //仓库登录方法，将登录信息传递给上面的state.username
        login (state,user){
            state.user = user
            window.localStorage.setItem('user',JSON.stringify(user))
        }
    }
})