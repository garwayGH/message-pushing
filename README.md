##框架说明
项目架构：
* Springboot
* Mybatis
* Druid连接池
* maven
  * maven采用了分环境方式来打包，同时使用了assembly插件来进行自定义打包
  * maven打包命令：mvn clean package -Dmaven.test.skip=true -Ptest （PS：其中-P后面可选dev/test/pro）