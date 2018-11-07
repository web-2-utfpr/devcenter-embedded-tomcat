package filter;

import util.Context;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = {"/login", "/register", "/feed", "/profile", "/search"})

public class AuthenticationFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        Context context = new Context((HttpServletRequest) req, (HttpServletResponse) res);
        String path;
        path = ((HttpServletRequest) req).getRequestURI();

        if (path.equals("/login") || path.equals("/register")) {
            if (context.estaLogado()) {
                context.Redirect("/feed");
                return;
            }
            chain.doFilter(req, res);
            return;
        }

        if (!context.estaLogado()) {
            context.Redirect("/login");
            return;
        }
        chain.doFilter(req, res);
    }
}