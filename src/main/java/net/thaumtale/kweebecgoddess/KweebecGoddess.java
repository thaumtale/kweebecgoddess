package net.thaumtale.kweebecgoddess;

import com.hypixel.hytale.server.core.asset.type.blocktick.config.TickProcedure;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import net.thaumtale.kweebecgoddess.commands.ExampleCommand;
import net.thaumtale.kweebecgoddess.events.ExampleEvent;
import net.thaumtale.kweebecgoddess.procedures.GoddessStatueProcedure;

import javax.annotation.Nonnull;

public class KweebecGoddess extends JavaPlugin {

    public KweebecGoddess(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        this.getCommandRegistry().registerCommand(new ExampleCommand("example", "An example command"));
        this.getEventRegistry().registerGlobal(PlayerReadyEvent.class, ExampleEvent::onPlayerReady);

	TickProcedure.CODEC.register("GoddessStatueProcedure", GoddessStatueProcedure.class, GoddessStatueProcedure.CODEC);
    }
}
