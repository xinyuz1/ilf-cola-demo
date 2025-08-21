# 项目规则文档

## 1. 架构规范

### 1.1 COLA架构遵循
- 严格遵循COLA（Componentized, Open, Layered, Architectural）四层架构设计
- **client层**：接口定义与数据传输对象（DTO）
- **domain层**：核心业务逻辑与领域模型
- **infrastructure层**：基础设施层，包括数据访问和外部服务集成
- **app层**：应用服务层，协调领域对象完成用例
- **adapter层**：适配器层，负责与外部系统交互（如REST API、消息队列等）
- **start层**：应用程序入口点

### 1.2 模块依赖关系
- client层：不依赖其他业务模块
- domain层：仅依赖client层
- infrastructure层：依赖domain层
- app层：依赖client、domain和infrastructure层
- adapter层：依赖app层
- start层：依赖adapter层
- 严禁反向依赖或循环依赖

## 2. 代码风格规范

### 2.1 命名规范
- 遵循阿里巴巴Java开发手册中的命名规范
- 类名：采用大驼峰命名法（如CustomerService）
- 方法名：采用小驼峰命名法（如addCustomer）
- 变量名：采用小驼峰命名法（如customerName）
- 常量名：全部大写，单词间用下划线分隔（如MAX_PAGE_SIZE）
- 包名：全部小写，避免使用下划线（如com.ilf.customer）
- 接口：通常以I结尾（如CustomerServiceI）
- 实现类：通常以Impl结尾（如CustomerServiceImpl）

### 2.2 代码格式
- 使用4个空格进行缩进，不使用Tab
- 每行最多120个字符
- 方法之间使用一个空行分隔
- 不同逻辑块之间使用空行分隔
- 大括号使用Java风格（左大括号不换行）
- 运算符前后加空格

### 2.3 注释规范
- Javadoc：为所有公共类、接口、方法提供Javadoc注释
- 类注释：说明类的职责、作者和创建日期
- 方法注释：说明方法的功能、参数、返回值和可能抛出的异常
- 代码块注释：复杂逻辑添加行注释，说明设计意图
- TODO注释：标记待完成的工作

## 3. 技术栈规范

### 3.1 核心框架
- Spring Boot：3.2.10（统一使用此版本）
- MyBatis：3.0.5（与Spring Boot 3.x兼容版本）
- Java：17

### 3.2 依赖管理
- 在根pom.xml中统一管理所有第三方依赖版本
- 使用dependencyManagement集中管理版本，防止版本冲突
- 优先使用Spring Boot Starter依赖

### 3.3 数据库相关
- MySQL：使用mysql-connector-j（Spring Boot 3.x推荐的驱动）
- MyBatis：使用接口加注解方式开发，避免XML配置
- 实体类：使用Lombok简化getter/setter等模板代码

## 4. 设计模式与最佳实践

### 4.1 设计模式
- 命令模式：用于封装业务操作（如CustomerAddCmd）
- 查询模式：用于封装查询操作（如CustomerListByNameQry）
- 领域模型模式：核心业务逻辑封装在领域对象中
- 仓储模式：抽象数据访问操作

### 4.2 最佳实践
- 异常处理：使用COLA提供的异常处理机制
- 日志记录：使用@CatchAndLog注解简化日志记录
- 事务管理：在业务层使用Spring事务注解
- 数据验证：使用Jakarta Validation API进行数据校验

## 5. 构建与部署规范

### 5.1 Maven配置
- 统一使用Maven进行构建
- 配置文件管理：合理使用Spring Boot的多环境配置
- 资源过滤：配置Maven资源过滤，支持不同环境的配置切换

## 注意事项
请在后续使用过程中，根据项目实际情况逐步完善和优化此规则文档。如有任何特殊需求或问题，请随时补充说明。