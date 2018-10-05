/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns={"*"})
public class I18nFilter implements Filter  {
    
    public void init (FilterConfig filterConfig) throws ServletException {}
    
    public void destroy () {}

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        String current = req.getLocale().toString();

        if (current.contains("pt")) {
            Locale.setDefault(new Locale("pt", "BR"));
        } else {
            Locale.setDefault(Locale.US);
        }

        ResourceBundle messages = ResourceBundle.getBundle("Messages");
        
        Enumeration<String> keys = messages.getKeys();
        
        Map labels = new HashMap();
        
        while(keys.hasMoreElements()){
            String label = keys.nextElement();
            String value = messages.getString(label);
            labels.put(label, value);
        }
        
        req.setAttribute("labels", labels);        
        chain.doFilter(req, res);
        
    } 
}
