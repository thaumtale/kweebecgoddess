package net.thaumtale.kweebecgoddess;

import com.hypixel.hytale.server.core.asset.type.blocktick.config.TickProcedure;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import net.thaumtale.kweebecgoddess.procedures.GoddessStatueProcedure;

import javax.annotation.Nonnull;

public class KweebecGoddess extends JavaPlugin {

    public KweebecGoddess(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
	TickProcedure.CODEC.register("GoddessStatueProcedure", GoddessStatueProcedure.class, GoddessStatueProcedure.CODEC);
    }
}
