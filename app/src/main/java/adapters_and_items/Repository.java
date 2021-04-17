package adapters_and_items;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import search_classes.SearchViewModel;

public class Repository
{

    // for RecyclerShipment we use LiveData
    // Data is stored in  SearchViewModel.getShipmentLiveData().getValue();
    public static ArrayList<ShipmentItem> getShipmentsFromApi()
    {
        // TODO -->Background Task to get Shipments
        ApiShipmentSearch task=new ApiShipmentSearch();
        task.DoTaskInBack();
        return SearchViewModel.getShipmentLiveData().getValue();  //Update Recycler View Adapters
    }

    public static ArrayList<TripItem> getTripsFromApi()
    {
        // TODO -->Background Task to get Trips
        ApiTripSearch task=new ApiTripSearch();
        task.DoTaskInBack();
        return SearchViewModel.getTripLiveData().getValue();  //Update Recycler View Adapters
    }


}

