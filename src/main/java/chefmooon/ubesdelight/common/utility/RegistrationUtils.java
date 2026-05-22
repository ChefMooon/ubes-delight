package chefmooon.ubesdelight.common.utility;

import net.minecraft.core.Registry;

import java.util.function.Supplier;

public class RegistrationUtils {
    public static <R, T extends R> Supplier<T> register(String name, Supplier<T> supplier, Registry<R> reg) {
        T object = supplier.get();
        Registry.register(reg, TextUtils.res(name), object);
        return () -> object;
    }
}
