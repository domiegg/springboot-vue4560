const base = {
    get() {
        return {
            url : "http://localhost:8080/springbooteozac1c1/",
            name: "springbooteozac1c1",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbooteozac1c1/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "找律师系统"
        } 
    }
}
export default base
