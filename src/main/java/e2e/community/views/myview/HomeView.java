package e2e.community.views.myview;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("home")
public class HomeView extends VerticalLayout {
    public HomeView() {
        add(new Text("This is the home view!"));
    }
}
