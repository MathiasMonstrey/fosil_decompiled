package com.fossil.wearables.fsl.location;

import com.fossil.wearables.fsl.BaseProvider;
import java.util.List;

public interface LocationProvider extends BaseProvider {
    List<DeviceLocation> getAllDevicesLocation();

    List<LocationGroup> getAllLocationGroups();

    DeviceLocation getDeviceLocation(String str);

    Location getLocation(int i);

    LocationGroup getLocationGroup(int i);

    List<Location> getLocations(int i);

    List<Location> getLocations(int i, boolean z);

    List<Location> getLocations(List<Location> list, boolean z);

    void removeDeviceLocation(DeviceLocation deviceLocation);

    void removeDeviceLocation(String str);

    void removeLocation(Location location);

    void removeLocationGroup(LocationGroup locationGroup);

    void saveDeviceLocation(DeviceLocation deviceLocation);

    void saveLocation(Location location);

    void saveLocationGroup(LocationGroup locationGroup);
}
