* To fail the sonar qube add the belo code in `src/main/java/com/i27/LernerEurekaApplicationTests.java`
```bash
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
```
* we need to keep the quality gate at `code smells over all code` as > 10. and make it as default
* Run the jenkins job 
* If we observe, the sonarqube is failing but the jenkins jobs is still in green, and not aborting. 
* To fix this ,we need to implement `quality gates`

## Quality Gate Implementation at Jenkins:
* If my job is success or fail based on the quality gate ? 
    * 
* Create a webhook in sonar:
