/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CORSResponseFilter implements Filter {

    public CORSResponseFilter() {

    }

    @Override
    public void destroy() { 
        // TODO Auto-generated method stub
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String method = ((HttpServletRequest) request).getMethod();
        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", "*");
        if (method.equalsIgnoreCase("OPTIONS")) {
            ((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
            ((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers", "origin, accept,content-type,authorization");
            ((HttpServletResponse) response).addHeader("Vary", "Origin");
            ((HttpServletResponse) response).addHeader("Access-Control-Max-Age", "1728000");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }    
}
