/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.*;

@WebFilter(urlPatterns = {"*"})
public class I18nFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void destroy() {
    }

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

        while (keys.hasMoreElements()) {
            String label = keys.nextElement();
            String value = messages.getString(label);
            labels.put(label, value);
        }

        req.setAttribute("labels", labels);
        chain.doFilter(req, res);

    }
}
