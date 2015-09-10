package Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.User.User;

@RestController
public class UserController {
	
	@RequestMapping("/user")
	public User user(@RequestParam(value="name", defaultValue="User") String name)
	{
		return new User(name);
	}
}
