package com.shabab.vaadin.view;


import com.shabab.vaadin.dto.CarCategory;
import com.shabab.vaadin.service.CarService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("/create")
public class CategoryCreatorView extends VerticalLayout  {

    CarService carService;
    TextField textFieldTitle;
    Grid<CarCategory>  grid;

    public CategoryCreatorView(CarService carService) {
        this.carService=carService;

         textFieldTitle = new TextField();
        textFieldTitle.setClearButtonVisible(true);
        textFieldTitle.setValue("Title");




        Button createButton = new Button("Save");
        createButton.addThemeVariants(ButtonVariant.LUMO_LARGE);

        createButton.addClickListener(buttonClickEvent -> {
String title=textFieldTitle.getValue();

            CarCategory category=new CarCategory();
            category.setTitle(title);
        carService.save(category);
            System.out.println("success done");
            Notification notification = Notification.show("Successfully submitted!");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
fillGrid();

        });



        HorizontalLayout creatLayout = new HorizontalLayout(textFieldTitle,createButton);

        add(creatLayout);




        /////////////////make grid


    grid = new Grid<>(CarCategory.class, false);
        grid.addColumn(CarCategory::getId).setHeader("Id");
        grid.addColumn(CarCategory::getTitle).setHeader("Title");




        grid.addSelectionListener(selectionEvent -> {
            selectionEvent.getFirstSelectedItem().ifPresent(carCategory -> {
                Notification.show(carCategory.getId() + " is selected");
            });
        });

      fillGrid();


        add(grid);
    }

    public  void fillGrid(){

        List<CarCategory> carCategories= carService.getAllCtegories();

        grid.setItems(carCategories);
    }


}
