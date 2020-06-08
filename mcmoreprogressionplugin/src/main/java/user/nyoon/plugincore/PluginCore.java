package user.nyoon.plugincore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import user.nyoon.commands.CondenseEmeraldsCmd;
import user.nyoon.commands.CustomItemCmd;
import user.nyoon.commands.DecondenseEmeraldsCmd;
import user.nyoon.commands.Survival;
import user.nyoon.commands.TestCmd;
import user.nyoon.helperclasses.Upgrader;
import user.nyoon.listeners.AlterCraftingResult;
import user.nyoon.listeners.AnvilInteract;
import user.nyoon.listeners.AnvilMenu;
import user.nyoon.listeners.CloseInventory;
import user.nyoon.listeners.DeathPenalty;
import user.nyoon.listeners.EnchTableMenu;
import user.nyoon.listeners.EnderPearlCooldown;
import user.nyoon.listeners.FletchingTableInteract;
import user.nyoon.listeners.FletchingTableMenu;
import user.nyoon.listeners.GrindstoneInteract;
import user.nyoon.listeners.GrindstoneMenu;
import user.nyoon.listeners.InstantHealthPotion;
import user.nyoon.listeners.KillCartographers;
import user.nyoon.listeners.SmithingTableInteract;
import user.nyoon.listeners.SmithingTableMenu;
import user.nyoon.listeners.UpgradeCraftingInteract;
import user.nyoon.listeners.UpgradeCraftingMenu;
import user.nyoon.listeners.UsablesEvent;
import user.nyoon.mobdrops.MobDrops;
import user.nyoon.objectlists.BlacklistedItems;
import user.nyoon.objectlists.Catalysts;
import user.nyoon.objectlists.Currency;
import user.nyoon.objectlists.Materials;
import user.nyoon.objectlists.Molds;
import user.nyoon.objectlists.Polishes;
import user.nyoon.objectlists.Recipes;
import user.nyoon.objectlists.UpgradeableEquips;
import user.nyoon.objectlists.Usables;
import user.nyoon.objectlists.Whetstones;
import user.nyoon.recipes.ArrowRecipes;
import user.nyoon.recipes.CustomForgingRecipes;
import user.nyoon.recipes.UpgraderRecipes;
import user.nyoon.runnables.AutoEventTimer;
import user.nyoon.runnables.CooldownRunner;

public class PluginCore extends JavaPlugin implements Listener {
	
	//create arraylists for itemstacks
    private static ArrayList<ItemStack> blacklistedItems = new ArrayList<>();
    private static ArrayList<ItemStack> cMaterials = new ArrayList<>();
    private static ArrayList<ItemStack> cRecipes = new ArrayList<>();
    private static ArrayList<ItemStack> cUsables = new ArrayList<>();
    private static ArrayList<ItemStack> cMolds = new ArrayList<>();
    private static ArrayList<ItemStack> cCurrency = new ArrayList<>();
    
    //create hashmaps for recipes
    public static HashMap<String, ItemStack> customForgingRecipes = new HashMap<>();
    public static HashMap<String, ItemStack> arrowRecipes = new HashMap<>();
    public static HashMap<String, Upgrader> upgraderRecipes = new HashMap<>();
    
    //hashmaps for itemstacks
    public static HashMap<Material, ItemStack> upgradeables = new HashMap<>();
    public static HashMap<String, ArrayList<ItemStack>> catalysts = new HashMap<>();
    private static HashMap<String, ArrayList<ItemStack>> cWhetstones = new HashMap<>();
    private static HashMap<String, ArrayList<ItemStack>> cPolishes = new HashMap<>();
    
    //Arraylist of cooldown hashmaps
    public static ArrayList<HashMap<UUID, Integer>> cdMaps = new ArrayList<>();
    
    //hashmaps for cooldowns
    //NOTE: Make sure to add lines in onEnable() method to add new hashmaps to the cdMaps arraylist.
    public static HashMap<UUID, Integer> bombCds = new HashMap<>();
    
    //random generator
    public static Random rand;
	
    //constants to manipulate for balancing
    public final static int bombCDTime = 20;
    
    //ArrayList containing all currently spawned bosses with custom ai
    public static HashMap<String, LivingEntity> spawnedBosses = new HashMap<>();
    
