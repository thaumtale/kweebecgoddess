package net.thaumtale.kweebecgoddess.procedures;

import javax.annotation.Nonnull;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.math.util.ChunkUtil;
import com.hypixel.hytale.server.core.asset.type.blocktick.BlockTickStrategy;
import com.hypixel.hytale.server.core.asset.type.blocktick.config.TickProcedure;
import com.hypixel.hytale.server.core.asset.type.fluid.Fluid;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.chunk.ChunkColumn;
import com.hypixel.hytale.server.core.universe.world.chunk.WorldChunk;
import com.hypixel.hytale.server.core.universe.world.chunk.section.FluidSection;
import com.hypixel.hytale.server.core.universe.world.storage.ChunkStore;

public class GoddessStatueProcedure extends TickProcedure{

	private int RADIUS = 5;
	private int fireId;
	private int fakeFireId;

 	@Override
    public BlockTickStrategy onTick(World world, WorldChunk chunk, int x, int y, int z, int blockId) {

		Store<ChunkStore> store = world.getChunkStore().getStore();
		int sectionY = ChunkUtil.chunkCoordinate(y);
		ChunkColumn column = store.getComponent(chunk.getReference(), ChunkColumn.getComponentType());
		Ref<ChunkStore> section = column.getSection(sectionY);
		FluidSection fluidSectionComponent = store.getComponent(section, FluidSection.getComponentType());

		for (int dx = -RADIUS; dx <= RADIUS; dx++) {
            for (int dz = -RADIUS; dz <= RADIUS; dz++) {
				for (int dy = -RADIUS; dy <= RADIUS; dy++) {

					int tx = x + dx;
					int ty = y + dy;
					int tz = z + dz;

					int fluidId = fluidSectionComponent.getFluidId(tx, ty, tz);
					if (fluidId == 0) continue;

					if (fluidId == this.fireId){
						fluidSectionComponent.setFluid(tx, ty, tz, this.fakeFireId, (byte) 1);
					}
				}
            }
        }

	    return BlockTickStrategy.CONTINUE;
    }



	@Nonnull
   public static final BuilderCodec<GoddessStatueProcedure> CODEC = BuilderCodec.builder(
    GoddessStatueProcedure.class, GoddessStatueProcedure::new, TickProcedure.BASE_CODEC)
   .append(new KeyedCodec<>("StatueProtectionRadius", Codec.INTEGER), (instance, value) -> instance.RADIUS = value, instance -> instance.RADIUS)
   .add()
   .build();


	GoddessStatueProcedure() {
		this.fireId = Fluid.getAssetMap().getIndex("Fire");
		this.fakeFireId = Fluid.getAssetMap().getIndex("FakeFire");
	}

}
