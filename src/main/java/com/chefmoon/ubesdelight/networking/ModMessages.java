package com.chefmoon.ubesdelight.networking;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.networking.packet.ItemStackSyncS2CPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessages {

    public static final Identifier ITEM_SYNC = new Identifier(UbesDelightMod.MOD_ID, "item_sync");

    public static void registerC2SPackets() {

    }
    public static void registerS2CPackets() {

        ClientPlayNetworking.registerGlobalReceiver(ITEM_SYNC, ItemStackSyncS2CPacket::receive);
    }
}
