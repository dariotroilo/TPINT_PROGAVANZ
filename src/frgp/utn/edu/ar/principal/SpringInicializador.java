package frgp.utn.edu.ar.principal;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import frgp.utn.edu.ar.config.*;

public class SpringInicializador implements WebApplicationInitializer{ 

    @Override
	public void onStartup(ServletContext container) throws ServletException {
         AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
          ctx.register(SpringConfiguracion.class);
          ctx.setServletContext(container);
 
          ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
          servlet.setLoadOnStartup(1);
          servlet.addMapping("/");
 
          container.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain"))
          .addMappingForUrlPatterns(null, false, "/*");
    }
 
}