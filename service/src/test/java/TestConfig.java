import com.schremser.spring.boot.rest.RootResource;
import com.schremser.spring.boot.service.MessageService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {RootResource.class, MessageService.class})
public class TestConfig {
}
