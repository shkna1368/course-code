package com.shabab.vaadin.view;


import com.shabab.vaadin.dto.CarCategory;
import com.shabab.vaadin.service.CarService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("/view")
public class CarCategoryView extends VerticalLayout  {
 String userId;
    Grid<CarCategory> grid;
    CarService carService;

    public CarCategoryView(CarService carService) {
        this.carService=carService;

        add(new Text("Welcome to Car"));

        grid = new Grid<>(CarCategory.class, false);
        grid.addColumn(CarCategory::getId).setHeader("Id");
        grid.addColumn(CarCategory::getTitle).setHeader("Title");




        grid.addSelectionListener(selectionEvent -> {
                    selectionEvent.getFirstSelectedItem().ifPresent(carCategory -> {
                        Notification.show(carCategory.getId() + " is selected");
                    });
                });

        List<CarCategory> carCategories= carService.getAllCtegories();

        grid.setItems(carCategories);


        add(grid);

    }


}
