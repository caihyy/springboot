/**
 * @ProjectName: com.sm.api
 * @Package: PACKAGE_NAME
 * @ClassName: Application
 * @Author: Administrator
 * @Description:
 * @Date: 2020/3/9 17:18
 * @Version: 1.0
 */
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import static org.springframework.boot.SpringApplication.run;

/**
 * Created by yangyibo on 17/1/17.
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = run(Application.class, args);
    }

}
