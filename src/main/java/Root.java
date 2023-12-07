import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;

class OtherProtocol{
    public boolean get;
    public boolean post;
    public boolean cookies;
    public boolean referer;
    @JsonProperty("user-agent")
    public boolean userAgent;
    public int anonymityLevel;
    public boolean supportsHttps;
    public String protocol;
    public String ip;
    public String port;
    public String country;

    public OtherProtocol() {
    }

    public boolean isGet() {
        return get;
    }

    public void setGet(boolean get) {
        this.get = get;
    }

    public boolean isPost() {
        return post;
    }

    public void setPost(boolean post) {
        this.post = post;
    }

    public boolean isCookies() {
        return cookies;
    }

    public void setCookies(boolean cookies) {
        this.cookies = cookies;
    }

    public boolean isReferer() {
        return referer;
    }

    public void setReferer(boolean referer) {
        this.referer = referer;
    }

    public boolean isUserAgent() {
        return userAgent;
    }

    public void setUserAgent(boolean userAgent) {
        this.userAgent = userAgent;
    }

    public int getAnonymityLevel() {
        return anonymityLevel;
    }

    public void setAnonymityLevel(int anonymityLevel) {
        this.anonymityLevel = anonymityLevel;
    }

    public boolean isSupportsHttps() {
        return supportsHttps;
    }

    public void setSupportsHttps(boolean supportsHttps) {
        this.supportsHttps = supportsHttps;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

public class Root{
    public boolean get;
    public boolean post;
    public boolean cookies;
    public boolean referer;
    @JsonProperty("user-agent")
    public boolean userAgent;
    public int anonymityLevel;
    public boolean supportsHttps;
    public String protocol;
    public String ip;
    public String port;
    public String ipPort;
    public int tsChecked;
    public String country;
    public String curl;
    public String type;
    public ArrayList<OtherProtocol> otherProtocols;

    public Root() {
    }

    public boolean isGet() {
        return get;
    }

    public void setGet(boolean get) {
        this.get = get;
    }

    public boolean isPost() {
        return post;
    }

    public void setPost(boolean post) {
        this.post = post;
    }

    public boolean isCookies() {
        return cookies;
    }

    public void setCookies(boolean cookies) {
        this.cookies = cookies;
    }

    public boolean isReferer() {
        return referer;
    }

    public void setReferer(boolean referer) {
        this.referer = referer;
    }

    public boolean isUserAgent() {
        return userAgent;
    }

    public void setUserAgent(boolean userAgent) {
        this.userAgent = userAgent;
    }

    public int getAnonymityLevel() {
        return anonymityLevel;
    }

    public void setAnonymityLevel(int anonymityLevel) {
        this.anonymityLevel = anonymityLevel;
    }

    public boolean isSupportsHttps() {
        return supportsHttps;
    }

    public void setSupportsHttps(boolean supportsHttps) {
        this.supportsHttps = supportsHttps;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getIpPort() {
        return ipPort;
    }

    public void setIpPort(String ipPort) {
        this.ipPort = ipPort;
    }

    public int getTsChecked() {
        return tsChecked;
    }

    public void setTsChecked(int tsChecked) {
        this.tsChecked = tsChecked;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {
        this.curl = curl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<OtherProtocol> getOtherProtocols() {
        return otherProtocols;
    }

    public void setOtherProtocols(ArrayList<OtherProtocol> otherProtocols) {
        this.otherProtocols = otherProtocols;
    }
}

