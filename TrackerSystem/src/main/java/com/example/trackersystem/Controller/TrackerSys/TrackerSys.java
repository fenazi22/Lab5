package com.example.trackersystem.Controller.TrackerSys;


import com.example.trackersystem.ApiTrack.ApiTrac;
import com.example.trackersystem.Model.project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/trac")
public class TrackerSys {
    ArrayList<project> tack = new ArrayList<>();
    project newProject = new project("122243", "Project One", "Description of Project One", "InProgress", "CompanyX");
    project newProject1 = new project("12243", "Project One", "Description of Project One", "InProgress", "CompanyX");
    project newProject2 = new project("112243", "Project One", "Description of Project One", "InProgress", "CompanyX");

    @GetMapping("/get")
    public ArrayList<project> Display() {
        ArrayList<project> projects = tack;
        return projects;
    }


    @PutMapping("/update/{index}")
    public ApiTrac Update(@PathVariable int index, project update) {
        tack.set(index, update);
        return new ApiTrac("Successfully Update", "200");
    }

    @DeleteMapping("/delete/index")
    public ApiTrac deleTrac(@PathVariable int index) {
        tack.remove(index);
        return new ApiTrac("Succefully Deleted", "200");
    }

    @PutMapping("/change/{index}")
    public ApiTrac changeTrac(@PathVariable int index) {
        project chane = tack.get(index);
        if (chane.getStatus().equals("done")) {
            chane.setStatus("not done");
            tack.set(index, chane);
            return new ApiTrac("Successfully to change to not done", "200");
        } else {
            chane.setStatus("done");
            tack.set(index, chane);
            return new ApiTrac("Successfully to change to done", "200");
        }


    }

    @GetMapping("/search/{titles}")
    public ApiTrac search(@PathVariable String titles) {
        for (project sear : tack) {
            if (sear.getTitle().equals(titles))
                return new ApiTrac("I found", "200 " + sear);
            else
                return new ApiTrac("Sorry not Found", "200 " + sear);
        }
        return new ApiTrac("not Found", "400");
    }

    @GetMapping("/com/{index}/{com}")
    public ArrayList<project> displayProjects(@PathVariable int index, @PathVariable String comName) {

        for (project proje : tack) {
            if (proje.getCompanyName().equals(comName)) {
                System.out.println("Project Name: " + proje.getCompanyName());
            }
        }
        return tack;
    }


}
