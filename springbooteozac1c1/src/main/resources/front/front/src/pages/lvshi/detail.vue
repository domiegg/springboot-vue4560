<template>
<div>
	<div :style='{"padding":"16px 12%","margin":"0px auto","borderColor":"#d8d8d8","borderRadius":"0px","background":"none","borderWidth":"0 0 3px","width":"100%","borderStyle":"solid"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'/'" :style='{"fontSize":"16px","lineHeight":"1","justifyContent":"flex-start","display":"flex"}'>
			<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index" to="/index/lvshi"><a>{{item.name}}</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item3"><a href="javascript:void(0);">详情</a></el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	<div :style='{"padding":"16px 12%","margin":"0px auto","borderColor":"#d8d8d8","borderRadius":"0px","background":"none","borderWidth":"0 0 3px","width":"100%","borderStyle":"solid"}'>
		<el-button size="mini" @click="backClick">返回</el-button>
	</div>
	<div class="detail-preview" :style='{"padding":"30px 12%","margin":"0 auto","alignItems":"flex-start","flexWrap":"wrap","background":"#edeff1","display":"flex","width":"100%","position":"relative","justifyContent":"space-between"}'>
		<div class="attr" :style='{"padding":"10px 0 0","margin":"0","flexWrap":"wrap","background":"none","display":"flex","width":"60%","position":"relative","justifyContent":"space-between","order":"2"}'>

			<div class="info" :style='{"width":"100%","padding":"0px","margin":"0","background":"none","flex":"1","order":"2"}'>
				<div class="item" :style='{"padding":"0px","margin":"10px 0 10px 0","overflow":"hidden","alignItems":"center","borderRadius":"0px","background":"none","display":"block","lineHeight":"auto","justifyContent":"space-between","height":"auto"}'>
					<div :style='{"padding":"0px","overflow":"hidden","color":"#333","display":"block","width":"calc(100% - 0px)","fontSize":"20px","lineHeight":"40px","fontWeight":"600"}'>
                    {{detail.lvshixingming}}
                    </div>
					<div @click="storeup(1)" v-show="!isStoreup" :style='{"border":"0px solid #ffffff50","cursor":"pointer","padding":"0px","borderRadius":"30px","background":"none","width":"auto","lineHeight":"40px"}'><i v-if="false" :style='{"color":"#999","fontSize":"16px"}' class="el-icon-star-off"></i><span :style='{"color":"#999","fontSize":"14px","textDecoration":"underline"}'>点我收藏({{detail.storeupnum}})</span></div>
					<div @click="storeup(-1)" v-show="isStoreup" :style='{"border":"0px solid #ffffff50","cursor":"pointer","padding":"0px","borderRadius":"30px","background":"none","width":"auto","lineHeight":"40px"}'><i v-if="false" :style='{"color":"#999","fontSize":"16px"}' class="el-icon-star-on"></i><span :style='{"color":"#999","fontSize":"14px","textDecoration":"underline"}'>取消收藏({{detail.storeupnum}})</span></div>
				</div>
				<div class="item" :style='{"padding":"0px 10px","margin":"0","borderColor":"#28890b10","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"8px 10px 0","color":"#000","textAlign":"right","width":"102px","fontSize":"14px","lineHeight":"24px","height":"auto"}'>律师账号</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.lvshizhanghao}}</div>
				</div>
				<div class="item" :style='{"padding":"0px 10px","margin":"0","borderColor":"#28890b10","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"8px 10px 0","color":"#000","textAlign":"right","width":"102px","fontSize":"14px","lineHeight":"24px","height":"auto"}'>年龄</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.nianling}}</div>
				</div>
				<div class="item" :style='{"padding":"0px 10px","margin":"0","borderColor":"#28890b10","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"8px 10px 0","color":"#000","textAlign":"right","width":"102px","fontSize":"14px","lineHeight":"24px","height":"auto"}'>性别</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.xingbie}}</div>
				</div>
				<div class="item" :style='{"padding":"0px 10px","margin":"0","borderColor":"#28890b10","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"8px 10px 0","color":"#000","textAlign":"right","width":"102px","fontSize":"14px","lineHeight":"24px","height":"auto"}'>律师等级</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.lvshidengji}}</div>
				</div>
				<div class="item" :style='{"padding":"0px 10px","margin":"0","borderColor":"#28890b10","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"8px 10px 0","color":"#000","textAlign":"right","width":"102px","fontSize":"14px","lineHeight":"24px","height":"auto"}'>专业领域</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.zhuanyelingyu}}</div>
				</div>
				<div class="item" :style='{"padding":"0px 10px","margin":"0","borderColor":"#28890b10","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"8px 10px 0","color":"#000","textAlign":"right","width":"102px","fontSize":"14px","lineHeight":"24px","height":"auto"}'>地区</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.diqu}}</div>
				</div>
				<div class="item" :style='{"padding":"0px 10px","margin":"0","borderColor":"#28890b10","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"8px 10px 0","color":"#000","textAlign":"right","width":"102px","fontSize":"14px","lineHeight":"24px","height":"auto"}'>联系电话</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.lianxidianhua}}</div>
				</div>
				<div class="item" :style='{"padding":"0px 10px","margin":"0","borderColor":"#28890b10","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"8px 10px 0","color":"#000","textAlign":"right","width":"102px","fontSize":"14px","lineHeight":"24px","height":"auto"}'>点击次数</div>
					<div  :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.clicknum}}</div>
				</div>
				<div class="item" :style='{"padding":"0px 10px","margin":"0","borderColor":"#28890b10","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}' v-if="centerType">
					<div class="lable" :style='{"padding":"8px 10px 0","color":"#000","textAlign":"right","width":"102px","fontSize":"14px","lineHeight":"24px","height":"auto"}'>审核状态</div>
					<div :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.sfsh=='是'?'通过':(detail.sfsh=='否'?'不通过':'待审核')}}</div>
				</div>
				<div class="item" :style='{"padding":"0px 10px","margin":"0","borderColor":"#28890b10","background":"#fff","borderWidth":"0px","display":"flex","borderStyle":"solid","justifyContent":"spaceBetween"}' v-if="centerType">
					<div class="lable" :style='{"padding":"8px 10px 0","color":"#000","textAlign":"right","width":"102px","fontSize":"14px","lineHeight":"24px","height":"auto"}'>审核回复</div>
					<div :style='{"padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#666","flex":"1","height":"auto"}'>{{detail.shhf}}</div>
				</div>
				<div class="btn" :style='{"width":"100%","padding":"20px 112px 0","borderRadius":"0","flexWrap":"wrap","background":"#fff","display":"block"}'>
					<el-button :style='{"border":"1px solid #3795c4","cursor":"pointer","padding":"0 20px","margin":"0 10px 20px 0","outline":"none","color":"#3795c4","borderRadius":"6px","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('lvshi','修改')&&detail.sfsh!='是'&&detail.sfsh!='否' " @click="editClick">修改</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 10px 10px 0","outline":"none","color":"#fff","borderRadius":"6px","background":"#3795c4","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('lvshi','删除')" @click="delClick">删除</el-button>
					
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 10px 10px 0","outline":"none","color":"#fff","borderRadius":"6px","background":"#3795c4","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('lvshi','私聊')&&detail.id!=mid" @click="chatClick">私聊</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 10px 20px 0","color":"#fff","clear":"both","outline":"none","borderRadius":"6px","background":"#3795c4","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('lvshi','在线预约')" @click="onAcross('zaixianyuyue','是','','','')" type="warning">在线预约</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 10px 10px 0","outline":"none","color":"#fff","borderRadius":"6px","background":"#3795c4","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('lvshi','审核') && (detail.sfsh=='待审核'||!detail.sfsh)" @click="onSH" type="warning">审核</el-button>
				</div>
			</div>
		</div>
		
			<div class="swiper3" v-if="detailBanner.length" :style='{"margin":"0 2% 0px 0","flexWrap":"wrap","background":"none","display":"block","width":"38%","justifyContent":"space-between","height":"auto","order":"1"}'>
			  <div class="big" :style='{"border":"0px solid #1abc9e50","margin":"0 0 20px","background":"#fff","width":"calc(100% - 0px)","position":"relative","height":"450px","order":"1"}'>
				<img id="big" :style='{"objectFit":"contain","top":"0px","left":"0px","background":"#fff","display":"block","width":"100%","position":"absolute","height":"100%","zIndex":"1"}' :src="swiperBigUrl" class="image">
			  </div>
			  <div class="samll" :style='{"padding":"0 0px","overflow":"hidden","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto","order":"2"}'>
			    <div :style='{"border":"0px solid #1abc9e50","width":"23%","margin":"0 0px 10px","position":"relative","background":"#fff","height":"120px"}' v-for="item in detailBanner" :key="item.id">
				  <img :style='{"cursor":"pointer","objectFit":"cover","top":"0px","left":"0px","display":"block","width":"100%","position":"absolute","height":"100%","zIndex":"1"}' v-if="item.substr(0,4)=='http'" :src="item" @click="swiperClick3(item)" class="image">
				  <img :style='{"cursor":"pointer","objectFit":"cover","top":"0px","left":"0px","display":"block","width":"100%","position":"absolute","height":"100%","zIndex":"1"}' v-else :src="baseUrl + item" @click="swiperClick3(baseUrl + item)" class="image">
			    </div>
			  </div>
			</div>


		

		
		<el-tabs class="detail" :style='{"border":"0px solid #e9e9e9","boxShadow":"none","margin":"20px auto 40px","background":"#fff","display":"block","width":"100%","order":"40"}' v-model="activeName" type="border-card">
			<el-tab-pane label="个人介绍" name="first">
				<div v-html="detail.gerenjieshao"></div>
			</el-tab-pane>
		</el-tabs>
		<el-dialog title="审核" :visible.sync="sfshVisiable" width="50%">
			<el-form ref="shForm" :model="shForm" label-width="80px">
				<el-form-item label="审核状态">
					<el-select v-model="shForm.sfsh" placeholder="审核状态">
						<el-option label="通过" value="是"></el-option>
						<el-option label="不通过" value="否"></el-option>
						<el-option label="待审核" value="待审核"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="内容">
					<el-input type="textarea" :rows="8" v-model="shForm.shhf"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="sfshVisiable = false">取 消</el-button>
				<el-button type="primary" @click="shHandler">确 定</el-button>
			</div>
		</el-dialog>
	</div>
	<div class="share_view" :style='{"boxShadow":"0 1px 6px rgba(0,0,0,.3)","position":"fixed","right":"0","bottom":"20%","background":"#fff","zIndex":"11"}'>
	</div>
	<el-dialog :visible.sync="chatVisible" @close="clearChat" :title="fname">
		<div class="chat-content" id="chat-content">
			<div v-bind:key="item.id" v-for="item in chatList">
				<div v-if="item.uid==mid" class="right-content">
					<el-alert v-if="item.format==1" class="text-content" :title="item.content" :closable="false"
						type="warning"></el-alert>
					<el-image v-else fit="cover" :src="item.content?baseUrl + item.content:''" style="width: 100px;height: 100px;" :preview-src-list="[item.content?baseUrl + item.content:'']"></el-image>
					<img :src="mpic?baseUrl + mpic:require('@/assets/avator.png')" alt="" style="width: 30px;border-radius: 50%;height: 30px;margin: 0 0 0 10px;" />
				</div>
				<div v-else class="left-content">
					<img :src="fpic?baseUrl + fpic:require('@/assets/avator.png')" alt="" style="width: 30px;border-radius: 50%;height: 30px;margin: 0 10px 0 0;" />
					<el-alert v-if="item.format==1" class="text-content" :title="item.content" :closable="false"
						type="success"></el-alert>
					<el-image v-else fit="cover" :src="item.content?baseUrl + item.content:''" style="width: 100px;height: 100px;" :preview-src-list="[item.content?baseUrl + item.content:'']"></el-image>
					
				</div>
				<div class="clear-float"></div>
			</div>
		</div>
		<div slot="footer" class="dialog-footer">
			<el-input @keydown.enter.native="addChat" v-model="chatForm.content" placeholder="请输入内容" style="width: calc(100% - 180px);float: left;">
			</el-input>
			<el-button :disabled="chatForm.content?false:true" type="primary" @click="addChat">发送</el-button>
			<el-upload style="display: inline-block;margin: 0 0 0 6px;" class="upload-demo" :action="uploadUrl" :on-success="uploadSuccess"
			    :show-file-list="false">
			    <el-button type="success">上传图片</el-button>
			</el-upload>
		</div>
	</el-dialog>
