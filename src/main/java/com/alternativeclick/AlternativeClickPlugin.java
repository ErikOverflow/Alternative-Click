package com.alternativeclick;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.awt.*;
import java.awt.event.MouseEvent;

@Slf4j
@PluginDescriptor(
	name = "Alternative Click"
)
public class AlternativeClickPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private AlternativeClickConfig config;

	@Inject
	private KeyManager keyManager;

	@Inject
	private AlternativeClickListener listener;

	@Override
	protected void startUp() throws Exception
	{
		keyManager.registerKeyListener(listener);
	}

	protected void Click() {
		Canvas canvas = client.getCanvas();
		Point point = (Point) client.getCanvas().getMousePosition();
		canvas.dispatchEvent(new MouseEvent(canvas, MouseEvent.MOUSE_PRESSED,
				System.currentTimeMillis(),0,point.x, point.y,
				0, false, 0 ));

	}

	@Override
	protected void shutDown() throws Exception
	{
		keyManager.unregisterKeyListener(listener);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{

	}

	@Provides
	AlternativeClickConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AlternativeClickConfig.class);
	}
}
