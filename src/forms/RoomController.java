//http://code.makery.ch/blog/javafx-8-tableview-sorting-filtering/
//http://code.makery.ch/library/javafx-8-tutorial/ru/part2/

package forms;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import com.google.gson.Gson;
import entity.Room;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RoomController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Room> table;

    @FXML
    private TableColumn<Room, String> korpus_table;

    @FXML
    private TableColumn<Room, String> name_table;

    @FXML
    private TableColumn<Room, String> count_place_table;

    @FXML
    private TableColumn<Room, String> count_comp_table;

    @FXML
    private TableColumn<Room, String> state_room_table;

    @FXML
    private TextField korpus_footer;

    @FXML
    private TextField name_footer;

    @FXML
    private TextField count_plac_footer;

    @FXML
    private TextField count_comp_footer;

    @FXML
    private TextField state_room_footer;

    @FXML
    private Button addBtn;

    @FXML
    private Button blockBtn;

    @FXML
    private TextField search_field1;


    @FXML
    void initialize() {
        
        ObservableList<Room> masterData = FXCollections.observableArrayList();

        Gson g = new Gson();
        Room[] rooms_all = g.fromJson(HttpRequest.get("http://localhost:1337/room/all").body(), Room[].class);
        for(Room temp: rooms_all){
            masterData.add(temp);
            temp.show();
        }

        korpus_table.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getKorpus()));
        name_table.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getName()));
        count_place_table.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCount_place()));
        count_comp_table.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCount_comp()));
        state_room_table.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getState_room()));

        FilteredList<Room> filteredData = new FilteredList<>(masterData, p -> true);


       search_field1.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(room -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (room.getKorpus().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }else if (room.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }else if (room.getCount_place().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }else if (room.getCount_comp().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }else if (room.getState_room().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });


       SortedList<Room> sortedData = new SortedList<>(filteredData);
       sortedData.comparatorProperty().bind(table.comparatorProperty());
       table.setItems(sortedData);

       addBtn.setOnAction((ActionEvent event) ->{
           Map<String, String> rooms = new HashMap<String, String>();
           Room temp = new Room();
           String korpus = korpus_footer.getText().trim();
           String name = name_footer.getText().trim();
           String count_pl = count_plac_footer.getText().trim();
           String count_cmp = count_comp_footer.getText().trim();
           String state = state_room_footer.getText().trim();
           masterData.add(new Room( korpus, name, count_pl, count_cmp, state));
           rooms.put("v_korpus", korpus);
           rooms.put("v_name", name);
           rooms.put("v_count_place", count_pl);
           rooms.put("v_count_pc", count_cmp);
           System.out.println(HttpRequest.post("http://localhost:1337/room/new").form(rooms).body());
       });

        blockBtn.setOnAction((ActionEvent event) ->{
            Room selectedItem = table.getSelectionModel().getSelectedItem();
            System.out.println(selectedItem.getId());
            String st = selectedItem.getId();
                System.out.println(HttpRequest.post("http://localhost:1337/room/block/"+st).body());


        });

    }

    /*public String autoInc(FilteredList<Room> filteredData){
        String st = new String();

        for(int i = 1; i>=10000; i++) {
            filteredData.setPredicate(room -> {
                if(room.getId().toLowerCase().contains(Integer.toString(i).toLowerCase())){
                    return true;
                }
                return false;
            });
            st=Integer.toString(i);

        }
        return st;
    }*/


}
