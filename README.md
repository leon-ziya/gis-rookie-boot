Terra-CCU-Web 管理系统
===============

当前最新版本： 2.0.0


## 后端技术架构
- 基础框架：  
    - Jeecg Boot 2.2.1 : 参考 jeecg-boot-module-system/README.md
    
    - SpringBoot 2.1.3.RELEASE

- 持久层框架：Mybatis-plus_3.3.2

- 安全框架：Apache Shiro 1.4.0，Jwt_3.7.0

- 数据库连接池：阿里巴巴Druid 1.1.17

- 缓存框架：redis

- 日志打印：logback

- 其他：fastjson，poi，Swagger-ui，quartz, lombok（简化代码）等。



## 开发环境

- 语言：Java 8

- IDE(JAVA)： Eclipse安装lombok插件 或者 IDEA

- 依赖管理：Maven

- 数据库：MySQL5.0  &  Oracle 11g

- 缓存：Redis


## 技术文档

- 模块名称
    - terra-ccu-boot: ccu-web父目录
    - jeecg-boot-base-common: 系统功能common模块
    - jeecg-boot-module-system: 系统功能模块
    - terra-ccu-web-bootstarter: CCU-WEB启动配置模块
    - terra-ccu-web-common: CCU 业务通用模块
    - terra-ccu-web-admin: CCU 业务管理模块
    - terra-ccu-web-api: CCU业务对外第三方API模块

- 初始化仓库配置
```xml
    <mirror>
            <id>nexus-aliyun</id>
            <mirrorOf>*,!jeecg,!jeecg-snapshots</mirrorOf>
            <name>Nexus aliyun</name>
            <url>http://maven.aliyun.com/nexus/content/groups/public</url>
    </mirror> 
```
    
- 初始化项目名称：  
    - application-dev.yml
    ```yaml
    server:
      port: 8080
      tomcat:
        max-swallow-size: -1
      servlet:
        context-path: /terra-ccu
    ```
    - vue.config.js  
    ```js
    '/terra-ccu': {
        target: 'http://localhost:8080', //请求本地 需要jeecg-boot后台项目
        ws: false,
        changeOrigin: true
    },
    ```
    - public\index.html
    ```html
    window._CONFIG['domianURL'] = 'http://127.0.0.1:8080/terra-ccu';
    ```

- 初始化Swagger文档
    - org\jeecg\config\Swagger2Config.java
    ```java
	@Bean
	public Docket createTerraCcuRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.groupName("CCU业务")
				.select()
				//此包路径下的类，才生成接口文档
				.apis(RequestHandlerSelectors.basePackage("cn.edu.cuhk.terra.ccu.modules"))
				//加了ApiOperation注解的类，才生成接口文档
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				.paths(PathSelectors.any())
				.build()
				.securitySchemes(Collections.singletonList(securityScheme()));
		//.globalOperationParameters(setHeaderToken());
	}    
    ```

- 初始化或新增访问控制
    - org\jeecg\config\ShiroConfig.java
    ```java
 	filterChainDefinitionMap.put("/test/admin/**", "anon");
 	filterChainDefinitionMap.put("/device/**", "anon");
    ```

- 异常控制
    - org\jeecg\common\exception\JeecgBootExceptionHandler.java
    - 默认异常处理迁移
        - cn\edu\cuhk\terra\ccu\common\exception\TerraCcuExceptionHandler.java
    ```java
    @ExceptionHandler(Exception.class)
    	public Result<?> handleException(Exception e){
    		log.error(e.getMessage(), e);
    		return Result.error("操作失败，"+e.getMessage());
    }
    ```

## 打包与发布
- 打包前工作
    - maven管理器中执行 jeecg-boot-parent / Lifecycle / install  
        - 开发过程中需要对已安装模块，需要clean
    - 如需线上修改的配置文件，置于 terra-ccu-web-bootstarter 的 resources
    
- 打包: maven管理器中执行 terra-ccu-web-bootstarter / Lifecycle / install

- 打包文件输出 $project-root/build

- 解压
```shell script
# unzip terra-ccu-web-app.zip
```

- 手工运行
```shell script
# cd terra-ccu-web-app
# nohup java -jar terra-ccu-web-bootstarter-2.2.1.jar &
```
