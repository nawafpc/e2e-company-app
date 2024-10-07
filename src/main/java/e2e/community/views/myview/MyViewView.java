package e2e.community.views.myview;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@PageTitle("My View")
@Menu(icon = "line-awesome/svg/pencil-ruler-solid.svg", order = 0)
@Route("")
    @StyleSheet("frontend/themes/e2e-company/styles.css")
public class MyViewView extends Composite<VerticalLayout> {

    public MyViewView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        H1 h1 = new H1();
        Hr hr = new Hr();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H3 h3 = new H3();
        MessageInput messageInput = new MessageInput();
        Hr hr2 = new Hr();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        H3 h32 = new H3();
        MessageInput messageInput2 = new MessageInput();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        MessageList messageList = new MessageList();
        Hr hr3 = new Hr();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        Button buttonPrimary = new Button();
        Button buttonPrimary2 = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("80px");
        layoutRow.setAlignItems(Alignment.START);
        layoutRow.setJustifyContentMode(JustifyContentMode.START);
        h1.setText("E2E Community");
        layoutRow.setAlignSelf(Alignment.CENTER, h1);
        h1.setWidth("max-content");
        layoutColumn2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidth("100%");
        layoutColumn2.setHeight("180px");
        layoutColumn2.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn2.setAlignItems(Alignment.CENTER);
        h3.setText("Question ?");
        h3.setWidth("max-content");
        messageInput.setWidth("470px");
        layoutColumn3.setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setWidth("100%");
        layoutColumn3.setHeight("100px");
        layoutColumn3.setJustifyContentMode(JustifyContentMode.CENTER);
        layoutColumn3.setAlignItems(Alignment.CENTER);
//        h32.setText("question will appear here for e2e Community");
        h32.setWidth("max-content");
        messageInput2.setWidth("550px");
        layoutColumn4.setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn4);
        layoutColumn4.addClassName(Padding.LARGE);
        layoutColumn4.setWidth("100%");
        layoutColumn4.setHeight("400px");
        layoutColumn4.setJustifyContentMode(JustifyContentMode.END);
        layoutColumn4.setAlignItems(Alignment.CENTER);
        layoutColumn4.setAlignSelf(Alignment.CENTER, messageList);
        messageList.setWidth("100%");
//        setMessageListSampleData(messageList);
        layoutRow2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        layoutRow2.setAlignItems(Alignment.CENTER);
        layoutRow2.setJustifyContentMode(JustifyContentMode.CENTER);
        buttonPrimary.setText("Evaluation");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary2.setText("Coach Evaluate");
        buttonPrimary2.setWidth("min-content");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(layoutRow);
        layoutRow.add(h1);
        getContent().add(hr);
        getContent().add(layoutColumn2);
        layoutColumn2.add(h3);
        layoutColumn2.add(messageInput);
        layoutColumn2.add(hr2);
        getContent().add(layoutColumn3);
        layoutColumn3.add(h32);
        layoutColumn3.add(messageInput2);
        getContent().add(layoutColumn4);
        layoutColumn4.add(messageList);
        layoutColumn4.add(hr3);
        getContent().add(layoutRow2);
        layoutRow2.add(buttonPrimary);
        layoutRow2.add(buttonPrimary2);


        messageInput.addSubmitListener(event -> {
            String messageText = event.getValue(); // Get the message text
            h32.setText(messageText); // Call the addMessage method
            messageInput.getElement().executeJs("this.value = '';");
//            messageInput2.setVisible(true);
            // Clear the input after sending
        });

        messageInput2.addSubmitListener(event -> {
            String messageText = event.getValue(); // Get the message text
            addMessage(messageList, messageText); // Call the addMessage method
            messageInput.getElement().executeJs("this.value = '';"); // Clear the input after sending
//            messageInput2.setVisible(false);

        });



    }
    private void addMessage(MessageList messageList, String answer) {
        // Get the current items from the message list
        List<MessageListItem> currentMessages = new ArrayList<>(messageList.getItems());

        // Create a new MessageListItem with the answer and current time
        MessageListItem newMessage = new MessageListItem(
                answer,
                LocalDateTime.now().toInstant(ZoneOffset.UTC),
                "Your Name" // You can replace this with the actual user's name
        );
        // Optionally set the user color index
        newMessage.setUserColorIndex(3); // Set an appropriate index for color
        // Add the new message to the list of current messages
        currentMessages.add(newMessage);
        // Set the updated list back to the message list
        messageList.setItems(currentMessages);
    }

}
