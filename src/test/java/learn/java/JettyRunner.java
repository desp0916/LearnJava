/**
 * http://openhome.cc/Gossip/JUnit/EmbeddedResource.html
 */
package learn.java;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import alpha.AbstractJettyHandler;

public class JettyRunner extends BlockJUnit4ClassRunner {
	public JettyRunner(Class<?> clz) throws InitializationError {
		super(clz);
	}

	@Override
	protected Statement methodInvoker(FrameworkMethod method, Object test) {
		JettyHandler jettyHandler = method.getAnnotation(JettyHandler.class);
		JettyStatement statement = null;
		if (jettyHandler != null) {
			try {
				AbstractJettyHandler handler = jettyHandler.value().newInstance();
				statement = new JettyStatement(super.methodInvoker(method, test), handler);
			} catch (Throwable e) {
				throw new RuntimeException(e);
			}
		}
		return statement;
	}
}