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

     import users from '@/views/modules/users/list'
    import bumenlingdao from '@/views/modules/bumenlingdao/list'
    import caiwurenyuan from '@/views/modules/caiwurenyuan/list'
    import dictionary from '@/views/modules/dictionary/list'
    import news from '@/views/modules/news/list'
    import renshi from '@/views/modules/renshi/list'
    import singleSeach from '@/views/modules/singleSeach/list'
    import tongzhi from '@/views/modules/tongzhi/list'
    import xinzi from '@/views/modules/xinzi/list'
    import yeji from '@/views/modules/yeji/list'
    import yuangong from '@/views/modules/yuangong/list'
    import config from '@/views/modules/config/list'
    import dictionaryBumen from '@/views/modules/dictionaryBumen/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionarySingleSeach from '@/views/modules/dictionarySingleSeach/list'
    import dictionaryTongzhi from '@/views/modules/dictionaryTongzhi/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
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
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryBumen',
        name: '部门',
        component: dictionaryBumen
    }
    ,{
        path: '/dictionaryNews',
        name: '新闻类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionarySingleSeach',
        name: '单页数据类型',
        component: dictionarySingleSeach
    }
    ,{
        path: '/dictionaryTongzhi',
        name: '通知类型',
        component: dictionaryTongzhi
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/bumenlingdao',
        name: '部门领导',
        component: bumenlingdao
      }
    ,{
        path: '/caiwurenyuan',
        name: '财务人员',
        component: caiwurenyuan
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/news',
        name: '新闻信息',
        component: news
      }
    ,{
        path: '/renshi',
        name: '人事人员',
        component: renshi
      }
    ,{
        path: '/singleSeach',
        name: '单页数据',
        component: singleSeach
      }
    ,{
        path: '/tongzhi',
        name: '通知信息',
        component: tongzhi
      }
    ,{
        path: '/xinzi',
        name: '薪资',
        component: xinzi
      }
    ,{
        path: '/yeji',
        name: '业绩',
        component: yeji
      }
    ,{
        path: '/yuangong',
        name: '普通员工',
        component: yuangong
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
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
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

export default router;
