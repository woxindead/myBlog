<template>
<div>
    <router-view></router-view>
    <Top></Top>
    <div class="contain">
        <div class="news" v-for="item in news.slice((currentPage-1)*pagesize,currentPage*pagesize)" :key="item.id">
            <ul>
                <li><h2><router-link :to="{path:'article',query:{id:item.id}}">{{item.articleTitle}}</router-link></h2></li>
                <li>{{item.articleAbstract}}</li>
                <li class="news-bottom">
                    <el-row>
                    <el-col :span="4"><div class="grid-content bg-purple">{{item.articleDate}}</div></el-col>
                    <el-col :span="4"><div class="grid-content bg-purple-light"></div></el-col>
                    <el-col :span="4"><div class="grid-content bg-purple"></div></el-col>
                    <el-col :span="4"><div class="grid-content bg-purple-light"></div></el-col>
                    <el-col :span="4"><div class="grid-content bg-purple"><i class="el-icon-view"></i>{{item.looknum}}</div></el-col>
                    <el-col :span="4"><div class="grid-content bg-purple-light">点赞数量:{{item.articleLikeCount}}</div></el-col>
                    </el-row>
                </li>
            </ul>
        </div>
        <el-row style="width:100%;padding-top:50px;">
            <el-pagination
            background
            layout="prev, pager, next"
            @current-change="handleCurrentChange"
            :page-size="pagesize"
            :current-page="currentPage"
            :total="news.length">
            </el-pagination>
        </el-row>
    </div>
  <el-backtop :bottom="100"></el-backtop>
  <Bottom></Bottom>
</div>
</template>
<script>
import Top from './common/Top'
import Bottom from './common/Bottom'
export default {
    data() {
        return {
            news:[],
            currentPage: 1,
            pagesize:10
        }
    },
    mounted () {
        this.getArticles()
    },
    methods:{
        getArticles () {
            this.$axios.get('/articles').then(res=>{
                if(res.status === 200){
                    this.news = res.data
                    console.log(this.news);
                }
            })
        },
        //获取文章分页
        handleCurrentChange (currentPage){
            this.currentPage = currentPage
        }
    },
    components:{Top,Bottom}
}
</script>
<style scoped>
.contain{
    width: 900px;
    margin: 50px auto;
    background: #fff;
    border-radius: 15px;
    padding: 0px 40px 40px 40px;
}
.news{
    padding: 20px 20px 0px 20px;
    border-radius: 15px;
    text-align: left;
    width: 860px;
    height: 180px;
}
.news ul{
        border-bottom:1px solid #ececec;
        margin: 0;
        list-style-type: none;
        padding: 0;
}
.news ul li{
    list-style: none;
    line-height: 30px;
}
.news ul li a{
    color: #2c3e50;
    text-decoration: none;
}
.news ul li a:hover{
    color: #2c3e50;
    text-decoration: underline;
}
.news-bottom{
    height: 30px;
    padding-bottom: 20px;
}
.page{
    height: 50px;
    padding-top: 30px;
    width: 900px;
}
</style>