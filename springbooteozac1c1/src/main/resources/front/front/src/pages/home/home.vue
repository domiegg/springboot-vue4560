<template>
<div class="home-preview" :style='{"margin":"0px auto","flexWrap":"wrap","flexDirection":"row","background":"#fff","display":"flex","width":"100%","justifyContent":"center"}'>




		


<!-- 商品推荐 -->
<div id="animate_recommendlvshi" class="recommend animate__animated" :style='{"padding":"60px 0 60px","margin":"40px auto 20px","borderColor":"#ddd","background":"#f1f1f1","borderWidth":"0px 0","width":"100%","position":"relative","borderStyle":"solid","order":"2"}'>
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
    <div class="title" :style='{"width":"76%","padding":"45px 0 0","margin":"0px auto","textAlign":"left","background":"url() no-repeat left top / auto 42px","height":"120px"}'>
		<span :style='{"padding":"0","fontSize":"32px","color":"#000","fontWeight":"600","display":"block"}'>律师推荐</span>
	</div>
	
	
	
	
	
	
	
	
	
	







		<div v-if="lvshiRecommend.length" class="list list16 index-pv1" :style='{"padding":"0 12%","margin":"20px 0 0","color":"#999","flexWrap":"wrap","background":"none","display":"flex","width":"100%","fontSize":"14px","justifyContent":"space-between","height":"auto"}'>
		  <div v-for="item,index in lvshiRecommend" :key="index"  @click="toDetail('lvshiDetail', item)" class="list-item animation-box">
		    <div :style='{"border":"0px solid red","width":"100%","padding":"0px","overflow":"hidden","height":"320px"}' class="img-box">
				<img class="image" :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' v-if="preHttp(item.touxiang)" :src="item.touxiang.split(',')[0]" alt="" />
				<img class="image" :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' v-else :src="baseUrl + (item.touxiang?item.touxiang.split(',')[0]:'')" alt="" />
			</div>
		    <div :style='{"width":"100%","padding":"0","overflow":"hidden","display":"flex","height":"auto"}' class="item-info">
		      <div :style='{"width":"100%","padding":"0 0 10px","flexWrap":"wrap","display":"flex"}'>
				<div class="title">{{item.lvshixingming}}</div>
		        <div :style='{"padding":"0 10px","borderColor":"red","textAlign":"right","borderWidth":"0","display":"none","width":"100%","lineHeight":"30px","borderStyle":"solid","order":"5"}' class="time">
		          <span class="icon iconfont icon-shijian21"></span>
		          <span class="text">{{item.addtime}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","borderColor":"red","borderStyle":"solid","borderWidth":"0","display":"inline-block"}' class="collect">
		          <span class="icon iconfont icon-shoucang10"></span>
		          <span class="text">{{item.storeupnum}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","display":"inline-block"}' class="view">
		          <span class="icon iconfont icon-chakan9"></span>
		          <span class="text">{{item.clicknum}}</span>
		        </div>
		      </div>
		      <div class="desc" v-html="item.gerenjieshao"></div>
		    </div>
		  </div>
		</div>
	
	<div @click="moreBtn('lvshi')" :style='{"border":"0px solid #fff","cursor":"pointer","padding":"0 20px 0 0","margin":"90px -12px 0 0","textAlign":"right","display":"block","right":"12%","top":"0","background":"url(http://codegen.caihongy.cn/20231010/b345185c76ac4a77bf4cd6f6171a72ed.png) no-repeat center top / 100% 100%","width":"240px","lineHeight":"73px","position":"absolute","height":"80px"}'>
		<span :style='{"color":"#333","fontSize":"14px"}'>查看更多</span>
		<i :style='{"color":"#333","fontSize":"16px","display":"none"}' class="icon iconfont icon-jiantou09"></i>
	</div>
	
</div>
<!-- 商品推荐 -->

<!-- 商品推荐 -->
<div id="animate_recommendfalvziyuan" class="recommend animate__animated" :style='{"padding":"60px 0 60px","margin":"40px auto 20px","borderColor":"#ddd","background":"#f1f1f1","borderWidth":"0px 0","width":"100%","position":"relative","borderStyle":"solid","order":"2"}'>
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
    <div class="title" :style='{"width":"76%","padding":"45px 0 0","margin":"0px auto","textAlign":"left","background":"url() no-repeat left top / auto 42px","height":"120px"}'>
		<span :style='{"padding":"0","fontSize":"32px","color":"#000","fontWeight":"600","display":"block"}'>法律资源推荐</span>
	</div>
	
	
	
	
	
	
	
	
	
	







		<div v-if="falvziyuanRecommend.length" class="list list16 index-pv1" :style='{"padding":"0 12%","margin":"20px 0 0","color":"#999","flexWrap":"wrap","background":"none","display":"flex","width":"100%","fontSize":"14px","justifyContent":"space-between","height":"auto"}'>
		  <div v-for="item,index in falvziyuanRecommend" :key="index"  @click="toDetail('falvziyuanDetail', item)" class="list-item animation-box">
		    <div :style='{"border":"0px solid red","width":"100%","padding":"0px","overflow":"hidden","height":"320px"}' class="img-box">
				<img class="image" :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
				<img class="image" :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
			</div>
		    <div :style='{"width":"100%","padding":"0","overflow":"hidden","display":"flex","height":"auto"}' class="item-info">
		      <div :style='{"width":"100%","padding":"0 0 10px","flexWrap":"wrap","display":"flex"}'>
				<div class="title">{{item.ziyuanmingcheng}}</div>
		        <div :style='{"padding":"0 10px","borderColor":"red","textAlign":"right","borderWidth":"0","display":"none","width":"100%","lineHeight":"30px","borderStyle":"solid","order":"5"}' class="time">
		          <span class="icon iconfont icon-shijian21"></span>
		          <span class="text">{{item.addtime}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","borderColor":"red","borderStyle":"solid","borderWidth":"0","display":"inline-block"}' class="collect">
		          <span class="icon iconfont icon-shoucang10"></span>
		          <span class="text">{{item.storeupnum}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","display":"inline-block"}' class="view">
		          <span class="icon iconfont icon-chakan9"></span>
		          <span class="text">{{item.clicknum}}</span>
		        </div>
		      </div>
		      <div class="desc" v-html="item.ziyuanneirong"></div>
		    </div>
		  </div>
		</div>
	
	<div @click="moreBtn('falvziyuan')" :style='{"border":"0px solid #fff","cursor":"pointer","padding":"0 20px 0 0","margin":"90px -12px 0 0","textAlign":"right","display":"block","right":"12%","top":"0","background":"url(http://codegen.caihongy.cn/20231010/b345185c76ac4a77bf4cd6f6171a72ed.png) no-repeat center top / 100% 100%","width":"240px","lineHeight":"73px","position":"absolute","height":"80px"}'>
		<span :style='{"color":"#333","fontSize":"14px"}'>查看更多</span>
		<i :style='{"color":"#333","fontSize":"16px","display":"none"}' class="icon iconfont icon-jiantou09"></i>
	</div>
	
</div>
<!-- 商品推荐 -->

<!-- 商品推荐 -->
<div id="animate_recommendanliku" class="recommend animate__animated" :style='{"padding":"60px 0 60px","margin":"40px auto 20px","borderColor":"#ddd","background":"#f1f1f1","borderWidth":"0px 0","width":"100%","position":"relative","borderStyle":"solid","order":"2"}'>
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
    <div class="title" :style='{"width":"76%","padding":"45px 0 0","margin":"0px auto","textAlign":"left","background":"url() no-repeat left top / auto 42px","height":"120px"}'>
		<span :style='{"padding":"0","fontSize":"32px","color":"#000","fontWeight":"600","display":"block"}'>案例库推荐</span>
	</div>
	
	
	
	
	
	
	
	
	
	







		<div v-if="anlikuRecommend.length" class="list list16 index-pv1" :style='{"padding":"0 12%","margin":"20px 0 0","color":"#999","flexWrap":"wrap","background":"none","display":"flex","width":"100%","fontSize":"14px","justifyContent":"space-between","height":"auto"}'>
		  <div v-for="item,index in anlikuRecommend" :key="index"  @click="toDetail('anlikuDetail', item)" class="list-item animation-box">
		    <div :style='{"border":"0px solid red","width":"100%","padding":"0px","overflow":"hidden","height":"320px"}' class="img-box">
				<img class="image" :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
				<img class="image" :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
			</div>
		    <div :style='{"width":"100%","padding":"0","overflow":"hidden","display":"flex","height":"auto"}' class="item-info">
		      <div :style='{"width":"100%","padding":"0 0 10px","flexWrap":"wrap","display":"flex"}'>
				<div class="title">{{item.anlimingcheng}}</div>
				<div class="title">{{item.anlileixing}}</div>
		        <div :style='{"padding":"0 10px","borderColor":"red","textAlign":"right","borderWidth":"0","display":"none","width":"100%","lineHeight":"30px","borderStyle":"solid","order":"5"}' class="time">
		          <span class="icon iconfont icon-shijian21"></span>
		          <span class="text">{{item.addtime}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","borderColor":"red","borderStyle":"solid","borderWidth":"0","display":"inline-block"}' class="collect">
		          <span class="icon iconfont icon-shoucang10"></span>
		          <span class="text">{{item.storeupnum}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","display":"inline-block"}' class="view">
		          <span class="icon iconfont icon-chakan9"></span>
		          <span class="text">{{item.clicknum}}</span>
		        </div>
		      </div>
		      <div class="desc" v-html="item.neirong"></div>
		    </div>
		  </div>
		</div>
	
	<div @click="moreBtn('anliku')" :style='{"border":"0px solid #fff","cursor":"pointer","padding":"0 20px 0 0","margin":"90px -12px 0 0","textAlign":"right","display":"block","right":"12%","top":"0","background":"url(http://codegen.caihongy.cn/20231010/b345185c76ac4a77bf4cd6f6171a72ed.png) no-repeat center top / 100% 100%","width":"240px","lineHeight":"73px","position":"absolute","height":"80px"}'>
		<span :style='{"color":"#333","fontSize":"14px"}'>查看更多</span>
		<i :style='{"color":"#333","fontSize":"16px","display":"none"}' class="icon iconfont icon-jiantou09"></i>
	</div>
	
</div>
<!-- 商品推荐 -->

<!-- 商品推荐 -->
<div id="animate_recommendfalvxinwen" class="recommend animate__animated" :style='{"padding":"60px 0 60px","margin":"40px auto 20px","borderColor":"#ddd","background":"#f1f1f1","borderWidth":"0px 0","width":"100%","position":"relative","borderStyle":"solid","order":"2"}'>
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
    <div class="title" :style='{"width":"76%","padding":"45px 0 0","margin":"0px auto","textAlign":"left","background":"url() no-repeat left top / auto 42px","height":"120px"}'>
		<span :style='{"padding":"0","fontSize":"32px","color":"#000","fontWeight":"600","display":"block"}'>法律新闻推荐</span>
	</div>
	
	
	
	
	
	
	
	
	
	







		<div v-if="falvxinwenRecommend.length" class="list list16 index-pv1" :style='{"padding":"0 12%","margin":"20px 0 0","color":"#999","flexWrap":"wrap","background":"none","display":"flex","width":"100%","fontSize":"14px","justifyContent":"space-between","height":"auto"}'>
		  <div v-for="item,index in falvxinwenRecommend" :key="index"  @click="toDetail('falvxinwenDetail', item)" class="list-item animation-box">
		    <div :style='{"border":"0px solid red","width":"100%","padding":"0px","overflow":"hidden","height":"320px"}' class="img-box">
				<img class="image" :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
				<img class="image" :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
			</div>
		    <div :style='{"width":"100%","padding":"0","overflow":"hidden","display":"flex","height":"auto"}' class="item-info">
		      <div :style='{"width":"100%","padding":"0 0 10px","flexWrap":"wrap","display":"flex"}'>
				<div class="title">{{item.biaoti}}</div>
		        <div :style='{"padding":"0 10px","borderColor":"red","textAlign":"right","borderWidth":"0","display":"none","width":"100%","lineHeight":"30px","borderStyle":"solid","order":"5"}' class="time">
		          <span class="icon iconfont icon-shijian21"></span>
		          <span class="text">{{item.addtime}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","borderColor":"red","borderStyle":"solid","borderWidth":"0","display":"inline-block"}' class="like">
		          <span class="icon iconfont icon-zan10"></span>
		          <span class="text">{{item.thumbsupnum}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","borderColor":"red","borderStyle":"solid","borderWidth":"0","display":"inline-block"}' class="collect">
		          <span class="icon iconfont icon-shoucang10"></span>
		          <span class="text">{{item.storeupnum}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","display":"inline-block"}' class="view">
		          <span class="icon iconfont icon-chakan9"></span>
		          <span class="text">{{item.clicknum}}</span>
		        </div>
		      </div>
		      <div class="desc" v-html="item.jianjie"></div>
		    </div>
		  </div>
		</div>
	
	<div @click="moreBtn('falvxinwen')" :style='{"border":"0px solid #fff","cursor":"pointer","padding":"0 20px 0 0","margin":"90px -12px 0 0","textAlign":"right","display":"block","right":"12%","top":"0","background":"url(http://codegen.caihongy.cn/20231010/b345185c76ac4a77bf4cd6f6171a72ed.png) no-repeat center top / 100% 100%","width":"240px","lineHeight":"73px","position":"absolute","height":"80px"}'>
		<span :style='{"color":"#333","fontSize":"14px"}'>查看更多</span>
		<i :style='{"color":"#333","fontSize":"16px","display":"none"}' class="icon iconfont icon-jiantou09"></i>
	</div>
	
</div>
<!-- 商品推荐 -->

	
</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        newsList: [],
        lvshiRecommend: [],
        falvziyuanRecommend: [],
        anlikuRecommend: [],
        falvxinwenRecommend: [],





      }
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.getList();
    },
	mounted() {
		window.addEventListener('scroll', this.handleScroll)
		setTimeout(()=>{
			this.handleScroll()
		},100)
		
		this.swiperChanges()
	},
	beforeDestroy() {
	  window.removeEventListener('scroll', this.handleScroll)
	},
    //方法集合
    methods: {
		swiperChanges() {
			setTimeout(()=>{
			},750)
		},


		handleScroll() {
			let arr = [
				{id:'search',css:'animate__'},
				{id:'about',css:'animate__'},
				{id:'system',css:'animate__'},
				{id:'animate_recommendlvshi',css:'animate__'},
				{id:'animate_recommendfalvziyuan',css:'animate__'},
				{id:'animate_recommendanliku',css:'animate__'},
				{id:'animate_recommendfalvxinwen',css:'animate__'},
				{id:'msgs',css:'animate__'},
				{id:'friendly',css:'animate__'}
			]
			
			for (let i in arr) {
				let doc = document.getElementById(arr[i].id)
				if (doc) {
					let top = doc.offsetTop
					let win_top = window.innerHeight + window.pageYOffset
					// console.log(top,win_top)
					if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
						// console.log(doc)
						doc.classList.add(arr[i].css)
					}
				}
			}
		},
      preHttp(str) {
          return str && str.substr(0,4)=='http';
      },
		getList() {
			let autoSortUrl = "";
			let data = {}
          autoSortUrl = "lvshi/autoSort";
			data = {
				page: 1,
				limit: 8,
			}
			data['sfsh'] = '是'
			this.$http.get(autoSortUrl, {params: data}).then(res => {
				if (res.data.code == 0) {
					this.lvshiRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
          autoSortUrl = "falvziyuan/autoSort";
			data = {
				page: 1,
				limit: 8,
			}
			this.$http.get(autoSortUrl, {params: data}).then(res => {
				if (res.data.code == 0) {
					this.falvziyuanRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
          autoSortUrl = "anliku/autoSort";
			data = {
				page: 1,
				limit: 8,
			}
			this.$http.get(autoSortUrl, {params: data}).then(res => {
				if (res.data.code == 0) {
					this.anlikuRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
          autoSortUrl = "falvxinwen/autoSort";
			data = {
				page: 1,
				limit: 8,
			}
			this.$http.get(autoSortUrl, {params: data}).then(res => {
				if (res.data.code == 0) {
					this.falvxinwenRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
			
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {id: item.id}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		// -------- search --------
		.search .select /deep/ .el-input__inner {
			border: 0px solid #ddd;
			border-radius: 80px 0 0 80px;
			padding: 0 30px 0 50px;
			box-shadow: 0 0 0px rgba(64, 158, 255, .3);
			outline: none;
			color: #808080;
			background: #f5f5f5;
			width: 180px;
			font-size: 16px;
			height: 60px;
		}
		
		.search .input /deep/ .el-input__inner {
			border: 0px solid #ddd;
			border-radius: 2px;
			padding: 0 10px 0 40px;
			box-shadow: 0 0 0px rgba(64, 158, 255, .3);
			outline: none;
			color: #808080;
			background: url(http://codegen.caihongy.cn/20231010/e6f200cdf25b457cae56c7a886461d70.png) no-repeat 20px center / auto 36px,#f5f5f5;
			width: 380px;
			font-size: 16px;
			height: 60px;
		}
		// -------- search --------
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: #0c5f62;
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: #0c5f62;
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, -10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1.02) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(0.96) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, -10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	}
	








	.home-preview .recommend .list16 .list-item {
				cursor: pointer;
				padding: 0px;
				margin: 0 0 40px 0;
				background: #fff;
				display: flex;
				width: 23%;
				font-size: 0;
				position: relative;
				flex-wrap: wrap;
				height: auto;
			}
	
	.home-preview .recommend .list16 .list-item:hover {
				background: #3795c4;
			}
	
	.home-preview .recommend .list16 .list-item .title {
				padding: 0 10px;
				overflow: hidden;
				color: #333;
				white-space: nowrap;
				width: 100%;
				font-size: 16px;
				border-color: red;
				border-width: 0;
				line-height: 36px;
				text-overflow: ellipsis;
				border-style: solid;
			}
	
	.home-preview .recommend .list16 .list-item:hover .title {
				color: #fff;
			}
	
	.home-preview .recommend .list16 .list-item .time .icon {
				margin: 0 2px 0 0;
				color: inherit;
				font-size: 14px;
				line-height: 28px;
			}
	.home-preview .recommend .list16 .list-item:hover .time .icon {
				color: #fff;
			}
	.home-preview .recommend .list16 .list-item .time .text {
				color: inherit;
				font-size: 14px;
				line-height: 28px;
			}
	.home-preview .recommend .list16 .list-item:hover .time .text {
				color: #fff;
			}
	
	.home-preview .recommend .list16 .list-item .publisher .icon {
				margin: 0 2px 0 0;
				color: inherit;
				font-size: 14px;
				line-height: 28px;
			}
	.home-preview .recommend .list16 .list-item:hover .publisher .icon {
				color: #fff;
			}
	.home-preview .recommend .list16 .list-item .publisher .text {
				color: inherit;
				font-size: 14px;
				line-height: 28px;
			}
	.home-preview .recommend .list16 .list-item:hover .publisher .text {
				color: #fff;
			}
	
	.home-preview .recommend .list16 .list-item .like .icon {
				margin: 0 2px 0 0;
				color: inherit;
				font-size: 14px;
				line-height: 28px;
			}
	.home-preview .recommend .list16 .list-item:hover .like .icon {
				color: #fff;
			}
	.home-preview .recommend .list16 .list-item .like .text {
				color: inherit;
				font-size: 14px;
				line-height: 28px;
			}
	.home-preview .recommend .list16 .list-item:hover .like .text {
				color: #fff;
			}
	
	.home-preview .recommend .list16 .list-item .collect .icon {
				margin: 0 2px 0 0;
				color: inherit;
				font-size: 14px;
				line-height: 28px;
			}
	.home-preview .recommend .list16 .list-item:hover .collect .icon {
				color: #fff;
			}
	.home-preview .recommend .list16 .list-item .collect .text {
				color: inherit;
				font-size: 14px;
				line-height: 28px;
			}
	.home-preview .recommend .list16 .list-item:hover .collect .text {
				color: #fff;
			}
	
	.home-preview .recommend .list16 .list-item .view .icon {
				margin: 0 2px 0 0;
				color: inherit;
				font-size: 14px;
				line-height: 28px;
			}
	.home-preview .recommend .list16 .list-item:hover .view .icon {
				color: #fff;
			}
	.home-preview .recommend .list16 .list-item .view .text {
				color: inherit;
				font-size: 14px;
				line-height: 28px;
			}
	.home-preview .recommend .list16 .list-item:hover .view .text {
				color: #fff;
			}
	
	.home-preview .recommend .list16 .list-item .desc {
				color: #666;
				display: none;
				font-size: 12px;
				line-height: 1.5;
			}
	.home-preview .recommend .list16 .list-item:hover .desc {
				color: #fff;
			}


	.home-preview .lists .list17 .item .image {
				object-fit: cover;
				display: block;
				width: 100%;
				transition: 0.3s;
				height: 100%;
			}

	.home-preview .lists .list17 .item:hover .image {
				transform: scale(1);
			}
	
	.home-preview .lists .list17 .item .content {
				padding: 20px;
				left: 0;
				bottom: -100%;
				background: rgba(34,81,106,.6);
				display: flex;
				width: 100%;
				position: absolute;
				flex-wrap: wrap;
				transition: 0.3s;
				height: 100%;
			}
	
	.home-preview .lists .list17 .item:hover .content {
				bottom: 0;
			}
</style>