	//run when plugin enabled
	@Override
	public void onEnable() {
		//register listeners
		getServer().getPluginManager().registerEvents(new CloseInventory(), this);
		getServer().getPluginManager().registerEvents(new GrindstoneInteract(), this);
		getServer().getPluginManager().registerEvents(new GrindstoneMenu(), this);
		getServer().getPluginManager().registerEvents(new AnvilInteract(), this);
		getServer().getPluginManager().registerEvents(new AnvilMenu(), this);
		getServer().getPluginManager().registerEvents(new UsablesEvent(), this);
		getServer().getPluginManager().registerEvents(new AlterCraftingResult(), this);
		getServer().getPluginManager().registerEvents(new SmithingTableInteract(), this);
		getServer().getPluginManager().registerEvents(new SmithingTableMenu(), this);
		getServer().getPluginManager().registerEvents(new EnderPearlCooldown(), this);
		getServer().getPluginManager().registerEvents(new UpgradeCraftingInteract(), this);
		getServer().getPluginManager().registerEvents(new UpgradeCraftingMenu(), this);
		getServer().getPluginManager().registerEvents(new FletchingTableInteract(), this);
		getServer().getPluginManager().registerEvents(new FletchingTableMenu(), this);
		getServer().getPluginManager().registerEvents(new KillCartographers(), this);
		getServer().getPluginManager().registerEvents(new MobDrops(), this);
		getServer().getPluginManager().registerEvents(new InstantHealthPotion(), this);
		getServer().getPluginManager().registerEvents(new EnchTableMenu(), this);
		getServer().getPluginManager().registerEvents(new DeathPenalty(), this);
		
		//register commands
		this.getCommand("giveCustomItems").setExecutor(new CustomItemCmd());
		this.getCommand("condense").setExecutor(new CondenseEmeraldsCmd());
		this.getCommand("test").setExecutor(new TestCmd());
		this.getCommand("decondense").setExecutor(new DecondenseEmeraldsCmd());
		this.getCommand("survival").setExecutor(new Survival());
		
        //populate lists
		populateLists();

		//add cooldown hashmaps to arraylist of hashmaps
		cdMaps.add(bombCds);
		
        //create objects
        rand = new Random();
        
        //run runnables
        CooldownRunner cdRunner = new CooldownRunner();
        cdRunner.runTaskTimer(this, 0, 20); //this runs every 20 ticks or every second.
        
        
        AutoEventTimer eventRunner = new AutoEventTimer();
        eventRunner.runTaskTimer(this, 0, 1200);
        
	}
	
	//run when plugin disabled
	@Override
	public void onDisable() {
		
	}
	
	//populate all lists
	public static void populateLists() {
		
		//populate recipes
		customForgingRecipes = CustomForgingRecipes.popCustomForgingRecipes();
		ArrowRecipes.popArrowRecipes();
		
		
		//populate items
        cMaterials = Materials.popMaterials();
        cPolishes = Polishes.popPolishes();
        cRecipes = Recipes.popRecipes();
        cUsables = Usables.popUsables();
        cWhetstones = Whetstones.popWhetstones();
        blacklistedItems = BlacklistedItems.popBlacklist();
        upgradeables = UpgradeableEquips.popUpgradeables();
        cMolds = Molds.popMolds();
        catalysts = Catalysts.popCatalysts();
        cCurrency = Currency.popCurrency();

        upgraderRecipes = UpgraderRecipes.popUpgradeablesRecipes();
	}
	
	/*
	//get worldguard plugin
	public WorldGuardPlugin getWorldGuard() {
		Plugin plugin = this.getServer().getPluginManager().getPlugin("WorldGuard");
		
		if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
			return null;
		}
		
		return (WorldGuardPlugin) plugin;
	}
	*/
	
	//used to get random int from 0 to num
	public static int randInt(int num) {
		double random = rand.nextDouble() * (num + .9);
		
		return (int) random; 
	}
	
	//get blacklisted items
	public static ArrayList<ItemStack> getBlacklistedItems() {
		return blacklistedItems;
	}
	
	//get Materials
	public static ArrayList<ItemStack> getMaterials() {
		return cMaterials;
	}
	
	//get Polishes
	public static HashMap<String, ArrayList<ItemStack>> getPolishes() {
		return cPolishes;
	}
	
	//get Recipes
	public static ArrayList<ItemStack> getRecipes() {
		return cRecipes;
	}
	
	//get Usables
	public static ArrayList<ItemStack> getUsables() {
		return cUsables;
	}
	
	//get Whetstones
	public static HashMap<String, ArrayList<ItemStack>> getWhetstones() {
		return cWhetstones;
	}
	
	//get Upgradeables
	public static HashMap<Material, ItemStack> getUpgradeables() {
		return upgradeables;
	}
	
	//get upgraders
	public static HashMap<String, Upgrader> getUpgraderRecipes() {
		return upgraderRecipes;
	}
	
	//get molds
	public static ArrayList<ItemStack> getMolds() {
		return cMolds;
	}
	
	//get catalyst hashmap
	public static HashMap<String, ArrayList<ItemStack>> getCatalysts() {
		return catalysts;
	}
	
	//get currencies
	public static ArrayList<ItemStack> getCurrencies() {
		return cCurrency;
	}
	
	//get cdMaps
	public static ArrayList<HashMap<UUID, Integer>> getCDMaps() {
		return cdMaps;
	}
	
	//get spawned bosses
	public static HashMap<String, LivingEntity> getSpawnedBosses() {
		return spawnedBosses;
	}
}
