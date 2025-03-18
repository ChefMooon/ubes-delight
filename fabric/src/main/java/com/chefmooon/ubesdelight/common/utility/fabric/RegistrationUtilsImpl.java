package com.chefmooon.ubesdelight.common.utility.fabric;

import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.core.Registry;

import java.util.function.Supplier;

public class RegistrationUtilsImpl {

    public static <R, T extends R> Supplier<T> register(String name, Supplier<T> supplier, Registry<R> reg) {
        T object = supplier.get();
        Registry.register(reg, TextUtils.res(name), object);
        return () -> object;
    }
}
