new Vue({
    el:"#app",
    data:{
        user:{
            id:"",
            username:"",
            password:"",
            email:"",
            age:"",
            sex:""
        },
        userList:[]
    },
    methods:{
        findAll:function () {
            //在当前方法中定义一个变量  表明是vue对象
            var _this=this;
            axios.get("/vue_ssm/user/findAll.do")
                .then(function (response) {
                    _this.userList=response.data;//响应数据 给userlist 赋值 this是axios里面的this 不是vue的this不能这样写

                    console.log(response)
                })
                .catch(function (reason) {
                    console.log(reason)
                })

        },
        findById:function (userid) {
            //在当前方法中定义一个变量  表明是vue对象
            var _this=this;
            axios.get("/vue_ssm/user/findById.do",{params:{id:userid}})
                .then(function (response) {
                    _this.user=response.data;//响应数据 给userlist 赋值 this是axios里面的this 不是vue的this不能这样写
                    $("#myModal").modal("show");
                })
                .catch(function (reason) {
                    console.log(reason)
                })
        },
        update:function (user) {
                //post请求
            //在当前方法中定义一个变量  表明是vue对象
            var _this=this;
            axios.post("/vue_ssm/user/updateUser.do",_this.user)
                .then(function (response) {
                    _this.findAll()
                })
        }
    },
    created:function () {//当我们页面加载的时候 触发请求 查询所有
        this.findAll();
    }
})