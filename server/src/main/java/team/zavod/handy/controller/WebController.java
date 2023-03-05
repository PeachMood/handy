package team.zavod.handy.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.zavod.handy.component.ReactComponent;

/**
 * <p>Handles entrypoint.</p>
 */
@Controller
@RequestMapping(value = "/")
public class WebController {
  private final ReactComponent reactComponent;    // Instance of ReactComponent

  /**
   * <p>Creates instance of <code>WebController</code> class.</p>
   *
   * @param reactComponent Instance of ReactComponent.
   */
  @Autowired
  public WebController(ReactComponent reactComponent) {
    this.reactComponent = reactComponent;
  }

  @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
  public String mainPage(Model model, HttpServletRequest request) {
    String renderedHtml = this.reactComponent.renderEntryPoint(request.getRequestURI());
    model.addAttribute("content", renderedHtml);
    return "index";
  }
}
