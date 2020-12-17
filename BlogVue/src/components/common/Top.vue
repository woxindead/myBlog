<template>
<div class="bg">
    <div class="top-menu-left" @click="menu"><a  href="javascript:;">MENU</a></div>
    <div class="menu" v-if="menuType">
        <ul>
            <li v-for="(item,i) in navList" :key="i" :index="item.name"><router-link :to="item.name">{{item.navItem}}</router-link></li>
        </ul>
    </div>
    <div class="title"><h1>MYBLOG<br>生活从此开始--生命有你而精彩</h1></div>
</div>
</template>
<script>
export default {
    name: 'Index',
    data() {
        return {
            menuType: false,
            username: 'loading',
            navList: [
                {name:'/', navItem: '首页'},
                {name:'/note', navItem: '随心笔记'},
                {name:'/share', navItem: '技术分享'},
                {name:'/books', navItem: '好书推荐'}
            ],
            // img:require('../../static/img/bg.jpg')
        }
    },
    created(){
        // this.CheckLogin()
    },
    methods: {
        //打开或关闭菜单
        menu () {
            if(this.menuType === false){
                this.menuType = true
            } else {
                this.menuType = false
            }
            
        },
        //隐藏菜单
        hideMenu () {
            this.menuType = false
        },
        //检查是否已经登录
        CheckLogin(){
            console.log("检查是否登录");
        if(this.$store.state.user.username){
            this.login_type = false
            this.username = this.$store.state.user.username
            console.log(this.username);
        }
        },
        //退出登录
        logout(){
            this.$axios.get('/logout').then(res=>{
                if(res.data.code === 200){
                    this.$store.commit('quit')
                    if(this.$store.state){
                        this.$message({
                            message: '退出成功',
                            type: 'success'
                        })
                        this.login_code = true
                    }
                }
            })
        }
    }
}
</script>
<style scoped>
.bg{
    height: 1080px;
    background: url('~@/assets/bg.jpg') center center;
}
.menu{
    background: #000;
    border: 0px;
    border-radius: 60px;
    width: 500px;
    opacity: .5;
    height: 44px;
    position: absolute;
    left: 150px;
    top: 26px;
}
.menu ul{
    list-style: none;
    margin: 0px;
}
.menu ul li{
    border-bottom: 0px;
    list-style: none;
    width: 100px;
    height: 44px;
    line-height: 44px;
    float: left;
}
.menu ul li a{
    text-decoration: none;
    color: #fff;
    display: block;
    font-weight: bold;
    width: 100px;
}
.menu ul li a:hover{
    width: 100px;
    height: 44px;
    background-color:#fff; 
    color: #000;
    font-weight: bold;
}
.top-menu-left{
    width: 120px;
    height: 32px;
    font: left;
    padding-left: 30px;
    padding-top: 20px;
}
.top-menu-left a{
    background-color:#000; /* Green */
    border-radius: 60px;
    width: 50px;
    height: 20px;
    opacity: .5;
    color: white;
    padding: 12px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
    font-weight: bold;
}
.top-menu-left a:hover{
    width: 50px;
    height: 20px;
    background-color:#fff; 
    color: #000;
    font-weight: bold;
}
.top-menu-left a:active{
    width: 50px;
    height: 20px;
    background-color:#000; 
    color: #fff;
    font-weight: bold;
}
.title{
    color: #fff;
    padding-top: 100px;
}
</style>