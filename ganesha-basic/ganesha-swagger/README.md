# ganesha-swagger
    文档工具Swagger可拆卸组件

#### 代码结构 包名-类名
    swagger   swagger配置

#### 使用说明
    1. 确保引用模块能够扫描到【SwaggerUtil.class】,例如
        @SpringBootApplication
        @Import({SwaggerUtil.class})
        public class Application {
            main(){
                //do something....
            }
        }

    2. 文档地址示例：http://127.0.0.1:8100/swagger-ui.html

    3. 配置文件：swagger.show=ture/false
