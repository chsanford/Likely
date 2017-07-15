package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.ArrayList;

@RestController
public class HelloController {
    private Data _data;

    @RequestMapping("/s") 
    public void start(){
        _data = new Data();
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/analytics")
    public String analytics(){
    	return "analytics";
    }

    @RequestMapping("/item/addLike")
    public Item addLike(@RequestParam(value="itemId") String itemId) {
        Item currentItem = _data.getItems().get(Integer.parseInt(itemId));
        currentItem.addLike();
        return currentItem;
    }

    @RequestMapping("/item/subtractLike")
    public Item subtractLike(@RequestParam(value="itemId") String itemId) {
        Item currentItem = _data.getItems().get(Integer.parseInt(itemId));
        currentItem.subtractLike();
        return currentItem;
    }

    @RequestMapping("/item/addSave")
    public Item addSave(@RequestParam(value="itemId") String itemId) {
        Item currentItem = _data.getItems().get(Integer.parseInt(itemId));
        currentItem.addSave();
        return currentItem;
    }
    
    @RequestMapping("/item/subtractSave")
    public Item subtractSave(@RequestParam(value="itemId") String itemId) {
        Item currentItem = _data.getItems().get(Integer.parseInt(itemId));
        currentItem.subtractSave();
        return currentItem;
    }

    @RequestMapping("/feed")
    public ArrayList<Item> getListItems(){
        return _data.getItems();
    }

    @RequestMapping("/textSearch")
    public ArrayList<Item> textSearch(@RequestParam(value="text") String text) {
        return _data.textSearch(text);
    }

    @RequestMapping("/tagSearch")
    public ArrayList<Item> tagSearch(@RequestParam(value="tag") String tag) {
        return _data.tagSearch(tag);
    }
}
