package com.paypal.hiera.filters;

import org.apache.commons.io.output.TeeOutputStream;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * User: pderoxas
 * Date: 8/29/13
 * Time: 1:29 PM
 * Filter to add data to the log4j MDC object
 */
public class Log4jMDCFilter implements Filter {
    public void init(FilterConfig arg0) throws ServletException{}
    public void destroy(){}
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        SecurityContext context = (SecurityContext) httpServletRequest.getSession().getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
        if(context != null) {
            MDC.put("sessionId",httpServletRequest.getSession().getId());
        }else{
            MDC.put("sessionId",httpServletRequest.getSession().getId());
        }
        //can declare logger AFTER sessionId has been added to MDC
        final Logger logger = Logger.getLogger(this.getClass());

        try {
            Map<String, String> requestMap = this.getTypeSafeRequestMap(httpServletRequest);
            BufferedRequestWrapper bufferedRequest = new BufferedRequestWrapper(httpServletRequest);
            BufferedResponseWrapper bufferedResponse = new BufferedResponseWrapper(httpServletResponse);

            final StringBuilder logMessage = new StringBuilder("REST Request/Response - ")
                .append("[URL:").append(httpServletRequest.getRequestURL()).append("] ")
                .append("[HTTP METHOD:").append(httpServletRequest.getMethod()).append("] ")
                .append("[PATH INFO:").append(httpServletRequest.getPathInfo()).append("] ")
                .append("[REQUEST PARAMETERS:").append(requestMap).append("] ")
                .append("[REQUEST BODY:").append(bufferedRequest.getRequestBody()).append("] ")
                .append("[REMOTE ADDRESS:").append(httpServletRequest.getRemoteAddr()).append("] ");

            chain.doFilter(bufferedRequest, bufferedResponse);
            logMessage.append("[RESPONSE BODY:").append(bufferedResponse.getContent()).append("]");
            logger.debug(logMessage.toString());
        }
        catch (Throwable t) {
            t.printStackTrace();
            logger.error(t.getMessage(), t);
        }
    }

    private Map<String, String> getTypeSafeRequestMap(HttpServletRequest request) {
        Map<String, String> typeSafeRequestMap = new HashMap<String, String>();
        Enumeration<?> requestParamNames = request.getParameterNames();
        while (requestParamNames.hasMoreElements()) {
            String requestParamName = (String) requestParamNames.nextElement();
            String requestParamValue = request.getParameter(requestParamName);
            typeSafeRequestMap.put(requestParamName, requestParamValue);
        }
        return typeSafeRequestMap;
    }

    private static final class BufferedServletInputStream extends ServletInputStream {
        private ByteArrayInputStream byteArrayInputStream;
        public BufferedServletInputStream(ByteArrayInputStream bais) {
            this.byteArrayInputStream = bais;
        }
        @Override
        public int available() {
            return this.byteArrayInputStream.available();
        }
        @Override
        public int read() {
            return this.byteArrayInputStream.read();
        }
        @Override
        public int read(byte[] buffer, int offset, int length) {
            return this.byteArrayInputStream.read(buffer, offset, length);
        }
    }

    public class TeeServletOutputStream extends ServletOutputStream {
        private final TeeOutputStream targetStream;
        public TeeServletOutputStream(OutputStream one, OutputStream two) {
            targetStream = new TeeOutputStream(one, two);
        }
        @Override
        public void write(int arg0) throws IOException {
            this.targetStream.write(arg0);
        }
        public void flush() throws IOException {
            super.flush();
            this.targetStream.flush();
        }
        public void close() throws IOException {
            super.close();
            this.targetStream.close();
        }
    }

    private static final class BufferedRequestWrapper extends HttpServletRequestWrapper {
        private ByteArrayInputStream byteArrayInputStream = null;
        private ByteArrayOutputStream byteArrayOutputStream = null;
        private BufferedServletInputStream bufferedServletInputStream = null;
        private byte[] buffer = null;
        public BufferedRequestWrapper(HttpServletRequest req) throws IOException {
            super(req);

            // Store the inputStream in a buffer
            InputStream inputStream = req.getInputStream();
            this.byteArrayOutputStream = new ByteArrayOutputStream();
            byte tmpBuffer[] = new byte[1024];
            int i;
            while ((i = inputStream.read(tmpBuffer)) > 0) {
                this.byteArrayOutputStream.write(tmpBuffer, 0, i);
            }
            this.buffer = this.byteArrayOutputStream.toByteArray();
        }

        @Override
        public ServletInputStream getInputStream() {
            this.byteArrayInputStream = new ByteArrayInputStream(this.buffer);
            this.bufferedServletInputStream = new BufferedServletInputStream(this.byteArrayInputStream);
            return this.bufferedServletInputStream;
        }

        private String getRequestBody() throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.getInputStream()));
            String line;
            StringBuilder inputBuffer = new StringBuilder();
            do {
                line = reader.readLine();
                if (null != line) {
                    inputBuffer.append(line.trim());
                }
            } while (line != null);
            reader.close();
            return inputBuffer.toString().trim();
        }
    }

    public class BufferedResponseWrapper implements HttpServletResponse {
        HttpServletResponse original;
        TeeServletOutputStream teeStream;
        PrintWriter teeWriter;
        ByteArrayOutputStream bos;

        public BufferedResponseWrapper(HttpServletResponse response) {
            original = response;
        }

        public String getContent() {
            if(bos == null){
                return "";
            }
            return bos.toString();
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            if (this.teeWriter == null) {
                this.teeWriter = new PrintWriter(new OutputStreamWriter(getOutputStream()));
            }
            return this.teeWriter;
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            if (teeStream == null) {
                bos = new ByteArrayOutputStream();
                teeStream = new TeeServletOutputStream(original.getOutputStream(), bos);
            }
            return teeStream;
        }

        @Override
        public String getCharacterEncoding() {
            return original.getCharacterEncoding();
        }
        @Override
        public String getContentType() {
            return original.getContentType();
        }
        @Override
        public void setCharacterEncoding(String charset) {
            original.setCharacterEncoding(charset);
        }
        @Override
        public void setContentLength(int len) {
            original.setContentLength(len);
        }
        @Override
        public void setContentType(String type) {
            original.setContentType(type);
        }
        @Override
        public void setBufferSize(int size) {
            original.setBufferSize(size);
        }
        @Override
        public int getBufferSize() {
            return original.getBufferSize();
        }
        @Override
        public void flushBuffer() throws IOException {
            if (teeStream != null) {
                teeStream.flush();
            }
            if (this.teeWriter != null) {
                this.teeWriter.flush();
            }
        }
        @Override
        public void resetBuffer() {
            original.resetBuffer();
        }
        @Override
        public boolean isCommitted() {
            return original.isCommitted();
        }
        @Override
        public void reset() {
            original.reset();
        }
        @Override
        public void setLocale(Locale loc) {
            original.setLocale(loc);
        }
        @Override
        public Locale getLocale() {
            return original.getLocale();
        }
        @Override
        public void addCookie(Cookie cookie) {
            original.addCookie(cookie);
        }
        @Override
        public boolean containsHeader(String name) {

            return original.containsHeader(name);
        }
        @Override
        public String encodeURL(String url) {
            return original.encodeURL(url);
        }
        @Override
        public String encodeRedirectURL(String url) {
            return original.encodeRedirectURL(url);
        }
        @SuppressWarnings("deprecation")
        @Override
        public String encodeUrl(String url) {
            return original.encodeUrl(url);
        }
        @SuppressWarnings("deprecation")
        @Override
        public String encodeRedirectUrl(String url) {
            return original.encodeRedirectUrl(url);
        }
        @Override
        public void sendError(int sc, String msg) throws IOException {
            original.sendError(sc, msg);
        }
        @Override
        public void sendError(int sc) throws IOException {
            original.sendError(sc);
        }
        @Override
        public void sendRedirect(String location) throws IOException {
            original.sendRedirect(location);
        }
        @Override
        public void setDateHeader(String name, long date) {
            original.setDateHeader(name, date);
        }
        @Override
        public void addDateHeader(String name, long date) {
            original.addDateHeader(name, date);
        }
        @Override
        public void setHeader(String name, String value) {
            original.setHeader(name, value);
        }
        @Override
        public void addHeader(String name, String value) {
            original.addHeader(name, value);
        }
        @Override
        public void setIntHeader(String name, int value) {
            original.setIntHeader(name, value);
        }
        @Override
        public void addIntHeader(String name, int value) {
            original.addIntHeader(name, value);
        }
        @Override
        public void setStatus(int sc) {
            original.setStatus(sc);
        }
        @SuppressWarnings("deprecation")
        @Override
        public void setStatus(int sc, String sm) {
            original.setStatus(sc, sm);
        }
    }
}