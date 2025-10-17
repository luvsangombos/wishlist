package projects.wishlist.config.log;


import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class Logger {
    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        return new CommonsRequestLoggingFilter() {
            @Override
            protected boolean shouldLog(HttpServletRequest request) {
                return true; // ✅ Log all requests, including GET
            }

            @Override
            protected void beforeRequest(HttpServletRequest request, String message) {
                LoggerFactory.getLogger("RequestLogger").info("Incoming request: " + message);
            }

            @Override
            protected void afterRequest(HttpServletRequest request, String message) {
                LoggerFactory.getLogger("RequestLogger").info("Completed request: " + message);
            }
        };
    }

    @Bean
    public FilterRegistrationBean<CommonsRequestLoggingFilter> loggingFilterRegistration() {
        FilterRegistrationBean<CommonsRequestLoggingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(requestLoggingFilter());
        registrationBean.setOrder(1); // Run early
        return registrationBean;
    }

}
