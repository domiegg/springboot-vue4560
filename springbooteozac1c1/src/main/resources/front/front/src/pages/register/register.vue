<template>
	<div>

	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20240305/c46698d0e9e14ad1b5729fb8a33a6d90.jpg)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form class='rgs-form' v-if="pageFlag=='register'" :style='{"minHeight":"800px","padding":"20px 2vw 0 5vw","margin":"40px auto 40px","borderRadius":"0px","flexWrap":"wrap","background":"#fff","display":"flex","width":"40vw","position":"relative","height":"auto"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="false" :style='{"width":"100%","margin":"0 0 10px 0","lineHeight":"44px","fontSize":"20px","color":"rgba(64, 158, 255, 1)","textAlign":"center"}'>USER / REGISTER</div>
			<div v-if="true" :style='{"margin":"20px auto 20px","color":"#2a8ec0","textAlign":"center","width":"90%","letterSpacing":"2px","lineHeight":"44px","fontSize":"32px","fontWeight":"600"}'>找律师系统注册</p></div>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='yonghu'" prop="zhanghao">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('zhanghao')?'required':''">账号：</div>
				<el-input v-model="registerForm.zhanghao"  placeholder="请输入账号" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='yonghu'" prop="mima">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='yonghu'" prop="mima2">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='yonghu'" prop="xingming">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('xingming')?'required':''">姓名：</div>
				<el-input v-model="registerForm.xingming"  placeholder="请输入姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='yonghu'" prop="xingbie">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('xingbie')?'required':''">性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in yonghuxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='yonghu'" prop="shouji">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('shouji')?'required':''">手机：</div>
				<el-input v-model="registerForm.shouji"  placeholder="请输入手机" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='yonghu'" prop="touxiang">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('touxiang')?'required':''">头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="yonghutouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='lvshi'" prop="lvshizhanghao">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('lvshizhanghao')?'required':''">律师账号：</div>
				<el-input v-model="registerForm.lvshizhanghao"  placeholder="请输入律师账号" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='lvshi'" prop="mima">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='lvshi'" prop="mima2">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='lvshi'" prop="lvshixingming">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('lvshixingming')?'required':''">律师姓名：</div>
				<el-input v-model="registerForm.lvshixingming"  placeholder="请输入律师姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='lvshi'" prop="nianling">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('nianling')?'required':''">年龄：</div>
				<el-input v-model.number="registerForm.nianling"  placeholder="请输入年龄" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='lvshi'" prop="xingbie">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('xingbie')?'required':''">性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in lvshixingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='lvshi'" prop="lvshidengji">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('lvshidengji')?'required':''">律师等级：</div>
                <el-select v-model="registerForm.lvshidengji" placeholder="请选择律师等级" >
                  <el-option
                      v-for="(item,index) in lvshilvshidengjiOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='lvshi'" prop="touxiang">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('touxiang')?'required':''">头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="lvshitouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='lvshi'" prop="zhuanyelingyu">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('zhuanyelingyu')?'required':''">专业领域：</div>
                <el-select v-model="registerForm.zhuanyelingyu" placeholder="请选择专业领域" >
                  <el-option
                      v-for="(item,index) in lvshizhuanyelingyuOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='lvshi'" prop="diqu">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('diqu')?'required':''">地区：</div>
                <el-select v-model="registerForm.diqu" placeholder="请选择地区" >
                  <el-option
                      v-for="(item,index) in lvshidiquOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='lvshi'" prop="lianxidianhua">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-150px","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
				<el-input v-model="registerForm.lianxidianhua"  placeholder="请输入联系电话" />
			</el-form-item>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 auto","color":"#fff","display":"block","outline":"none","borderRadius":"4px","background":"#3795c4","width":"400px","fontSize":"16px","height":"50px","order":"30"}' type="primary" @click="submitForm('registerForm')">注册</el-button>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 0px","margin":"0px auto","color":"#999","textAlign":"right","display":"none","outline":"none","borderRadius":"4px","background":"none","width":"400px","fontSize":"14px","height":"44px","order":"40"}' @click="resetForm('registerForm')">重置</el-button>
			<router-link :style='{"cursor":"pointer","padding":"0 0px","margin":"12px auto 20px","color":"#3795c4","textAlign":"center","display":"block","width":"400px","lineHeight":"1","fontSize":"14px","textDecoration":"none","order":"50"}' to="/login">已有账户登录</router-link>
			<div class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"40px"}'></div>
			<div class="idea2" :style='{"width":"100%","background":"blue","display":"none","height":"40px"}'></div>
		</el-form>
    </div>
  </div>
