package io.pivotal.demo.services.common.broker.auth;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;

/**
 * Created by sgupta on 12/8/14.
 */
public class ServiceAuthenticationInterceptor extends HandlerInterceptorAdapter {
  public static final Logger LOGGER = Logger.getLogger(ServiceAuthenticationInterceptor.class.getName());

  public static final String SVC_AUTH_NAME = "SVC_AUTH_NAME";
  public static final String SVC_AUTH_CODE = "SVC_AUTH_CODE";

  private final String name;
  private final String code;
  private final String auth;

  public ServiceAuthenticationInterceptor() {
    name = System.getenv(SVC_AUTH_NAME);
    code = System.getenv(SVC_AUTH_CODE);
    auth = "Basic " + Base64.encodeBase64String((name + ":" + code).getBytes(Charset.forName("UTF-8")));
    LOGGER.info(">> >> >> >> created service auth interceptor with auth: " + auth);
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String authHeader = request.getHeader("Authorization");
    LOGGER.info(">> >> >> >> pre handling with auth header: " + authHeader);
    if(name == null && code == null) {
      return true;
    }
    if(auth.equals(authHeader)) {
      return true;
    }
    else {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
    return false;
  }
}
