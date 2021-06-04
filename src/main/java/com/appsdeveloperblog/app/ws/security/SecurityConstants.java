package com.appsdeveloperblog.app.ws.security;


import com.appsdeveloperblog.app.ws.SpringApplicationContext;

/* http://localhost:8081/login for making Post request with Postman with
* spring security and user date like for an example
* {
    "email": "test1@test.com",
    "password": "1234"
}
* for an existing user */
public class SecurityConstants {

    public static final long EXPIRATION_TIME = 8640000; // 10 days
    public static final long PASSWORD_RESET_EXPIRATION_TIME = 3600000; // 1 hour
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users";
    //  public static final String TOKEN_SECRET = "jf9i4jgu83nfl0";

    public static String getTokenSecret()
    {
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("AppProperties");
        return appProperties.getTokenSecret();
    }

}
