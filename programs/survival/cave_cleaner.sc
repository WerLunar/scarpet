// Kill zombies/drowneds holding naturally dropped items within 50 blocks of the player
// Reimplementing cave cleaner from Hermitcraft Season 8 since it's not public
// Only effective on spectator player

// Currently zombies/drowneds are not necessarily in cave to be killed 
// And I have no plan to implement "if in cave" checks

// Be ware zombies/drowneds that users want to keep might be removed if they are holding items listed in the if condition
// I have no plan to implement any fix to this either

__config() -> (
   m(
      l('stay_loaded','true')
   )
);

__command() -> (
    if (query(player(),'gamemode') != 'spectator',
        exit('You must be in spectator mode to run cave cleaner');
    );
    count = 0;
    l (x, y, z) = pos(player());
    for (zombies = entity_area('zombie', x,y,z, 50,50,50), 
        holding = query(_, 'holds', 'mainhand');
        if (holding != null, 
            holding_item = get(holding,0);
            if (holding_item == 'string' || holding_item == 'rotten_flesh' || holding_item == 'bone' || holding_item == 'arrow' || holding_item == 'spider_eye' || holding_item == 'glass_bottle' || holding_item == 'gunpowder' || holding_item == 'sugar' || holding_item == 'stick' || holding_item == 'glowstone_dust' || holding_item == 'redstone' || holding_item == 'egg' || holding_item == 'brown_mushroom' || holding_item == 'red_mushroom' , 
                modify(_, 'remove');
                count = count + 1
            )
        )
    );
    for (drowneds = entity_area('drowned', x,y,z, 50,50,50), 
        holding = query(_, 'holds', 'mainhand');
        if (holding != null, 
            holding_item = get(holding,0);
            if (holding_item == 'string' || holding_item == 'rotten_flesh' || holding_item == 'bone' || holding_item == 'arrow' || holding_item == 'spider_eye' || holding_item == 'glass_bottle' || holding_item == 'gunpowder' || holding_item == 'sugar' || holding_item == 'stick' || holding_item == 'glowstone_dust' || holding_item == 'redstone' || holding_item == 'egg' || holding_item == 'brown_mushroom' || holding_item == 'red_mushroom' , 
                modify(_, 'remove');
                count = count + 1
            )
        )
    );
    for (drowneds = entity_area('enderman', x,y,z, 50,50,50), 
        holding = query(_, 'holds', 'mainhand');
        if (holding != null, 
            holding_item = get(holding,0);
            if (holding_item == 'cactus' || holding_item == 'clay' || holding_item == 'coarse_dirt' || holding_item == 'rooted_dirt' || holding_item == 'dirt' || holding_item == 'grass_block' || holding_item == 'gravel' || holding_item == 'melon' || holding_item == 'mycelium' || holding_item == 'podzol' || holding_item == 'pumpkin' || holding_item == 'carved_pumpkin' || holding_item == 'brown_mushroom' || holding_item == 'red_mushroom' || holding_item == 'crimson_nylium' || holding_item == 'warped_nylium' || holding_item == 'crimson_fungus' || holding_item == 'warped_fungus' || holding_item == 'crimson_roots' || holding_item == 'warped_roots' || holding_item == 'dandelion' || holding_item == 'poppy' || holding_item == 'blue_orchid' || holding_item == 'allium' || holding_item == 'azure_bluet' || holding_item == 'red_tulip' || holding_item == 'orange_tulip' || holding_item == 'white_tulip' || holding_item == 'pink_tulip' || holding_item == 'oxeye_daisy' || holding_item == 'cornflower' || holding_item == 'lily_of_the_valley' || holding_item == 'wither_rose' , 
                modify(_, 'remove');
                count = count + 1
            )
        )
    );
    print ('Successfully removed ' + count + ' zombie(s)/drowned(s)/enderman(s).');
    null
)
