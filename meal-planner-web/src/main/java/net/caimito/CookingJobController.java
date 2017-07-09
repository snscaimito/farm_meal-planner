package net.caimito;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cookingJob")
public class CookingJobController {

	private Logger logger = LoggerFactory.getLogger(CookingJobController.class) ;
	
	@Autowired
	private FakeHolder fakeHolder ;
	
	@PostMapping
	public ResponseEntity<CookingJob> createMealPlan(@RequestBody CookingJob cookingJob) {
		logger.info(cookingJob.toString());
		fakeHolder.setCookingJob(cookingJob);
		
		return new ResponseEntity<CookingJob>(cookingJob, HttpStatus.OK) ;
	}
	
}
