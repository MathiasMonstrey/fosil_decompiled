package com.misfit.frameworks.buttonservice.operations;

import android.content.Context;
import com.misfit.ble.shine.ShineAdapter;
import com.misfit.ble.shine.ShineAdapter.ShineRetrieveCallback;
import com.misfit.ble.shine.ShineDevice;
import com.misfit.frameworks.buttonservice.interfaces.AsyncOperator;
import com.misfit.frameworks.buttonservice.interfaces.Callback;
import com.misfit.frameworks.buttonservice.interfaces.Cancellable;
import java.util.List;

public class ShineAdapterOperations {

    public static class GetConnectedDevice implements AsyncOperator<Context, List<ShineDevice>> {
        public Cancellable request(Context context, final Callback<List<ShineDevice>> callback) {
            ShineAdapter.getDefaultAdapter(context).getConnectedShines(new ShineRetrieveCallback() {
                public void onConnectedShinesRetrieved(List<ShineDevice> list) {
                    callback.onResponse(list);
                }
            }, "");
            return null;
        }
    }
}
