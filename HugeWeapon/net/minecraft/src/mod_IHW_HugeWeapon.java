package net.minecraft.src;

import net.minecraft.client.Minecraft;


public class mod_IHW_HugeWeapon extends BaseMod {

	@MLProp(info="ItemID +0..+1 (shiftedindex = -256. -1 is Items Disable.)", min=4096, max=32000)
	public static int ScytheAxeID = 22270;

	public static Item ScytheAxeA;
	public static Item ScytheAxeS;


	@Override
	public String getVersion() {
		return "1.5.1-1";
	}

	@Override
	public String getName() {
		return "HugeWeapon";
	}

	@Override
	public String getPriorities() {
		return "required-after:mod_MMM_MMMLib";
	}

	@Override
	public void load() {
		if (ScytheAxeID > -1) {
			ScytheAxeA = new IHW_ItemScytheAxeA(ScytheAxeID - 256).setUnlocalizedName("ScytheAxe");
			ScytheAxeS = new IHW_ItemScytheAxeS(ScytheAxeID - 256 + 1).setUnlocalizedName("ScytheAxe");
			ModLoader.addName(ScytheAxeA, "ScytheAxe");
//			ModLoader.addName(ScytheAxeS, "ScytheAxe");
			ModLoader.addRecipe(new ItemStack(ScytheAxeA),
					" I ",
					"IAI",
					"S  ",
					'I', Item.ingotIron,
					'A', Item.axeIron,
					'S', Item.stick
					);
//			MinecraftForgeClient.registerItemRenderer(ScytheAxeID, (IHW_ItemScytheAxe)ScytheAxe);
		}
		
		// カスタムパケットの追加
		ModLoader.registerPacketChannel(this, "IHW");
	}

	@Override
	public void serverCustomPayload(NetServerHandler var1, Packet250CustomPayload var2) {
		ItemStack litemstack = var1.playerEntity.getCurrentEquippedItem();
		if (var2.data[0] == 0x00 && litemstack.getItem() instanceof IHW_IItemScytheAxe) {
			// 変形トリガー
			if (IHW_ScytheAxe.getCount(litemstack) == 0) {
				IHW_ScytheAxe.setScythe(litemstack, !IHW_ScytheAxe.isScythe(litemstack));
				IHW_ScytheAxe.setCount(litemstack, 10);
				
				((WorldServer)var1.playerEntity.worldObj).getEntityTracker().sendPacketToAllAssociatedPlayers(var1.playerEntity, new Packet250CustomPayload("IHW", new byte[] {0x00}));
//				System.out.println("IHW_Server.");
			}
		}
	}

	@Override
	public void clientCustomPayload(NetClientHandler var1, Packet250CustomPayload var2) {
//		System.out.println("IHW_Client.");
		ItemStack litemstack = MMM_Helper.mc.thePlayer.getCurrentEquippedItem();
		if (var2.data[0] == 0x00 && litemstack.getItem() instanceof IHW_IItemScytheAxe) {
			// 変形トリガー
			IHW_ScytheAxe.setScythe(litemstack, !IHW_ScytheAxe.isScythe(litemstack));
			IHW_ScytheAxe.setCount(litemstack, 10);
		}
	}
	
}
