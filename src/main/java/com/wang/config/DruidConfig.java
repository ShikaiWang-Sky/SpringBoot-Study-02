package com.wang.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    //将自定义的Bean与spring.datasource绑定
    @ConfigurationProperties(prefix = "spring.datasource")
    //将DruidDataSource注册到Bean
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //后台监控, 访问 /druid 即可, 固定写法的代码
    //我们要将其注册到web,xml, 因为SpringBoot 内置了servlet容器, 所以没有web.xml, 替代方法: ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //后台需要有人登录, 账号密码配置
        HashMap<String, String> initParameters = new HashMap<>();
        //增加配置
        //登录的key 是固定的 loginUsername loginPassword
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "123456");

        //允许谁可以访问, 值为空则所有人都可以访问
        initParameters.put("allow", "");

        //IP白名单
        //initParameters.put("allow","192.168.1.12,127.0.0.1");
        //IP黑名单
        //initParameters.put("deny","192.168.4.23");
        //是否能够重置数据
        initParameters.put("resetEnable","false");

        bean.setInitParameters(initParameters);   //设置初始化参数

        return bean;
    }

    //filter
    //我们要注册filter, 同样的, 使用 FilterRegistrationBean 注册
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new WebStatFilter());

        //可以过滤哪些请求
        HashMap<String, String> initParameters = new HashMap<>();

        //这些东西不进行统计
        initParameters.put("exclusions", "*.js,*.css,/druid/*");

        bean.setInitParameters(initParameters);

        return bean;
    }

}
