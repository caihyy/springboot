package config;

/**
 * @ProjectName: com.sm.api
 * @Package: config
 * @ClassName: MybatisScannerConfig
 * @Author: Administrator
 * @Description:
 * @Date: 2020/3/9 17:15
 * @Version: 1.0
 */
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisScannerConfig {
    @Bean
    public MapperScannerConfigurer MapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.us.example.dao");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }
}