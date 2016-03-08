package alpha;

import org.eclipse.jetty.server.handler.AbstractHandler;

public abstract class AbstractJettyHandler extends AbstractHandler {
    private int port = 8080; // default port 8080
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
}
