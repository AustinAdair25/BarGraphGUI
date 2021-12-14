package Controller;

import Model.Model;
import View.View;
import java.util.concurrent.BlockingQueue;

public class Controller {
    BlockingQueue<Message> queue;
    Model model;
    View view;

    public Controller(BlockingQueue<Message> queue, Model model, View view) {
        this.queue = queue;
        this.model = model;
        this.view = view;
    }

    public void mainLoop() {
        while (view.isDisplayable()) {
            Message message = null;
            try {
                message = queue.take();
            } catch (InterruptedException exception) {
                // do nothing
            }

            if(message.getClass() == UpdateMessage.class) {
                // button updateMessage was clicked
                UpdateMessage heightMessage = (UpdateMessage) message;
                model.setHeight(heightMessage.getHeights());  // update model
                view.updateHeightsInView(model.getHeights()); // update view
            }
            else if(message.getClass() == ResetMessage.class) {
                // button addClass was clicked
                // update model and view
                ResetMessage classMessage = (ResetMessage) message;
            }
        }
    }
}