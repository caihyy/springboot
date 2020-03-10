package config;

/**
 * @ProjectName: com.sm.api
 * @Package: config
 * @ClassName: MapperScannerConfig
 * @Author: Administrator
 * @Description:扫描mapper类
 * @Date: 2020/3/9 17:08
 * @Version: 1.0
 */
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("**.dao");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }
}
