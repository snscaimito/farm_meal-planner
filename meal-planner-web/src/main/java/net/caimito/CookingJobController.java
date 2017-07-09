package net.caimito;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cookingJob")
public class CookingJobController {

	@PostMapping
	public ResponseEntity<CookingJob> createMealPlan(CookingJob cookingJob) {
		return new ResponseEntity<CookingJob>(new CookingJob(), HttpStatus.OK) ;
	}
	
}
