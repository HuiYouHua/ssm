# ssm
maven+spring+springMVC+mybatis


该项目通过由maven构建的spring+springMVC+mybatis整合而成的web项目，主要是用来自己学习ssm操作的，只实现了基本功能，可以作为demo看看
数据库用的是mysql
其中有通过maven打的war包，ssm.sql数据库
数据库信息如下
```
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/ssm?characterEncoding=utf-8
jdbc.username=root
jdbc.password=huayoyu
```
你的账号密码弄成上面，name可以直接把war包放在tomcat的webapp下就可以访问
访问地址是http:localhost:8080/ssm/login
主页截图如下
![主页截图](https://github.com/HuiYouHua/ssm/blob/master/Snip20181031_1.png "主页截图")
项目目录结构如下
![项目目录](https://github.com/HuiYouHua/ssm/blob/master/Snip20181031_5.png "项目目录")

主要功能就是简单的登陆注销及商品的增删改查（删除和修改没做，嘿嘿）
其中实现有：
- springMVC的部分参数绑定
- 异常处理
- 文件上传
- json数据交互
- 拦截器














