package com.fossil.wearables.fsl.location;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationProviderImpl extends BaseDbProvider implements LocationProvider {
    public static final String DB_NAME = "location.db";

    class C41911 extends HashMap<Integer, UpgradeCommand> {

        class C41901 implements UpgradeCommand {
            C41901() {
            }

            public void execute(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("CREATE TABLE devicelocation (deviceSerial VARCHAR PRIMARY KEY, longitude DOUBLE, latitude DOUBLE, timestamp BIGINT)");
            }
        }

        C41911() {
            put(Integer.valueOf(2), new C41901());
        }
    }

    public LocationProviderImpl(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 2;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{LocationGroup.class, Location.class, DeviceLocation.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return new C41911();
    }

    private Dao<LocationGroup, Integer> getLocationGroupDao() throws SQLException {
        return this.databaseHelper.getDao(LocationGroup.class);
    }

    private Dao<Location, Integer> getLocationDao() throws SQLException {
        return this.databaseHelper.getDao(Location.class);
    }

    private Dao<DeviceLocation, String> getDeviceLocationDao() throws SQLException {
        return this.databaseHelper.getDao(DeviceLocation.class);
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }

    public List<LocationGroup> getAllLocationGroups() {
        List<LocationGroup> arrayList = new ArrayList();
        try {
            arrayList = getLocationGroupDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public void saveLocationGroup(LocationGroup locationGroup) {
        if (locationGroup != null) {
            try {
                LocationGroup locationGroup2 = (LocationGroup) getLocationGroupDao().queryForSameId(locationGroup);
                if (locationGroup2 != null) {
                    locationGroup.setDbRowId(locationGroup2.getDbRowId());
                }
                getLocationGroupDao().createOrUpdate(locationGroup);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeLocationGroup(LocationGroup locationGroup) {
        if (locationGroup != null) {
            try {
                for (Location removeLocation : locationGroup.getLocations()) {
                    removeLocation(removeLocation);
                }
                getLocationGroupDao().delete((Object) locationGroup);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public LocationGroup getLocationGroup(int i) {
        try {
            return (LocationGroup) getLocationGroupDao().queryForId(Integer.valueOf(i));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveLocation(Location location) {
        if (location != null) {
            try {
                QueryBuilder queryBuilder = getLocationDao().queryBuilder();
                queryBuilder.where().le(DeviceLocation.COLUMN_LATITUDE, Double.valueOf(location.getLatitude())).and().ge(DeviceLocation.COLUMN_LONGITUDE, Double.valueOf(location.getLongitude()));
                List query = getLocationDao().query(queryBuilder.prepare());
                if (query != null && query.size() > 0) {
                    Location location2 = (Location) query.get(0);
                    if (location2 != null) {
                        location.setDbRowId(location2.getDbRowId());
                    }
                }
                getLocationDao().createOrUpdate(location);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeLocation(Location location) {
        if (location != null) {
            try {
                getLocationDao().delete((Object) location);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Location getLocation(int i) {
        try {
            return (Location) getLocationDao().queryForId(Integer.valueOf(i));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Location> getLocations(int i) {
        List<Location> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getLocationDao().queryBuilder();
            queryBuilder.where().eq("location_group_id", Integer.valueOf(i));
            arrayList = getLocationDao().query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public List<Location> getLocations(int i, boolean z) {
        List<Location> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getLocationDao().queryBuilder();
            queryBuilder.where().eq("verified", Boolean.valueOf(z)).and().eq("location_group_id", Integer.valueOf(i));
            arrayList = getLocationDao().query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public List<Location> getLocations(List<Location> list, boolean z) {
        List<Location> arrayList = new ArrayList();
        for (Location location : list) {
            if (location.isVerified() == z) {
                arrayList.add(location);
            }
        }
        return arrayList;
    }

    public void saveDeviceLocation(DeviceLocation deviceLocation) {
        if (deviceLocation != null) {
            try {
                Object deviceLocation2 = getDeviceLocation(deviceLocation.getDeviceSerial());
                if (deviceLocation2 != null) {
                    deviceLocation2.setLatitude(deviceLocation.getLatitude());
                    deviceLocation2.setLongitude(deviceLocation.getLongitude());
                    deviceLocation2.setTimeStamp(deviceLocation.getTimeStamp());
                    getDeviceLocationDao().update(deviceLocation2);
                    return;
                }
                getDeviceLocationDao().create((Object) deviceLocation);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public DeviceLocation getDeviceLocation(String str) {
        try {
            QueryBuilder queryBuilder = getDeviceLocationDao().queryBuilder();
            queryBuilder.where().eq(DeviceLocation.COLUMN_DEVICE_SERIAL, str);
            queryBuilder.orderBy("timestamp", false);
            List query = getDeviceLocationDao().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                return (DeviceLocation) query.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DeviceLocation> getAllDevicesLocation() {
        List<DeviceLocation> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getDeviceLocationDao().queryBuilder();
            queryBuilder.orderBy("timestamp", true);
            Collection query = getDeviceLocationDao().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                arrayList.addAll(query);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public void removeDeviceLocation(DeviceLocation deviceLocation) {
        try {
            getDeviceLocationDao().delete((Object) deviceLocation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeDeviceLocation(String str) {
        try {
            QueryBuilder queryBuilder = getDeviceLocationDao().queryBuilder();
            queryBuilder.where().eq(DeviceLocation.COLUMN_DEVICE_SERIAL, str);
            List<DeviceLocation> query = getDeviceLocationDao().query(queryBuilder.prepare());
            if (query != null && query.size() > 0) {
                for (DeviceLocation removeDeviceLocation : query) {
                    removeDeviceLocation(removeDeviceLocation);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
