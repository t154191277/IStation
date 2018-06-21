package bistu.wmlove.istation.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.druid.util.Base64;
import com.alibaba.fastjson.JSONObject;

import bistu.wmlove.istation.entity.Response;
import bistu.wmlove.istation.jwt.JWTUtils;

/**
 * JWT认证令牌过滤器
 * 
 * @author wmlove
 * @since 2018-3-11
 * 
 */
public class JWTAuthenticationFilter extends OncePerRequestFilter {

	@Value("${jwt.header}")
	private String token_header;

	@Resource
	private JWTUtils jwtUtils;

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		String auth_token = request.getHeader(this.token_header);

		final String auth_token_start = "Bearer ";
		if (!StringUtils.isEmpty(auth_token)
				&& auth_token.startsWith(auth_token_start)) {
			auth_token = auth_token.substring(auth_token_start.length());
		} else {
			// 不按规范,不允许通过验证
			auth_token = null;
		}
		
		Claims claim;
		String phoneId= "";
		logger.info("auth_token:" + auth_token);
		try {
			claim = Jwts.parser().setSigningKey(Base64Utils.encodeToString("secret-key".getBytes()))
					.parseClaimsJws(auth_token).getBody();
			phoneId = claim.getSubject();
			logger.info(String.format("Checking authentication for user %s.",
					claim.getSubject()));
		} catch (Exception e) {
//			e.printStackTrace();
			claim = null;
		}
		logger.info("claim:" + claim);
		logger.info(request.getRequestURL().toString());
		
		request.setAttribute("phoneId", phoneId);
		if (claim != null || request.getRequestURI().contains("login")){
			if (claim != null ){
				//refresh_token
			}else{
				logger.info(String.format("login"));
			}
			chain.doFilter(request, response);
		}else if(request.getRequestURI().contains("shop") || request.getRequestURI().contains("index")){
			logger.info("shopName" + request.getParameter("shopName"));
			logger.info("shopName" + request.getParameterMap().size());
			chain.doFilter(request, response);
			System.out.println("shopName" + request.getParameterMap().size());
		}
		else{
			PrintWriter out = response.getWriter();
			response.setContentType("application/json; charset=utf-8");  
			Response res = new Response();
            JSONObject responseJSONObject = (JSONObject) JSONObject.toJSON(res.failure(403, "forbidden"));
            out.print(responseJSONObject.toString());
            out.flush();
            out.close();
		}
		
//		if (!request.getRequestURI().contains("login")) {
//
//			String auth_token = request.getHeader(this.token_header);
//
//			final String auth_token_start = "Bearer ";
//			if (!StringUtils.isEmpty(auth_token)
//					&& auth_token.startsWith(auth_token_start)) {
//				auth_token = auth_token.substring(auth_token_start.length());
//			} else {
//				// 不按规范,不允许通过验证
//				auth_token = null;
//			}
//
//			Claims claim = Jwts.parser().setSigningKey(Base64Utils.encodeToString("secert-key".getBytes()))
//					.parseClaimsJws(auth_token).getBody();
//			String username = claim.getSubject();
//			logger.info(String.format("Checking authentication for user %s.",
//					username));
//
//			if (username != null
//					&& SecurityContextHolder.getContext().getAuthentication() == null) {
//				// It is not compelling necessary to load the use details from
//				// the database. You could also store the information
//				// in the token and read it from it. It's up to you ;)
//				// UserDetails userDetails =
//				// this.userDetailsService.loadUserByUsername(username);
////				UserDetails userDetails = jwtUtils.getUserFromToken(auth_token);
//
//				// For simple validation it is completely sufficient to just
//				// check the token integrity. You don't have to call
//				// the database compellingly. Again it's up to you ;)
////				if (jwtUtils.validateToken(auth_token, userDetails)) {
////					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
////							userDetails, null, userDetails.getAuthorities());
////					authentication.setDetails(new WebAuthenticationDetailsSource()
////									.buildDetails(request));
////					logger.info(String.format("Authenticated user %s, setting security context",username));
////					SecurityContextHolder.getContext().setAuthentication(authentication);
////				}
//				ArrayList<Authority> list  = new ArrayList<Authority>();
//				Authority a = new Authority();
//				list.add(a);
//				SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username,null,list));
//			}
//		}
//		chain.doFilter(request, response);
	}
	
	class Authority implements GrantedAuthority{

		private static final long serialVersionUID = 1L;

		@Override
		public String getAuthority() {
			return "ROLE_ADMIN";
		}
		
	}

}
