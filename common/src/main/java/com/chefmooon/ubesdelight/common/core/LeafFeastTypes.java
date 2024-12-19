package com.chefmooon.ubesdelight.common.core;

import net.minecraft.util.StringRepresentable;

public enum LeafFeastTypes implements StringRepresentable {
    BASE(0, "base", 1, false, false),
    END(1, "end", 2, false, true),
    MIDDLE(2, "middle", 3, true, true),
    TIP(3, "tip", 0, true, false);

    private final int id;
    private final String name;
    private final int nextStateID;
    private final boolean leftConnect;
    private final boolean rightConnect;


    LeafFeastTypes(int id, String name, int nextStateID, boolean leftConnect, boolean rightConnect) {
        this.id = id;
        this.name = name;
        this.nextStateID = nextStateID;
        this.leftConnect = leftConnect;
        this.rightConnect = rightConnect;
    }

    public int getId() {
        return id;
    }

    public int getNextStateID() {
        return nextStateID;
    }

    public boolean isLeftConnect() {
        return leftConnect;
    }

    public boolean isRightConnect() {
        return rightConnect;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
