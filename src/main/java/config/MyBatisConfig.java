package config;

/**
 * @ProjectName: com.sm.api
 * @Package: config
 * @ClassName: MybatConfig
 * @Author: Administrator
 * @Description: 扫描mybatis
 * @Date: 2020/3/9 17:12
 * @Version: 1.0
 */
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyBatisConfig {

    @Autowired
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(
            ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setLogImpl(org.apache.ibatis.logging.log4j.Log4jImpl.class);//use log4j log
        sessionFactory.setConfiguration(configuration);
        sessionFactory.setMapperLocations(applicationContext.getResources("classpath:com/yy/example/mapper/*.xml"));
//
//		Properties prop = new Properties();
//		prop.setProperty("supportMethodsArguments","true");
//		prop.setProperty("rowBoundsWithCount", "true");
//		prop.setProperty("params","pageNum=pageNum;pageSize=pageSize;");
//		PageInterceptor pi = new PageInterceptor();
//		pi.setProperties(prop);
//		sessionFactory.setPlugins(new Interceptor[]{pi});

        return sessionFactory;
    }

}