package dev.drf.l2db.data;

import java.util.ArrayList;
import java.util.List;

public final class ResultData {
    private List<MobInfo> mobs = new ArrayList<>();

    public void addMob(MobInfo mobInfo) {
        mobs.add(mobInfo);
    }
}
