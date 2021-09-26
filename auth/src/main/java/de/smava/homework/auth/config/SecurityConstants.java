package de.smava.homework.auth.config;

import lombok.experimental.UtilityClass;

@UtilityClass
class SecurityConstants {
    static final String RESOURCE_ID = "micro";

    static final String CLIENT_ID = "client";
    static final String CLIENT_SECRET = "$2a$10$HlzMvb9OQayvlWfX5pzJTeZvH30eKwnc6gE0C3idjDvbQt4XJMTki";// secret
    static final String GRANT_TYPE_PASSWORD = "password";
    static final String AUTHORIZATION_CODE = "authorization_code";
    static final String REFRESH_TOKEN = "refresh_token";
    static final String IMPLICIT = "implicit";

    static final int ACCESS_TOKEN_VALIDITY_SECONDS = 3600;
    static final int REFRESH_TOKEN_VALIDITY_SECONDS = 6 * ACCESS_TOKEN_VALIDITY_SECONDS;

    static final String SCOPE_READ = "read";
    static final String SCOPE_WRITE = "write";

    static final String OAUTH2_HAS_SCOPE_READ = "#oauth2.hasScope('" + SCOPE_READ + "')";
    static final String OAUTH2_HAS_SCOPE_WRITE = "#oauth2.hasScope('" + SCOPE_WRITE + "')";
}
