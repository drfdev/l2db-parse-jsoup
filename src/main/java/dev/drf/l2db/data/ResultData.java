package dev.drf.l2db.data;

import java.util.ArrayList;
import java.util.List;

public final class ResultData {
    private boolean failed = true;
    private List<MobInfo> mobs = new ArrayList<>();

    public void addMob(MobInfo mobInfo) {
        mobs.add(mobInfo);
    }

    public void notFailed() {
        this.failed = false;
    }

    public boolean isFailed() {
        return failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }

    public List<MobInfo> getMobs() {
        return mobs;
    }

    public void setMobs(List<MobInfo> mobs) {
        this.mobs = mobs;
    }
}
