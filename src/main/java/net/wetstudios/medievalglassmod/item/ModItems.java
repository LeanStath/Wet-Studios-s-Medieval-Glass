package net.wetstudios.medievalglassmod.item;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wetstudios.medievalglassmod.MedievalGlassMod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MedievalGlassMod.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
