package com.VarlamoreThieving;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.awt.*;
import java.security.PublicKey;

@Slf4j
@PluginDescriptor(	name = "Varlamore thieving")
public class VarlamoreThievingPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private VarlamoreThievingConfig config;

	@Override
	protected void startUp() throws Exception
	{
		//log.info("Example started!");
	}

	@Override
	protected void shutDown() throws Exception {
		//log.info("Example stopped!");
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if(config.ShinyAlert() && chatMessage.getMessage().contains("You notice something shine somewhere else in the house."))
		{
			RunSound();
		}
		else if(config.CitizenAlert() && chatMessage.getMessage().contains("You hear someone outside spot the homeowner coming back!")){
			RunSound();
		}
	}

	private void RunSound()
	{
		Runnable sound1 =(Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
		if(sound1 != null) sound1.run();
	}

	@Provides
	VarlamoreThievingConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(VarlamoreThievingConfig.class);
	}
}
