<template>
    <div>
        <ArticleTop></ArticleTop>
        <div class="title">
            <ul>
                <li><h1>{{Articles.articleTitle}}</h1></li>
                <li>{{Articles.articleDate}}</li>
                <li v-if="articleLikeCount_status"><el-button @click="getLikeCount">点赞</el-button></li>
                <li v-else><el-button>已点赞</el-button></li>
            </ul>
        </div>
        <div class="contain">
            <div class="news">
                <div v-html="Articles.articleContentHtml"></div>
            </div>
        </div>
        <el-backtop :bottom="100"></el-backtop>
                <Bottom></Bottom>
    </div>
</template>
<script>
import ArticleTop from './common/ArticleTop'
import Bottom from './common/Bottom'
export default {
    name:'Article',
    data() {
        return {
            Articles:[],
            articleLikeCount:'',
            articleLikeCount_status: true
        }
    },
    mounted () {
        this.getArticles()
    },
    methods:{
        getArticles () {
            this.$axios.get('/articles/'+this.$route.query.id).then(res=>{
                if(res&&res.data.code === 200){
                    this.Articles = res.data.result
                    console.log(this.Articles.articleLikeCount);
                }
            })
        },
        //点赞
        getLikeCount () {
            this.$axios.post('/articles/'+this.$route.query.id + '/addCount',{
                articleLikeCount: this.Articles.articleLikeCount
            }).then(res=>{
                if(res&&res.data.code === 200){
                    console.log("点赞成功!");
                    this.articleLikeCount_status = false
                }
            })
        }
    },
    components:{ArticleTop,Bottom}
}
</script>
<style>
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
}
.news img{
    display: block;
    width: 100%;
    height: 100%;
}
.title ul {
    list-style: none;
    margin: 0px;
}
.title ul li{
    list-style: none;
}
</style>