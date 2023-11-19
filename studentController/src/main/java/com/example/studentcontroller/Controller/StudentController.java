package com.example.studentcontroller.Controller;

import com.example.studentcontroller.ApiResponse.ApiResponse;
import com.example.studentcontroller.Model.studentMdel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/stu")
public class StudentController {
    ArrayList<studentMdel> studList = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<studentMdel> getStudList() {
        return studList;
    }


    @PostMapping("/add")
    public ArrayList<studentMdel> addStud(@RequestBody studentMdel studAdd) {
        studList.add(studAdd);
        return studList;
    }


    @DeleteMapping("/delete/{index}")
    public ApiResponse delStud(@PathVariable int index) {
        studList.remove(index);
        return new ApiResponse("Successfully Delete", "200");
    }


    @GetMapping("/check/{name}")
    public ApiResponse check(@PathVariable String name) {
        for (studentMdel n : studList)
            if (n.getName().equalsIgnoreCase(name)) {
                if (n.getStudy().equalsIgnoreCase("graduated")) {
                    return new ApiResponse("True", "200");
                }else if (n.getName().equalsIgnoreCase(name)) {
                    n.getStudy().equalsIgnoreCase("ungraduated");
                    return new ApiResponse("false", "200");
                }

            }
        return new ApiResponse("Sorry not Found", "400");
    }


@GetMapping("/getall")
public ArrayList<studentMdel> studentArray(){

return studList;
    }



}


