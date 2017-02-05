package trans1;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface IService {

	public void addLession(String name, String price);
	
}
