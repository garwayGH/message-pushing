框架说明
==
###注意！注意！注意！
在打开配置文件前，请先设置IDE的编码为utf-8，不然配置文件会有可能乱码  
同时startup文件夹下的启动脚本，请确保是Unix编码，不然在linux系统启动会报错

###项目架构：
* Springboot
* Mybatis
  * 使用了pageHelper插件来进行数据分页
* Druid连接池
* maven
  * maven采用了分环境方式来打包，同时使用了assembly插件来进行自定义打包
  * maven打包命令：mvn clean package -Dmaven.test.skip=true -Ptest （PS：其中-P后面可选dev/test/pro）