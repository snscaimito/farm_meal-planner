package net.caimito.mealplanner.recipes;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

public class RedisAuthenticationFilter extends AbstractPreAuthenticatedProcessingFilter {
	private static Logger logger = LoggerFactory.getLogger(RedisAuthenticationFilter.class) ;

	private StringRedisTemplate redisTemplate ;
	
	public RedisAuthenticationFilter(StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate ;
	}

	@Override
	protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
		logger.info("getPreAuthenticatedPrincipal");
		String username = redisTemplate.opsForValue().get("username") ;
		logger.info(String.format("User = %s", username));
		return username ;
	}

	@Override
	protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
		return "N/A";
	}

}
