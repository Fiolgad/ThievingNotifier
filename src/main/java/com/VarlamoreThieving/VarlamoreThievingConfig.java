package com.VarlamoreThieving;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("example")
public interface VarlamoreThievingConfig extends Config
{
	@ConfigItem(
		keyName = "Shiny alert",
		name = "Shiny alert",
		description = "Alert player when shiny can be found"
	)
	default boolean ShinyAlert()
	{
		return true;
	}
	@ConfigItem(
		keyName = "Wealthy citizen",
		name = "Wealthy citizen",
		description = "Alert player when wealthy citizen is about to return"
	)

	default boolean CitizenAlert()
	{
		return true;
	}
}
