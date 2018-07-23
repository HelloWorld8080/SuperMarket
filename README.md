这是一个采用SpringMVC+Spring+Mybatis框架的超市管理系统

运行环境为jdk1.8，tomcat8.5，需要安装并配置好redis和数据库便可以运行

用户名niu密码123456，可以访问所有连接，可以在配置文件中spring-shiro.xml注释掉相应配置来取消登陆验证

Excel处理一些文件目录采用硬编码模式，如果想要获得运行效果，请更新成自己的文件地址，基本都在CommodityController里面

```
InputStream bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\11291\\SuperMarket\\src\\main\\webapp\\Excel\\text.xlsx")));
```

每个mapper.xml文件中的这句话是采用redis进行缓存的声明。

```
<cache type="com.sm.redis.RedisCache"></cache>
```

想要能够发送邮件，请在mail.properties添加账户密码(得开通STMP服务)，默认采用网易邮箱

目录格式为

```
├──README.md
├──.idea
├──pom.xml
└──src
	└──main
		├──java
         │   └──com.sm
         │       ├──Component
         │       ├──converter
         │       ├──dao
         │       ├──entity
         │       ├──Handler
         │       ├──Impl
         │       ├──NewTechno
         │       ├──redis
         │       ├──service
         │       ├──shiro
         │       ├──Tools
         │       └──web
		│
		├──resource
         │ 	├──mapper
         │	├──spring
         │	├──generatorConfig.xml
         │	├──jdbc.properties
         │	├──logback.xml
         │	├──mail.properties
         │	├──mybatis-config.xml
         │	├──redis-config.xml
         │	├──redis.properties
         │	└──template.vm
         └──webapp
         	├──bootstrap
         	├──build
         	├──Excel
         	├──img
         	├──jquery
         	├──js
         	├──vendors
         	└──WEB-INF
         		└──thymeleafs
         			├──Commodity
         			├──OutBound
         			├──Purchase
         			├──Receipt
         			├──Storage
         			├──Supplier
         			├──login.html
         			└──register.html
         			
         			
```



访问的url为：

获取商品列表http://localhost:8080/comm/list

添加商品http://localhost:8080/comm/add

添加进货信息http://localhost:8080/pur/add

查询流水http://localhost:8080/rec/list

库存信息添加http://localhost:8080/store/add

库存获取所有http://localhost:8080/store/list

出库信息添加http://localhost:8080/res/add

获取所有出库信息http://localhost:8080/res/list

供应商信息添加http://localhost:8080/sup/add

获取所有供应商http://localhost:8080/sup/list



