package com.portfolio.platform.data.source;

import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.model.UAppSystemVersionModel;
import java.util.ArrayList;
import java.util.List;

public class UAppSystemVersionRepository implements UAppSystemVersionDataSource {
    private final int M_DEFAULT_VERSION = 255;
    private final String TAG = UAppSystemVersionRepository.class.getSimpleName();
    private volatile List<UAppSystemVersionRepositoryObserver> mObservers = new ArrayList();
    private final UAppSystemVersionDataSource mUAppSystemVersionDataSource;

    public interface UAppSystemVersionRepositoryObserver {
        void onUAppSystemVersionChanged(UAppSystemVersionModel uAppSystemVersionModel);
    }

    public void addContentObserver(UAppSystemVersionRepositoryObserver uAppSystemVersionRepositoryObserver) {
        MFLogger.d(this.TAG, "Inside .addSavedPresetObserverobserver= " + uAppSystemVersionRepositoryObserver + ", isContains=" + this.mObservers.contains(uAppSystemVersionRepositoryObserver) + ", observer size=" + this.mObservers.size() + ", observerList=" + this.mObservers);
        if (!this.mObservers.contains(uAppSystemVersionRepositoryObserver)) {
            this.mObservers.add(uAppSystemVersionRepositoryObserver);
        }
    }

    public void removeContentObserver(UAppSystemVersionRepositoryObserver uAppSystemVersionRepositoryObserver) {
        MFLogger.d(this.TAG, "Inside .removeSavedPresetObserver");
        if (this.mObservers.contains(uAppSystemVersionRepositoryObserver)) {
            this.mObservers.remove(uAppSystemVersionRepositoryObserver);
        }
    }

    private void notifyUAppSystemVersionChanged(UAppSystemVersionModel uAppSystemVersionModel) {
        MFLogger.d(this.TAG, "Inside .notifyActiveDeviceChanged, observerList=" + this.mObservers.size() + ", observerList=" + this.mObservers);
        for (UAppSystemVersionRepositoryObserver onUAppSystemVersionChanged : this.mObservers) {
            onUAppSystemVersionChanged.onUAppSystemVersionChanged(uAppSystemVersionModel);
        }
    }

    public UAppSystemVersionRepository(@Local UAppSystemVersionDataSource uAppSystemVersionDataSource) {
        this.mUAppSystemVersionDataSource = uAppSystemVersionDataSource;
    }

    public UAppSystemVersionModel getUAppSystemVersionModel(String str) {
        return this.mUAppSystemVersionDataSource.getUAppSystemVersionModel(str);
    }

    public void addOrUpdateUAppSystemVersionModel(UAppSystemVersionModel uAppSystemVersionModel) {
        UAppSystemVersionModel uAppSystemVersionModel2 = this.mUAppSystemVersionDataSource.getUAppSystemVersionModel(uAppSystemVersionModel.getDeviceId());
        if (uAppSystemVersionModel2 == null) {
            uAppSystemVersionModel.setPinType(2);
        } else if (!(uAppSystemVersionModel2.getMajorVersion() == uAppSystemVersionModel.getMajorVersion() && uAppSystemVersionModel2.getMinorVersion() == uAppSystemVersionModel.getMinorVersion())) {
            uAppSystemVersionModel.setPinType(2);
        }
        if (uAppSystemVersionModel.getMajorVersion() == 255 && uAppSystemVersionModel.getMinorVersion() == 255) {
            uAppSystemVersionModel.setPinType(0);
        }
        this.mUAppSystemVersionDataSource.addOrUpdateUAppSystemVersionModel(uAppSystemVersionModel);
        if (uAppSystemVersionModel2 == null || !uAppSystemVersionModel2.equals(uAppSystemVersionModel)) {
            MFLogger.d(this.TAG, "Inside .addOrUpdateUAppSystemVersionModel, data has changed, currentUAppSystemVersionModel=" + uAppSystemVersionModel.toString());
            notifyUAppSystemVersionChanged(uAppSystemVersionModel);
        }
    }
}
