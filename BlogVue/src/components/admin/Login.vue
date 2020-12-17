<template>
    <div class="bg">
        <div class="login_menu">
            <el-form :inline="true" status-icon class="demo-form-inline">
            <el-form-item label="" prop="user">
                <el-input type="username" v-model="LoginForm.username" auto-complete="off" placeholder="username"></el-input>
            </el-form-item>
            <el-form-item label="" prop="pass">
                <el-input type="password" v-model="LoginForm.password" auto-complete="off" placeholder="password"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="login">提交</el-button>
            </el-form-item>
            </el-form>
        </div>
        <div class="clearfloat"></div>
    </div>
</template>
<script>
export default {
    name: 'Login',
    data () {
        return {
            LoginForm: {
            password: '',
            username: ''
            }
        }
    },
    methods: {
        login () {
            this.$axios.post('/user_login',{
                username: this.LoginForm.username,
                password: this.LoginForm.password
            }).then(ress=>{
                if(ress.data.code === 200) {
                    this.$message({
                        message: '恭喜，登录成功!',
                        type: 'success'
                    })                    
                    this.$store.commit('login',this.LoginForm)
                    this.$router.replace({path:'/show/blog/admin/index'})
                }
            });
        },
    }
}
</script>
<style scoped>
.login{
    width: 500px;
    height: 300px;
    margin: 0 auto;
    background: orange;
}
.login_menu{
    /* margin-top:300px; */
    /* background:#666; */
    position: fixed;
    top: 300px;
    left: 40%;
    height: 40px;
    padding: 30px 0px;
}
.bg{
    min-height: 1080px;
    overflow: hidden;
    width: 100%;
    background: url('~@/assets/bg.jpg') center center no-repeat;
}
.clearfloat{clear:both;height:0;font-size:1px;line-height:0px;} 
</style>>