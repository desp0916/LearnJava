/**
 * http://openhome.cc/Gossip/JUnit/EmbeddedResource.html
 */
package learn.java;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import alpha.AbstractJettyHandler;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface JettyHandler {
	Class<? extends AbstractJettyHandler> value();
}