package com.example.javafx;

import com.example.javafx.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import kotlin.collections.ArrayDeque;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Controller {

    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    public void initialize() {
        TodoItem item1 = new TodoItem("Mail birthday card", "Buy a 30th birthday card",
                LocalDate.of(2016, Month.APRIL, 25));
        TodoItem item2 = new TodoItem("Doctors appointment", "See dr Smith",
                LocalDate.of(2016, Month.AUGUST, 23));
        TodoItem item3 = new TodoItem("Finish design proposal", "I promise Mike I'd email",
                LocalDate.of(2016, Month.APRIL, 22));
        TodoItem item4 = new TodoItem("Pickup Doug from train station", "Doug's arriving",
                LocalDate.of(2016, Month.MARCH, 23));
        TodoItem item5 = new TodoItem("Car wash", "Wash my car",
                LocalDate.of(2016, Month.APRIL, 20));

        todoItems = new ArrayDeque<>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    public void handleClickListView() {
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        StringBuilder sb = new StringBuilder(item.getDetails());
        sb.append("\n\n\nDate:\n"+item.getDeadLine().toString());
        itemDetailsTextArea.setText(sb.toString());
    }

}