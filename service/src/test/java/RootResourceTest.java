import com.schremser.spring.boot.JerseyConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.ws.rs.core.Application;
import java.util.Random;

public class RootResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        // return new ResourceConfig(RootResource.class);
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        // contextConfig = SpringComponentProvider.PARAM_SPRING_CONTEXT
        return new JerseyConfig().property("contextConfig", context);
    }

    @Test
    public void testHello() {
        final String hello = target("hello").request().get(String.class);
        assert hello.equals("Hello World");
    }

    @Test
    public void testMessages() throws JSONException {
        final String messages = target("messages").request().get(String.class);
        String expected = "[{'author':'Hello', 'content': 'World'}]";
        JSONAssert.assertEquals(expected, messages, JSONCompareMode.LENIENT);
    }

    @Test
    public void testRandom() {
        final String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHJIJKLMNOPQRSTUVWXYZ";
        final int N = alphabet.length();

        Random r = new Random();

        for (int i = 0; i < 5; i++) {
            System.out.print(alphabet.charAt(r.nextInt(N)));
        }
    }

    @Test
    public void testHeaders() {

    }
}