</div>
</template>

<script>
  import CountDown from '@/components/CountDown';
  import axios from 'axios'
  import Swiper from "swiper";
  
  export default {
    //数据集合
    data() {
      return {
        tablename: 'lvshi',
        baseUrl: '',
        breadcrumbItem: [
          {
            name: '律师'
          }
        ],
        title: '',
        detailBanner: [],
		userid: localStorage.getItem('frontUserid'),
		id: 0,
        detail: {},
        activeName: 'first',
        total: 1,
        pageSize: 5,
		pageSizes: [10,20,30,50],
        totalPage: 1,
        storeupParams: {
          name: '',
          picture: '',
          refid: 0,
          tablename: 'lvshi',
          userid: localStorage.getItem('frontUserid')
        },
        isStoreup: false,
        storeupInfo: {},
        buynumber: 1,
        sfshVisiable: false,
        shForm: {
          sfsh: '是',
          shhf: ''
        },
		centerType: false,
		shareUrl: location.href,
		swiperBigUrl: null,
		mid: localStorage.getItem('frontUserid'),
		chatVisible: false,
		chatList: [],
		chatForm: {
			content: ''
		},
		chatTimer: null,
		uploadUrl: this.$config.baseUrl + 'file/upload',
		fpic: '',
		fname: '',
		mpic: localStorage.getItem('frontHeadportrait'),
      }
    },
    created() {
		if(this.$route.query.centerType) {
			this.centerType = true
		}
		
        this.init();
    },
	mounted() {
	},
    //方法集合
    methods: {
		swiperClick3(src) {
			this.swiperBigUrl = src
		},
        init() {
		  this.id = this.$route.query.id
          this.baseUrl = this.$config.baseUrl;
          this.$http.get(this.tablename + '/detail/'  + this.id, {}).then(res => {
            if (res.data.code == 0) {
              this.detail = res.data.data;
              this.title = this.detail.lvshixingming;
              this.detailBanner = this.detail.touxiang ? this.detail.touxiang.split(",") : [];
			  if(res.data.data.touxiang){
			  	this.fpic = res.data.data.touxiang.split(',')[0]
			  }else if(res.data.data.headportrait){
			  	this.fpic = res.data.data.headportrait.split(',')[0]
			  }
			  if(res.data.data.lvshizhanghao){
			  	this.fname = res.data.data.lvshizhanghao
			  }
              this.$forceUpdate();

				if(localStorage.getItem('frontToken')){
					this.getStoreupStatus();
				}

            }
			if (this.detailBanner.length) {
				if (this.detailBanner[0].substr(0,4)=='http') {
					this.swiperBigUrl = this.detailBanner[0]
				} else {
					this.swiperBigUrl = this.baseUrl + this.detailBanner[0]
				}
			}
          });
        },
      async onAcross(acrossTable,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue,type=1){
		if(crossOptAudit=='是'&&this.detail.sfsh!='是') {
			this.$message({
				message: "请审核通过后再操作",
				type: "error",
				duration: 1500,
				onClose: () => {
				}
			});
			return
		}
        localStorage.setItem('crossTable',`lvshi`);
        localStorage.setItem('crossObj', JSON.stringify(this.detail));
        localStorage.setItem('statusColumnName',statusColumnName);
        localStorage.setItem('statusColumnValue',statusColumnValue);
        localStorage.setItem('tips',tips);
        if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
            var obj = JSON.parse(localStorage.getItem('crossObj'));
            for (var o in obj){
                if(o==statusColumnName && obj[o]==statusColumnValue){
                    this.$message({
                        type: 'error',
                        message: tips,
                        duration: 1500
                    });
                    return
                }
            }
        }
        this.$router.push({path: '/index/' + acrossTable + 'Add', query: {type: 'cross'}});
      },
      onSH() {
        this.sfshVisiable = true;
      },
      shHandler(){
        this.$confirm(`确定操作?`, "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.detail.sfsh = this.shForm.sfsh;
          this.detail.shhf = this.shForm.shhf;
          this.$http.post(`${this.tablename}/update`, this.detail).then(res => {
            if (res.data.code == 0) {
              this.sfshVisiable = false;
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
              });
            }
          });
        });
      },
      storeup(type) {
        if (type == 1 && !this.isStoreup) {
          this.storeupParams.name = this.title;
          this.storeupParams.picture = this.detailBanner[0];
          this.storeupParams.refid = this.detail.id;
          this.storeupParams.type = type;
          this.$http.post('storeup/add', this.storeupParams).then(res => {
            if (res.data.code == 0) {
              this.isStoreup = true;
			  this.detail.storeupnum++
			  this.$http.post('lvshi/update', this.detail).then(res => {});
              this.$message({
                type: 'success',
                message: '收藏成功!',
                duration: 1500,
              });
            }
          });
        }
        if (type == -1 && this.isStoreup) {
          this.$http.get('storeup/list', {params: {page: 1, limit: 1, type: 1, refid: this.detail.id, tablename: 'lvshi', userid: localStorage.getItem('frontUserid')}}).then(res => {
            if (res.data.code == 0 && res.data.data.list.length > 0) {
              this.isStoreup = true;
              this.storeupInfo = res.data.data.list[0];
              let delIds = new Array();
              delIds.push(this.storeupInfo.id);
              this.$http.post('storeup/delete', delIds).then(res => {
                if (res.data.code == 0) {
                  this.isStoreup = false;
				  this.detail.storeupnum--
				  this.$http.post('lvshi/update', this.detail).then(res => {});
                  this.$message({
                    type: 'success',
                    message: '取消成功!',
                    duration: 1500,
                  });
                }
              });
            }
          });
        }
      },
      getStoreupStatus(){
        if(localStorage.getItem("frontToken")) {
            this.$http.get('storeup/list', {params: {page: 1, limit: 1, type: 1, refid: this.detail.id, tablename: 'lvshi', userid: localStorage.getItem('frontUserid')}}).then(res => {
              if (res.data.code == 0 && res.data.data.list.length > 0) {
                this.isStoreup = true;
                this.storeupInfo = res.data.data.list[0];
              }
            });
        }
      },
      curChange(page) {
        this.getDiscussList(page);
      },
      prevClick(page) {
        this.getDiscussList(page);
      },
      nextClick(page) {
        this.getDiscussList(page);
      },
		// 返回按钮
		backClick(){
			history.back()
		},
		// 下载
		download(file){
			if(!file) {
				this.$message({
				  type: 'error',
				  message: '文件不存在',
				  duration: 1500,
				});
				return;
			}
		  let arr = file.replace(new RegExp('upload/', "g"), "")
		  axios.get(this.baseUrl + '/file/download?fileName=' + arr, {
		  	headers: {
		  		token: localStorage.getItem("frontToken")
		  	},
		  	responseType: "blob"
		  }).then(({
		  	data
		  }) => {
		  	const binaryData = [];
		  	binaryData.push(data);
		  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
		  		type: 'application/pdf;chartset=UTF-8'
		  	}))
		  	const a = document.createElement('a')
		  	a.href = objectUrl
		  	a.download = arr
		  	// a.click()
		  	// 下面这个写法兼容火狐
		  	a.dispatchEvent(new MouseEvent('click', {
		  		bubbles: true,
		  		cancelable: true,
		  		view: window
		  	}))
		  	window.URL.revokeObjectURL(data)
		  },err=>{
			  axios.get((location.href.split(this.$config.name).length>1 ? location.href.split(this.$config.name)[0] :'') + this.$config.name + '/file/download?fileName=' + arr, {
			  	headers: {
			  		token: localStorage.getItem("frontToken")
			  	},
			  	responseType: "blob"
			  }).then(({
			  	data
			  }) => {
			  	const binaryData = [];
			  	binaryData.push(data);
			  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
			  		type: 'application/pdf;chartset=UTF-8'
			  	}))
			  	const a = document.createElement('a')
			  	a.href = objectUrl
			  	a.download = arr
			  	// a.click()
			  	// 下面这个写法兼容火狐
			  	a.dispatchEvent(new MouseEvent('click', {
			  		bubbles: true,
			  		cancelable: true,
			  		view: window
			  	}))
			  	window.URL.revokeObjectURL(data)
			  })
		  })
      },


		// 权限判断
		btnAuth(tableName,key){
			if(this.centerType){
				return this.isBackAuth(tableName,key)
			}else{
				return this.isAuth(tableName,key)
			}
		},
		// 修改
		editClick(){
			this.$router.push(`/index/lvshiAdd?type=edit&&id=${this.detail.id}`);
		},
		// 删除
		async delClick(){
			await this.$confirm('是否删除此律师？')
			  .then(_ => {
			    this.$http.post('lvshi/delete', [this.detail.id]).then(async res => {
					if (res.data.code == 0) {
						this.$http.get('storeup/list',{params:{
							page: 1,
							limit: 100,
							refid: this.detail.id,
							tablename: 'lvshi',
						}}).then(async obj=>{
							if(obj.data&&obj.data.code==0){
								let arr = []
								for(let x in obj.data.data.list){
									arr.push(obj.data.data.list[x].id)
								}
								await this.$http.post('storeup/delete',arr).then(()=>{})
								this.$message({
									type: 'success',
									message: '删除成功!',
									duration: 1500,
									onClose: () => {
										history.back()
									}
								});
							}
						})
					}
			    });
			  }).catch(_ => {});
		},
		chatClick() {
			this.getChatList()
			this.chatVisible = true
		},
		getChatList() {
			this.$http.get('chatmessage/mlist', {
				params: {
					page: 1,
					limit: 1000,
					uid: localStorage.getItem('frontUserid'),
					fid: this.detail.id
				}
			}).then(res => {
				if (res.data && res.data.code == 0) {
					this.chatList = res.data.data.list
					let div = document.getElementsByClassName('chat-content')[0]
					setTimeout(() => {
						if (div)
							div.scrollTop = div.scrollHeight
					}, 0)
					this.chatTimer = setTimeout(() => {
						this.getChatList()
					}, 5000)
				}
			})
		},
		clearChat(){
			clearTimeout(this.chatTimer)
		},
		uploadSuccess(res) {
		    if (res.code == 0) {
				clearTimeout(this.chatTimer)
				this.$http.get('friend/page', {
					params: {
						uid: localStorage.getItem('frontUserid'),
						fid: this.detail.id,
					}
				}).then(obj => {
					if (obj.data && obj.data.code == 0) {
						if (!obj.data.data.list.length) {
							this.$http.post('friend/add', {
								uid: localStorage.getItem('frontUserid'),
								fid: this.detail.id,
								name: this.fname,
								picture: this.fpic,
								type: 2,
								tablename: 'lvshi'
							}).then(res => {
								this.$http.post('friend/add', {
									uid: this.detail.id,
									fid: localStorage.getItem('frontUserid'),
									type: 2,
									tablename: localStorage.getItem('frontSessionTable'),
									name: localStorage.getItem('username'),
									picture: this.mpic,
								}).then(res1 => {
				
								})
							})
						}
						this.$http.post('chatmessage/add', {
							uid: localStorage.getItem('frontUserid'),
							fid: this.detail.id,
							content: 'upload/' + res.file,
							format: 2
						}).then(res2 => {
							this.chatForm = {
								content: ''
							}
							this.getChatList()
						})
					}
				})
		    }
		},
		addChat() {
			clearTimeout(this.chatTimer)
			this.$http.get('friend/page', {
				params: {
					uid: localStorage.getItem('frontUserid'),
					fid: this.detail.id,
				}
			}).then(obj => {
				if (obj.data && obj.data.code == 0) {
					if (!obj.data.data.list.length) {
						this.$http.post('friend/add', {
							uid: localStorage.getItem('frontUserid'),
							fid: this.detail.id,
							name: this.fname,
							picture: this.fpic,
							type: 2,
							tablename: 'yonghu'
						}).then(res => {
							this.$http.post('friend/add', {
								uid: this.detail.id,
								fid: localStorage.getItem('frontUserid'),
								type: 2,
								tablename: localStorage.getItem('frontSessionTable'),
								name: localStorage.getItem('username'),
								picture: this.mpic,
							}).then(res1 => {
		
							})
						})
					}
					this.$http.post('chatmessage/add', {
						uid: localStorage.getItem('frontUserid'),
						fid: this.detail.id,
						content: this.chatForm.content,
						format: 1
					}).then(res2 => {
						this.chatForm = {
							content: ''
						}
						this.getChatList()
					})
				}
			})
		},
    },
    components: {
      CountDown
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.editor /deep/ .avatar-uploader {
		height: 0;
		line-height: 0;
	}
	
	.detail-preview {
	
	  .attr {
	    .el-carousel /deep/ .el-carousel__indicator button {
	      width: 0;
	      height: 0;
	      display: none;
	    }
	
	    .el-input-number__decrease:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled), .el-input-number__increase:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled) {
	      border-color: none;
	    }
	  }
	
	  .detail {
	    & /deep/ .el-tabs__header .el-tabs__nav-wrap {
	      margin-bottom: 0;
	    }
	
	    & .add .el-textarea {
	      width: auto;
	    }
	  }
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: red;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: red;
	}

	.attr .el-carousel /deep/ .el-carousel__indicators {
		padding: 0;
		margin: 0;
		z-index: 2;
		position: absolute;
		list-style: none;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li:hover {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 0.7;
		height: 12px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li.is-active {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 1;
		height: 12px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__decrease {
		cursor: pointer;
		margin: 0 0 0 -1px;
		display: flex;
		border-color: #DCDFE6;
		border-radius: 0px 0 0 0px;
		background: #fff;
		width: 80px;
		justify-content: center;
		border-width: 1px 1px 1px 0;
		align-items: center;
		position: inherit;
		border-style: solid;
		text-align: center;
		height: 36px;
		order: 3;
	}
	
	.attr .el-input-number /deep/ .el-input-number__decrease i {
		color: #000;
		font-size: 14px;
	}

	.attr .el-input-number /deep/ .el-input-number__increase {
		cursor: pointer;
		margin: 0 -1px 0 0;
		display: flex;
		border-color: #ddd;
		border-radius: 0;
		background: #fff;
		width: 80px;
		justify-content: center;
		border-width: 1px 0 1px 1px;
		align-items: center;
		position: inherit;
		border-style: solid;
		text-align: center;
		height: 36px;
		order: 0;
	}
	
	.attr .el-input-number /deep/ .el-input-number__increase i {
		color: #000;
		font-size: 14px;
	}
	
	.attr .el-input-number /deep/ .el-input .el-input__inner {
		border: 1px solid #ddd;
		padding: 0;
		margin: 1px 0 0;
		color: #666;
		display: inline-block;
		font-size: 14px;
		line-height: 36px;
		border-radius: 0px;
		outline: none;
		background: #fff;
		width: 100%;
		position: inherit;
		text-align: center;
		height: 36px;
		order: 2;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header {
		margin: 0;
		background: #f6f6f6;
		border-color: #e9e9e9;
		border-width: 1px 0 1px 0;
		border-style: solid;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item {
		border: 0;
		padding: 0 20px;
		margin: 0;
		color: #999;
		font-weight: 500;
		display: inline-block;
		font-size: 16px;
		border-color: #f6f6f6 #e9e9e9;
		line-height: 60px;
		transition: all 0s;
		background: none;
		border-width: 6px 1px 0 0;
		position: relative;
		border-style: solid;
		list-style: none;
		text-align: center;
		min-width: 120px;
		height: 60px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
		color: #1e88bd;
		background: none;
		border-color: #1e88bd #e9e9e9;
		border-width: 6px 1px 0 0;
		border-style: solid;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
		border: 0;
		color: #1e88bd;
		background: none;
		font-size: 16px;
		border-color: #1e88bd #e9e9e9;
		border-width: 6px 1px 0 0;
		line-height: 60px;
		border-style: solid;
		text-align: center;
		min-width: 120px;
		height: 60px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__content {
		padding: 15px;
	}
	
	.detail-preview .detail.el-tabs .add /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #666;
		width: 80px;
		font-size: 14px;
		line-height: 40px;
		text-align: right;
	}
	
	.detail-preview .detail.el-tabs .add /deep/ .el-textarea__inner {
	}
	
	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__separator {
		margin: 0 9px;
		color: #ccc;
		font-weight: 500;
	}
	
	.breadcrumb-preview .el-breadcrumb .item1 /deep/ .el-breadcrumb__inner a {
		color: #999;
		display: inline-block;
	}
	
	.breadcrumb-preview .el-breadcrumb .item2 /deep/ .el-breadcrumb__inner a {
		color: #999;
		display: inline-block;
	}
		
	.breadcrumb-preview .el-breadcrumb .item3 /deep/ .el-breadcrumb__inner a {
		color: #999;
		display: inline-block;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__total {
		margin: 0 10px 0 0;
		color: #666;
		font-weight: 400;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-prev {
		border: none;
		border-radius: 20px;
		padding: 0 16px;
		margin: 0 5px;
		color: #fff;
		background: #3795c4;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-next {
		border: none;
		border-radius: 20px;
		padding: 0 16px;
		margin: 0 5px;
		color: #fff;
		background: #3795c4;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-prev:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 20px;
		padding: 0 16px;
		margin: 0 5px;
		color: #666;
		background: #dfdfdf;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-next:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 20px;
		padding: 0 16px;
		margin: 0 5px;
		color: #666;
		background: #dfdfdf;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pager {
		padding: 0;
		margin: 0;
		display: inline-block;
		vertical-align: top;
	}
	
	#pagination.el-pagination /deep/ .el-pager .number {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #666;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 100%;
		background: #dfdfdf;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pager .number:hover {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #fff;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 100%;
		background: #3795c4;
		text-align: center;
		min-width: 30px;
		height: 28px;
}

#pagination.el-pagination /deep/ .el-pager .number.active {
		cursor: default;
		padding: 0 4px;
		margin: 0 5px;
		color: #FFF;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 100%;
		background: #3795c4;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes {
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input {
		margin: 0 5px;
		width: 100px;
		position: relative;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 25px 0 8px;
		color: #606266;
		display: inline-block;
		font-size: 13px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
		top: 0;
		position: absolute;
		right: 0;
		height: 100%;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
		cursor: pointer;
		color: #C0C4CC;
		width: 25px;
		font-size: 14px;
		line-height: 28px;
		text-align: center;
	}

	#pagination.el-pagination /deep/ .el-pagination__jump {
		margin: 0 0 0 24px;
		color: #606266;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__jump .el-input {
		border-radius: 3px;
		padding: 0 2px;
		margin: 0 2px;
		display: inline-block;
		width: 50px;
		font-size: 14px;
		line-height: 18px;
		position: relative;
		text-align: center;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 3px;
		color: #606266;
		display: inline-block;
		font-size: 14px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	.share_view{
		position: fixed;
		right:0;
		bottom: 20%;
		background: #fff;
		box-shadow: 0 4px 6px rgba(0,0,0,.1);
		.share{
			width: 40px;
			height: 40px;
			display: flex;
			align-items: center;
			justify-content: center;
			border-bottom: 1px solid #eee;
			cursor: pointer;
		}
		.share:last-of-type{
			border:none;
		}
	}


	.detail-preview .el-rate /deep/ .el-rate__item {
				cursor: pointer;
				display: inline-block;
				vertical-align: middle;
				font-size: 0;
				position: relative;
			}
	
	.detail-preview .el-rate /deep/ .el-rate__item .el-rate__icon {
				margin: 0 3px;
				display: block;
				font-size: 18px;
				position: relative;
				transition: .3s;
			}
	.chat-content {
		padding-bottom: 20px;
		width: 100%;
		margin-bottom: 10px;
		max-height: 300px;
		height: 300px;
		overflow-y: scroll;
		border: 1px solid #eeeeee;
		background: #fff;
	
		.left-content {
			float: left;
			margin-bottom: 10px;
			padding: 10px;
			max-width: 80%;
			display: flex;
			align-items: center;
		}
	
		.right-content {
			float: right;
			margin-bottom: 10px;
			padding: 10px;
			max-width: 80%;
			display: flex;
			align-items: center;
		}
	}
	
	.clear-float {
		clear: both;
	}
</style>
