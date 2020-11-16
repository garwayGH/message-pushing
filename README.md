框架说明
==
###注意！注意！注意！
在打开配置文件前，请先设置IDE的编码为utf-8，不然配置文件会有可能乱码  
同时startup文件夹下的启动脚本，请确保是Unix编码，不然在linux系统启动会报错  
自定义配置文件的key和value都别用中文，不然在服务器部署的时候会乱码
###前言
推荐使用IDEA作为项目的开发工具  
项目使用了lombok插件，IDEA对于集成lombok很方便

###项目架构：
* JDK 1.8
* Springboot
* Swagger
  * 使用了Swagger2作为接口文档 路径为：host:port/swagger-ui.html
* Mybatis
  * 使用了pageHelper插件来进行数据分页
* Druid连接池 监控页面：ip:port/druid/login.html
* maven 3.6.3
  * maven采用了分环境方式来打包，同时使用了assembly插件来进行自定义打包
  * maven打包命令：mvn clean package -Dmaven.test.skip=true -Ptest （PS：其中-P后面可选dev/test/pro）