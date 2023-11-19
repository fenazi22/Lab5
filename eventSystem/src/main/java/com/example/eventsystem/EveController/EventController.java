package com.example.eventsystem.EveController;

import com.example.eventsystem.ApiEve.ApiEve;
import com.example.eventsystem.Model.EveSys;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {
    ArrayList<EveSys> eveList = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<EveSys> dis() {
        return eveList;
    }


    @PutMapping("/update/{index}")
    public ArrayList<EveSys> updateEvent(@PathVariable int index, @RequestBody EveSys updOpject) {
        eveList.set(index, updOpject);
        return eveList;
    }

    @DeleteMapping("/delete/{index}")
    public ArrayList<EveSys> delEven(@PathVariable int index){
        eveList.remove(index);
        return eveList;
    }

    @PutMapping("/change/{index}/{Capacity}")
    public ArrayList<EveSys> changeStauts(@PathVariable int index,@PathVariable String Capacitys) {
        EveSys change = eveList.get(index);
        change.setCapacity(Capacitys);
 return eveList;
    }

    @GetMapping("/search/{id}")
    public ApiEve searchEvent(@PathVariable String id){
        for (EveSys search:eveList) {
            if (search.getID().equals(id))
        return new ApiEve("I found"+search);
        }

        return new ApiEve("not found");
    }


}




