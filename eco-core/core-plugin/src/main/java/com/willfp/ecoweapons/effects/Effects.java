package com.willfp.ecoweapons.effects;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import com.willfp.ecoweapons.effects.effects.EffectArrowStorm;
import com.willfp.ecoweapons.effects.effects.EffectBleed;
import com.willfp.ecoweapons.effects.effects.EffectConsoleCommand;
import com.willfp.ecoweapons.effects.effects.EffectRailgun;
import com.willfp.ecoweapons.effects.effects.EffectSpawnHelper;
import com.willfp.ecoweapons.effects.effects.EffectStrikeLightning;
import com.willfp.ecoweapons.effects.effects.EffectWarp;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@UtilityClass
@SuppressWarnings("unused")
public class Effects {
    /**
     * All registered effects.
     */
    private static final BiMap<String, Effect> BY_NAME = HashBiMap.create();

    public static final Effect STRIKE_LIGHTNING = new EffectStrikeLightning();
    public static final Effect RAILGUN = new EffectRailgun();
    public static final Effect ARROW_STORM = new EffectArrowStorm();
    public static final Effect WARP = new EffectWarp();
    public static final Effect CONSOLE_COMMAND = new EffectConsoleCommand();
    public static final Effect SPAWN_HELPER = new EffectSpawnHelper();
    public static final Effect BLEED = new EffectBleed();

    /**
     * Get effect matching name.
     *
     * @param name The name to query.
     * @return The matching effect, or null if not found.
     */
    @Nullable
    public static Effect getByName(@NotNull final String name) {
        return BY_NAME.get(name);
    }

    /**
     * List of all registered effects.
     *
     * @return The effects.
     */
    public static List<Effect> values() {
        return ImmutableList.copyOf(BY_NAME.values());
    }

    /**
     * Add new effect to EcoWeapons.
     *
     * @param effect The effect to add.
     */
    public static void addNewEffect(@NotNull final Effect effect) {
        BY_NAME.remove(effect.getName());
        BY_NAME.put(effect.getName(), effect);
    }
}