</div>
</template>

<script>

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {},
			forgetForm: {},
			rules: {},
			requiredRules: {},
            yonghuxingbieOptions: [],
            lvshixingbieOptions: [],
            lvshilvshidengjiOptions: [],
            lvshizhuanyelingyuOptions: [],
            lvshidiquOptions: [],
		}
    },
	mounted() {
		if(this.$route.query.pageFlag=='register'){
			this.tableName = this.$route.query.role;
			if(this.tableName=='yonghu'){
				this.registerForm = {
					zhanghao: '',
					mima: '',
					mima2: '',
					xingming: '',
					xingbie: '',
					shouji: '',
					touxiang: '',
					status: '',
				}
			}
			if(this.tableName=='lvshi'){
				this.registerForm = {
					lvshizhanghao: '',
					mima: '',
					mima2: '',
					lvshixingming: '',
					nianling: '',
					xingbie: '',
					lvshidengji: '',
					touxiang: '',
					zhuanyelingyu: '',
					diqu: '',
					lianxidianhua: '',
					gerenjieshao: '',
					sfsh: '',
					shhf: '',
					clicktime: '',
					clicknum: '',
					storeupnum: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.requiredRules.zhanghao = [{ required: true, message: '请输入账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.requiredRules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }]
			}
			if ('lvshi' == this.tableName) {
				this.requiredRules.lvshizhanghao = [{ required: true, message: '请输入律师账号', trigger: 'blur' }]
			}
			if ('lvshi' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('lvshi' == this.tableName) {
				this.requiredRules.lvshixingming = [{ required: true, message: '请输入律师姓名', trigger: 'blur' }]
			}
			if ('lvshi' == this.tableName) {
				this.requiredRules.lvshidengji = [{ required: true, message: '请输入律师等级', trigger: 'blur' }]
			}
		}
	},
    created() {
		this.pageFlag = this.$route.query.pageFlag;
		if(this.$route.query.pageFlag=='register'){
		  if ('yonghu' == this.tableName) {
			this.rules.zhanghao = [{ required: true, message: '请输入账号', trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }];
		  }
			this.yonghuxingbieOptions = "男,女".split(',');
		  if ('yonghu' == this.tableName) {
			this.rules.shouji = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.status = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
		  }
		  if ('lvshi' == this.tableName) {
			this.rules.lvshizhanghao = [{ required: true, message: '请输入律师账号', trigger: 'blur' }];
		  }
		  if ('lvshi' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
		  if ('lvshi' == this.tableName) {
			this.rules.lvshixingming = [{ required: true, message: '请输入律师姓名', trigger: 'blur' }];
		  }
		  if ('lvshi' == this.tableName) {
			this.rules.nianling = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
		  }
			this.lvshixingbieOptions = "男,女".split(',');
			this.lvshilvshidengjiOptions = "金牌律师,优秀律师,专业律师".split(',');
		  if ('lvshi' == this.tableName) {
			this.rules.lvshidengji = [{ required: true, message: '请输入律师等级', trigger: 'blur' }];
		  }
			this.$http({
			  url: `option/zhuanyelingyu/zhuanyelingyu`,
			  method: "get",
			  params: {}
			}).then(({ data }) => {
			  if (data && data.code === 0) {
				  this.lvshizhuanyelingyuOptions = data.data;
			  }
			});
			this.$http({
			  url: `option/diquxinxi/diqu`,
			  method: "get",
			  params: {}
			}).then(({ data }) => {
			  if (data && data.code === 0) {
				  this.lvshidiquOptions = data.data;
			  }
			});
		  if ('lvshi' == this.tableName) {
			this.rules.lianxidianhua = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
		  }
		  if ('lvshi' == this.tableName) {
			this.rules.clicknum = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
		  }
		  if ('lvshi' == this.tableName) {
			this.rules.storeupnum = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
		  }
		}
    },
    //方法集合
    methods: {
		changeRules(name){
			if(this.requiredRules[name]){
				return true
			}
			return false
		},
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
        // 下二随
      yonghutouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      lvshitouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },

        // 多级联动参数


      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var url=this.tableName+"/register";
				if((!this.registerForm.zhanghao) && `yonghu` == this.tableName){
					this.$message.error(`账号不能为空`);
					return
				}
               if(`yonghu` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `yonghu` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
				if((!this.registerForm.xingming) && `yonghu` == this.tableName){
					this.$message.error(`姓名不能为空`);
					return
				}
					if(`yonghu` == this.tableName && this.registerForm.shouji &&(!this.$validate.isMobile2(this.registerForm.shouji))){
						this.$message.error(`手机应输入手机格式`);
						return
					}
			  if(this.tableName=='lvshi'){
				  this.registerForm.sfsh = '待审核'
			  }
				if((!this.registerForm.lvshizhanghao) && `lvshi` == this.tableName){
					this.$message.error(`律师账号不能为空`);
					return
				}
               if(`lvshi` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `lvshi` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
				if((!this.registerForm.lvshixingming) && `lvshi` == this.tableName){
					this.$message.error(`律师姓名不能为空`);
					return
				}
				if(`lvshi` == this.tableName && this.registerForm.nianling &&(!this.$validate.isIntNumer2(this.registerForm.nianling))){
					this.$message.error(`年龄应输入整数`);
					return
				}
				if((!this.registerForm.lvshidengji) && `lvshi` == this.tableName){
					this.$message.error(`律师等级不能为空`);
					return
				}
					if(`lvshi` == this.tableName && this.registerForm.lianxidianhua &&(!this.$validate.isMobile2(this.registerForm.lianxidianhua))){
						this.$message.error(`联系电话应输入手机格式`);
						return
					}
            this.$http.post(url, this.registerForm).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: '注册成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.$router.push('/login');
                  }
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20240305/c46698d0e9e14ad1b5729fb8a33a6d90.jpg);
		
		.el-input {
		  width: auto;
		}
		
		.el-date-editor.el-input {
			width: auto;
		}
		
		.el-form-item /deep/ .el-form-item__content {
						display: flex;
						flex-wrap: wrap;
					}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border-radius: 8px;
						padding: 0 10px;
						outline: none;
						color: #666;
						background: #fff;
						width: 400px;
						font-size: 14px;
						border-color: #c6c6c6;
						border-width: 2px;
						border-style: solid;
						height: 50px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border-radius: 8px;
						padding: 0 10px;
						outline: none;
						color: #666;
						background: #fff;
						width: 400px;
						font-size: 14px;
						border-color: #c6c6c6;
						border-width: 2px;
						border-style: solid;
						min-width: 300px;
						height: 50px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 8px;
						padding: 0 10px 0 30px;
						outline: none;
						color: #666;
						background: #fff;
						width: 400px;
						font-size: 14px;
						border-color: #c6c6c6;
						border-width: 2px;
						border-style: solid;
						min-width: 300px;
						height: 50px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 8px;
						padding: 0 10px 0 30px;
						outline: none;
						color: #666;
						background: #fff;
						width: 400px;
						font-size: 14px;
						border-color: #c6c6c6;
						border-width: 2px;
						border-style: solid;
						min-width: 300px;
						height: 50px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  cursor: pointer;
		  		  color: #c6c6c6;
		  		  font-weight: 600;
		  		  font-size: 24px;
		  		  border-color: #c6c6c6;
		  		  line-height: 80px;
		  		  border-radius: 4px;
		  		  background: #fff;
		  		  width: 80px;
		  		  border-width: 2px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  cursor: pointer;
		  		  color: #c6c6c6;
		  		  font-weight: 600;
		  		  font-size: 24px;
		  		  border-color: #c6c6c6;
		  		  line-height: 80px;
		  		  border-radius: 4px;
		  		  background: #fff;
		  		  width: 80px;
		  		  border-width: 2px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  cursor: pointer;
		  		  color: #c6c6c6;
		  		  font-weight: 600;
		  		  font-size: 24px;
		  		  border-color: #c6c6c6;
		  		  line-height: 80px;
		  		  border-radius: 4px;
		  		  background: #fff;
		  		  width: 80px;
		  		  border-width: 2px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 80px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				left: 140px;
				position: absolute;
				content: "*";
				order: 2;
			}
</style>
