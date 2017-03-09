package accew.modules.security;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * Created by acc on 2017/3/9.
 */
public class AntUrlPathMatcher implements UrlMatcher {
    private PathMatcher pathMatcher;
    private boolean requiresLowerCaseUrl;

    public AntUrlPathMatcher() {
        this(true);
    }

    public AntUrlPathMatcher(boolean requiresLowerCaseUrl) {
        this.requiresLowerCaseUrl = true;
        this.pathMatcher = new AntPathMatcher();

        this.requiresLowerCaseUrl = requiresLowerCaseUrl;
    }

    public Object compile(String path) {
        if (this.requiresLowerCaseUrl) {
            return path.toLowerCase();
        }

        return path;
    }

    public boolean pathMatchesUri(Object path, String uri) {
        if (("/**".equals(path)) || ("**".equals(path))) {
            return true;
        }
        return this.pathMatcher.match((String)path, uri);
    }

    public String getUniversalMatchPattern() {
        return "/**";
    }

    public boolean requiresLowerCaseUrl() {
        return this.requiresLowerCaseUrl;
    }

    public void setRequiresLowerCaseUrl(boolean requiresLowerCaseUrl) {
        this.requiresLowerCaseUrl = requiresLowerCaseUrl;
    }
}
