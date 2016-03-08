/**
 * http://openhome.cc/Gossip/JUnit/EmbeddedResource.html
 */
package learn.java;

import org.eclipse.jetty.server.Server;
import org.junit.runners.model.Statement;

import alpha.AbstractJettyHandler;

public class JettyStatement extends Statement {
    private Statement invoker;
    private AbstractJettyHandler handler;

    public JettyStatement(Statement invoker, AbstractJettyHandler handler) {
        this.invoker = invoker;
        this.handler = handler;
    }

    @Override
    public void evaluate() throws Throwable {
        Server server = new Server(handler.getPort());
        server.setHandler(handler);
        try {
            server.start();
            invoker.evaluate();
        }
        finally {
            if(server != null) {
                server.stop();
            }
        }
    }
}
