package team.zavod.handy.component;

import java.io.IOException;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * <p>Evaluates JavaScript code for Server-Side rendering.</p>
 */
@Component
public class ReactComponent {
  private final Resource bundleJsFile;  // Path to bundle.js

  /**
   * <p>Creates instance of <code>ReactComponent</code> class.</p>
   */
  public ReactComponent() {
    this.bundleJsFile = new ClassPathResource("static/bundle.js");
  }

  /**
   * <p>Renders react component for entrypoint.</p>
   *
   * @return Rendered html.
   */
  public String renderEntryPoint(String requestURI) {
    try (Context context = Context.create()) {
      context.eval("js", "window = { requestURI: '" + requestURI + "' }");
      context.eval(Source.newBuilder("js", this.bundleJsFile.getURL()).build());
      Value html = context.getBindings("js").getMember("window").getMember("renderServer").execute();
      return html.asString();
    } catch (IOException e) {
      throw new IllegalStateException("Error! Failed to render react component!", e);    }
  }
}
