package com.shabab.vaadin.view;


import com.shabab.vaadin.dto.CarCategory;
import com.shabab.vaadin.service.CarService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("/test")
public class TestView extends VerticalLayout  {


    public TestView(CarService carService) {

        add(new Text("Welcome to Test"));
        add(new Text("Welcome to Test2"));



    }


}
