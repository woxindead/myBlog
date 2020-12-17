<template>
<div>
    <div class="top-info">
        <div class="top-info-left">MyBlog-生活从此开始</div>
        <div class="top-info-right">
            <div v-if="login_type">
                <router-link :to="{path: '/login'}"><el-button size="small" round>Login</el-button></router-link>
            </div>
            <div v-else>
                <router-link to="/user"><el-button type="primary" size="small" round>个人中心</el-button></router-link> <router-link to="/admin"><el-button type="primary" size="small" round>Admin</el-button></router-link>  <el-button size="small" round>Quit</el-button>
            </div>
        </div>
    </div>
    <div class="banner">
        <el-carousel height="280px" direction="vertical" :autoplay="false">
            <el-carousel-item v-for="item in pictures" :key="item.id">
            <h3 class="medium"><div><img :src="item.cover"></div></h3>
            </el-carousel-item>
        </el-carousel>
    </div>
    <el-menu 
    :default-active="$route.path" 
    router
    class="el-menu-demo" 
    mode="horizontal" 
    @select="handleSelect"
    >
    <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">{{item.navItem}}</el-menu-item>
    </el-menu>
    <div class="line"></div>
    <div class="contain">

    </div>
</div>
</template>
<script>
export default {
    name: 'Index',
    data() {
        return {
            login_type: true,
            username: 'loading',
            navList: [
                {name:'/', navItem: '首页'},
                {name:'/jotter', navItem: '随心笔记'},
                {name:'/library', navItem: '技术分享'},
                {name:'/picture', navItem: '相册'}
            ],
            pictures:[
                {name:'/',cover:'../static/img/01.jpg'}
            ]
        }
    },
    created(){
        // this.CheckLogin()
    },
    methods: {
        handleSelect(key, keyPath) {
            console.log(key, keyPath);
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
.top-info{
    height: 50px;
}
.top-info-left{
    height: 50px;
    line-height: 50px;
    float: left;
    padding-left:80px;
}
.top-info-right{
    height: 50px;
    line-height: 50px;
    float: right;
    padding-right: 80px;
}
.login_link{
    color :red;
}
.contain{
    width: 1200px;
}
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }
  
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
</style>