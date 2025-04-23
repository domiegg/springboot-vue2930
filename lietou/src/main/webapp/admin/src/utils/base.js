const base = {
    get() {
        return {
            url : "http://localhost:8080/lietou/",
            name: "lietou",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/lietou/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "猎头公司管理系统"
        } 
    }
}
export default base
