package fr.idformation.mariospizza.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.idformation.mariospizza.security.dtos.ErrorDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {
    /**
     *mapper o.
     */
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     *
     * @param request that resulted in an <code>AuthenticationException</code>.
     * @param response so that the user agent can begin authentication
     * @param authException that caused the invocation
     * @throws IOException exception
     * @throws ServletException servlet exception
     */
    @Override
    public void commence(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        OBJECT_MAPPER.writeValue(response.getOutputStream(), new ErrorDto("Unauthorized path"));
    }
}
