package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/*")
public class SetEncodingFilter extends HttpFilter implements Filter {
       
    public SetEncodingFilter() {
        super();
    }

	public void destroy() {
		System.out.println("destroy/SetEncodingFilter");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		System.out.println("dofilterスタート事前処理/SetEncodingFilter");
		chain.doFilter(request, response);
		System.out.println("dofilterスタート事後処理/SetEncodingFilter");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init/SetEncodingFilter");
	}

}
