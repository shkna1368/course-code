package com.mapsa.springvaadin.view;

import com.flowingcode.vaadin.addons.googlemaps.*;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

import java.util.Arrays;
@Route("/map/:userId")
public class MapView extends VerticalLayout implements BeforeEnterObserver {
 String userId;

    public MapView() {

        add(new Text("Welcome to Map."+userId));


        String apiKey="AIzaSyAVO0TeETp0D1TzG4LF_iRvHGJge0SRJpU";
        GoogleMap gmaps = new GoogleMap(apiKey,null,null);
        gmaps.setMapType(GoogleMap.MapType.SATELLITE);
        gmaps.setSizeFull();
        gmaps.setCenter(new LatLon(    35.70019, 51.33841));
        gmaps.addMarker("Center", new LatLon(    35.70019, 51.33841), true, "");
        GoogleMapPolygon gmp = gmaps.addPolygon(Arrays.asList(new GoogleMapPoint(gmaps.getCenter()),
                new GoogleMapPoint(gmaps.getCenter().getLat(),gmaps.getCenter().getLon()+1),
                new GoogleMapPoint(gmaps.getCenter().getLat()+1,gmaps.getCenter().getLon())));

     /*   VerticalLayout layout = new VerticalLayout();
        GoogleMap googleMap = new GoogleMap("apiKey", null, "english");
       *//* googleMap.setSizeFull();*//*
        googleMap.addMarker("DRAGGABLE: Paavo Nurmi Stadion", new LatLon(
                60.442423, 22.26044), true, "VAADIN/1377279006_stadium.png");
        GoogleMapMarker kakolaMarker = googleMap.addMarker("DRAGGABLE: Kakolan vankila",
                new LatLon(60.44291, 22.242415), true, null);
        googleMap.addMarker("NOT DRAGGABLE: Iso-Heikkilä", new LatLon(
                60.450403, 22.230399), false, null);
        googleMap.setMinZoom(4);
        googleMap.setMaxZoom(16);
        layout.add(googleMap);*/


        add(gmaps);

    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        userId = event.getRouteParameters().get("userId").get();
        System.out.println(userId);
    }
}
