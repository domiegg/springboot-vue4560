import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import falvziyuan from '@/views/modules/falvziyuan/list'
    import lvshi from '@/views/modules/lvshi/list'
    import discussfalvxinwen from '@/views/modules/discussfalvxinwen/list'
    import diquxinxi from '@/views/modules/diquxinxi/list'
    import forum from '@/views/modules/forum/list'
    import anliku from '@/views/modules/anliku/list'
    import discussfalvziyuan from '@/views/modules/discussfalvziyuan/list'
    import zhuanyelingyu from '@/views/modules/zhuanyelingyu/list'
    import yonghu from '@/views/modules/yonghu/list'
    import falvxinwen from '@/views/modules/falvxinwen/list'
    import anlileixing from '@/views/modules/anlileixing/list'
    import discussanliku from '@/views/modules/discussanliku/list'
    import zaixianyuyue from '@/views/modules/zaixianyuyue/list'
    import ziyuanfenlei from '@/views/modules/ziyuanfenlei/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/falvziyuan',
        name: '法律资源',
        component: falvziyuan
      }
      ,{
	path: '/lvshi',
        name: '律师',
        component: lvshi
      }
      ,{
	path: '/discussfalvxinwen',
        name: '法律新闻评论',
        component: discussfalvxinwen
      }
      ,{
	path: '/diquxinxi',
        name: '地区信息',
        component: diquxinxi
      }
      ,{
	path: '/forum',
        name: '法律论坛',
        component: forum
      }
      ,{
	path: '/anliku',
        name: '案例库',
        component: anliku
      }
      ,{
	path: '/discussfalvziyuan',
        name: '法律资源评论',
        component: discussfalvziyuan
      }
      ,{
	path: '/zhuanyelingyu',
        name: '专业领域',
        component: zhuanyelingyu
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/falvxinwen',
        name: '法律新闻',
        component: falvxinwen
      }
      ,{
	path: '/anlileixing',
        name: '案例类型',
        component: anlileixing
      }
      ,{
	path: '/discussanliku',
        name: '案例库评论',
        component: discussanliku
      }
      ,{
	path: '/zaixianyuyue',
        name: '在线预约',
        component: zaixianyuyue
      }
      ,{
	path: '/ziyuanfenlei',
        name: '资源分类',
        component: ziyuanfenlei
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
