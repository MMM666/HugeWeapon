package net.minecraft.src;

import java.util.Map;


public class mod_IHW_HugeWeapon extends BaseMod {

	public static String[] cfg_comment = {
		"ScytheAxeID = ItemID +0..+1 (shiftedindex = -256. -1 is Items Disable. min=4096, max=32000)",
		"MoonLightID = ItemID +0..+1 (shiftedindex = -256. -1 is Items Disable. min=4096, max=32000)",
		"isLightWave = Enable LightWave",
		"isDebugMessage = Print Debug Massages."
	};

//	@MLProp(info="ItemID +0..+1 (shiftedindex = -256. -1 is Items Disable.)", min=4096, max=32000)
	public static int cfg_ScytheAxeID = 22270;
//	@MLProp(info="ItemID +0..+1 (shiftedindex = -256. -1 is Items Disable.)", min=4096, max=32000)
	public static int cfg_MoonLightID = 22272;
//	@MLProp(info="Enable LightWave")
	public static boolean cfg_isLightWave = true;
//	@MLProp
	public static boolean cfg_isDebugMessage = true;
	
	public static Item ScytheAxeA;
	public static Item ScytheAxeS;
	public static Item MoonLightN;
	public static Item MoonLightB;
	public static Class classLightWave;


	public static void Debug(String pText, Object... pVals) {
		// �f�o�b�O���b�Z�[�W
		if (cfg_isDebugMessage) {
			System.out.println(String.format("HugeWeapon-" + pText, pVals));
		}
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
	public String getVersion() {
		return "1.6.2-1";
	}

	@Override
	public void load() {
		// MMMLib��Revision�`�F�b�N
		MMM_Helper.checkRevision("4");
		MMM_Config.checkConfig(this.getClass());
		
		// �U�����@�ƈЗ͂𕪂��邽�߂ɃA�C�e�����Q�p�ӂ��Ă���B
		if (cfg_ScytheAxeID > -1) {
			ScytheAxeA = new IHW_ItemScytheAxeA(cfg_ScytheAxeID - 256).setUnlocalizedName("ScytheAxe").func_111206_d("ScytheAxe");
			ScytheAxeS = new IHW_ItemScytheAxeS(cfg_ScytheAxeID - 256 + 1).setUnlocalizedName("ScytheAxe").func_111206_d("ScytheAxe");
			ModLoader.addName(ScytheAxeA, "ScytheAxe");
			ModLoader.addRecipe(new ItemStack(ScytheAxeA),
					" I ",
					"IAI",
					"S  ",
					'I', Item.ingotIron,
					'A', Item.axeIron,
					'S', Item.stick
					);
			if (MMM_Helper.isClient) {
				// �����_���̓o�^
				MMM_ItemRenderManager.setEXRender(ScytheAxeA, IHW_ScytheAxe.instance);
				MMM_ItemRenderManager.setEXRender(ScytheAxeS, IHW_ScytheAxe.instance);
			}
		}
		if (cfg_MoonLightID > -1) {
			MoonLightN = new IHW_ItemMoonLight(cfg_MoonLightID - 256, false).setUnlocalizedName("MoonLight").func_111206_d("MoonLight");
			MoonLightB = new IHW_ItemMoonLight(cfg_MoonLightID - 256 + 1, true).setUnlocalizedName("MoonLight").func_111206_d("MoonLight");
			ModLoader.addName(MoonLightN, "MOONLIGHT");
			ModLoader.addRecipe(new ItemStack(MoonLightN),
					"  I",
					"II ",
					" S ",
					'I', Item.ingotIron,
					'S', Item.swordIron
					);
//			int leid = MMM_Helper.getNextEntityID(false);
			classLightWave = MMM_Helper.getForgeClass(this, "IHW_EntityLightWave");
			if (cfg_isLightWave) {
				MMM_Helper.registerEntity(classLightWave, "LightWave", 0, this, 64, 10, false);
//				ModLoader.registerEntityID(classLightWave, "LightWave", leid);
//				ModLoader.addEntityTracker(this, classLightWave, leid, 64, 10, false);
			}
			if (MMM_Helper.isClient) {
				// �����_���̓o�^
				MMM_ItemRenderManager.setEXRender(MoonLightN, IHW_MoonLight.instance);
				MMM_ItemRenderManager.setEXRender(MoonLightB, IHW_MoonLight.instance);
			}
		}
		
		// �J�X�^���p�P�b�g�̒ǉ�
		ModLoader.registerPacketChannel(this, "IHW");
	}

	@Override
	public void addRenderer(Map var1) {
		var1.put(classLightWave, new IHW_RenderLightWave());
	}

	@Override
	public Packet23VehicleSpawn getSpawnPacket(Entity var1, int var2) {
		// Modloader
		Entity lentity = ((IHW_EntityLightWave)var1).getThrower();
		return new IHW_PacketLightWaveSpawn(var1, 0, lentity == null ? 0 : lentity.entityId);
	}

	@Override
	public void serverCustomPayload(NetServerHandler var1, Packet250CustomPayload var2) {
		ItemStack litemstack = var1.playerEntity.getCurrentEquippedItem();
		if (var2.data[0] == 0x00 && litemstack.getItem() instanceof IHW_IItemScytheAxe) {
			// �ό`�g���K�[
			if (IHW_ScytheAxe.getCount(litemstack) == 0) {
				IHW_ScytheAxe.setScythe(litemstack, !IHW_ScytheAxe.isScythe(litemstack));
				IHW_ScytheAxe.setCount(litemstack, 10);
				
				((WorldServer)var1.playerEntity.worldObj).getEntityTracker().sendPacketToAllAssociatedPlayers(var1.playerEntity, new Packet250CustomPayload("IHW", new byte[] {0x00}));
//				System.out.println("IHW_Server.");
			}
		}
		if (var2.data[0] == 0x01 && litemstack.getItem() instanceof IHW_ItemMoonLight) {
			// ���U
			IHW_MoonLight.setENMode(litemstack, !IHW_MoonLight.isENMode(litemstack));
		}
		if (var2.data[0] == 0x02 && litemstack.getItem() instanceof IHW_ItemMoonLight) {
			// ���g
			if (cfg_isLightWave) {
				World lworld = var1.playerEntity.worldObj;
				IHW_EntityLightWave lentity = getEntity(lworld, var1.playerEntity);
				lworld.spawnEntityInWorld(lentity);
				litemstack.damageItem(2, var1.playerEntity);
			}
		}
	}

	@Override
	public void clientCustomPayload(NetClientHandler var1, Packet250CustomPayload var2) {
//		System.out.println("IHW_Client.");
		ItemStack litemstack = MMM_Helper.mc.thePlayer.getCurrentEquippedItem();
		if (var2.data[0] == 0x00 && litemstack.getItem() instanceof IHW_IItemScytheAxe) {
			// �ό`�g���K�[
			IHW_ScytheAxe.setScythe(litemstack, !IHW_ScytheAxe.isScythe(litemstack));
			IHW_ScytheAxe.setCount(litemstack, 10);
		}
	}

	public static IHW_EntityLightWave getEntity(World par1World, EntityLivingBase par2EntityLiving) {
		try {
			return (IHW_EntityLightWave)classLightWave.getConstructor(World.class, EntityLivingBase.class).newInstance(par1World, par2EntityLiving);
		} catch (Exception e) {
			e.printStackTrace();
//		} catch (Error e) {
		}
		return null;
	}

	public static IHW_EntityLightWave getEntity(World par1World, double par2, double par4, double par6) {
		try {
			return (IHW_EntityLightWave)classLightWave.getConstructor(World.class, double.class, double.class, double.class).newInstance(par1World, par2, par4, par6);
		} catch (Exception e) {
			e.printStackTrace();
//		} catch (Error e) {
		}
		return null;
	}

}
