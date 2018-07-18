这是一个采用SpringMVC+Spring+Mybatis框架的超市管理系统

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



