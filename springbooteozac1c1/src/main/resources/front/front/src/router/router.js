import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import lvshiList from '../pages/lvshi/list'
import lvshiDetail from '../pages/lvshi/detail'
import lvshiAdd from '../pages/lvshi/add'
import zhuanyelingyuList from '../pages/zhuanyelingyu/list'
import zhuanyelingyuDetail from '../pages/zhuanyelingyu/detail'
import zhuanyelingyuAdd from '../pages/zhuanyelingyu/add'
import diquxinxiList from '../pages/diquxinxi/list'
import diquxinxiDetail from '../pages/diquxinxi/detail'
import diquxinxiAdd from '../pages/diquxinxi/add'
import zaixianyuyueList from '../pages/zaixianyuyue/list'
import zaixianyuyueDetail from '../pages/zaixianyuyue/detail'
import zaixianyuyueAdd from '../pages/zaixianyuyue/add'
import ziyuanfenleiList from '../pages/ziyuanfenlei/list'
import ziyuanfenleiDetail from '../pages/ziyuanfenlei/detail'
import ziyuanfenleiAdd from '../pages/ziyuanfenlei/add'
import falvziyuanList from '../pages/falvziyuan/list'
import falvziyuanDetail from '../pages/falvziyuan/detail'
import falvziyuanAdd from '../pages/falvziyuan/add'
import anlikuList from '../pages/anliku/list'
import anlikuDetail from '../pages/anliku/detail'
import anlikuAdd from '../pages/anliku/add'
import anlileixingList from '../pages/anlileixing/list'
import anlileixingDetail from '../pages/anlileixing/detail'
import anlileixingAdd from '../pages/anlileixing/add'
import falvxinwenList from '../pages/falvxinwen/list'
import falvxinwenDetail from '../pages/falvxinwen/detail'
import falvxinwenAdd from '../pages/falvxinwen/add'
import chatmessageList from '../pages/chatmessage/list'
import chatmessageDetail from '../pages/chatmessage/detail'
import chatmessageAdd from '../pages/chatmessage/add'
import friendList from '../pages/friend/list'
import friendDetail from '../pages/friend/detail'
import friendAdd from '../pages/friend/add'
import discussfalvziyuanList from '../pages/discussfalvziyuan/list'
import discussfalvziyuanDetail from '../pages/discussfalvziyuan/detail'
import discussfalvziyuanAdd from '../pages/discussfalvziyuan/add'
import discussanlikuList from '../pages/discussanliku/list'
import discussanlikuDetail from '../pages/discussanliku/detail'
import discussanlikuAdd from '../pages/discussanliku/add'
import discussfalvxinwenList from '../pages/discussfalvxinwen/list'
import discussfalvxinwenDetail from '../pages/discussfalvxinwen/detail'
import discussfalvxinwenAdd from '../pages/discussfalvxinwen/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'lvshi',
					component: lvshiList
				},
				{
					path: 'lvshiDetail',
					component: lvshiDetail
				},
				{
					path: 'lvshiAdd',
					component: lvshiAdd
				},
				{
					path: 'zhuanyelingyu',
					component: zhuanyelingyuList
				},
				{
					path: 'zhuanyelingyuDetail',
					component: zhuanyelingyuDetail
				},
				{
					path: 'zhuanyelingyuAdd',
					component: zhuanyelingyuAdd
				},
				{
					path: 'diquxinxi',
					component: diquxinxiList
				},
				{
					path: 'diquxinxiDetail',
					component: diquxinxiDetail
				},
				{
					path: 'diquxinxiAdd',
					component: diquxinxiAdd
				},
				{
					path: 'zaixianyuyue',
					component: zaixianyuyueList
				},
				{
					path: 'zaixianyuyueDetail',
					component: zaixianyuyueDetail
				},
				{
					path: 'zaixianyuyueAdd',
					component: zaixianyuyueAdd
				},
				{
					path: 'ziyuanfenlei',
					component: ziyuanfenleiList
				},
				{
					path: 'ziyuanfenleiDetail',
					component: ziyuanfenleiDetail
				},
				{
					path: 'ziyuanfenleiAdd',
					component: ziyuanfenleiAdd
				},
				{
					path: 'falvziyuan',
					component: falvziyuanList
				},
				{
					path: 'falvziyuanDetail',
					component: falvziyuanDetail
				},
				{
					path: 'falvziyuanAdd',
					component: falvziyuanAdd
				},
				{
					path: 'anliku',
					component: anlikuList
				},
				{
					path: 'anlikuDetail',
					component: anlikuDetail
				},
				{
					path: 'anlikuAdd',
					component: anlikuAdd
				},
				{
					path: 'anlileixing',
					component: anlileixingList
				},
				{
					path: 'anlileixingDetail',
					component: anlileixingDetail
				},
				{
					path: 'anlileixingAdd',
					component: anlileixingAdd
				},
				{
					path: 'falvxinwen',
					component: falvxinwenList
				},
				{
					path: 'falvxinwenDetail',
					component: falvxinwenDetail
				},
				{
					path: 'falvxinwenAdd',
					component: falvxinwenAdd
				},
				{
					path: 'chatmessage',
					component: chatmessageList
				},
				{
					path: 'chatmessageDetail',
					component: chatmessageDetail
				},
				{
					path: 'chatmessageAdd',
					component: chatmessageAdd
				},
				{
					path: 'friend',
					component: friendList
				},
				{
					path: 'friendDetail',
					component: friendDetail
				},
				{
					path: 'friendAdd',
					component: friendAdd
				},
				{
					path: 'discussfalvziyuan',
					component: discussfalvziyuanList
				},
				{
					path: 'discussfalvziyuanDetail',
					component: discussfalvziyuanDetail
				},
				{
					path: 'discussfalvziyuanAdd',
					component: discussfalvziyuanAdd
				},
				{
					path: 'discussanliku',
					component: discussanlikuList
				},
				{
					path: 'discussanlikuDetail',
					component: discussanlikuDetail
				},
				{
					path: 'discussanlikuAdd',
					component: discussanlikuAdd
				},
				{
					path: 'discussfalvxinwen',
					component: discussfalvxinwenList
				},
				{
					path: 'discussfalvxinwenDetail',
					component: discussfalvxinwenDetail
				},
				{
					path: 'discussfalvxinwenAdd',
					component: discussfalvxinwenAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
