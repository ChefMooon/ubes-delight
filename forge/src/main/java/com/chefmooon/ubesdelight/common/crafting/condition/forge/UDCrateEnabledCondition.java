package com.chefmooon.ubesdelight.common.crafting.condition.forge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.Configuration;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class UDCrateEnabledCondition implements ICondition {
    private final ResourceLocation location;
    public UDCrateEnabledCondition(ResourceLocation location) {
        this.location = location;
    }
    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext iContext) {
        return Configuration.isEnableUDCropCrates();
    }

    public static class Serializer implements IConditionSerializer<UDCrateEnabledCondition> {
        private final ResourceLocation location;
        public Serializer() {
            this.location = new ResourceLocation(UbesDelight.MOD_ID, "ud_crates_enabled");
        }
        @Override
        public void write(JsonObject jsonObject, UDCrateEnabledCondition iCondition) {

        }

        @Override
        public UDCrateEnabledCondition read(JsonObject jsonObject) {
            return new UDCrateEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
