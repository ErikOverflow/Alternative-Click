package com.alternativeclick;

import net.runelite.api.KeyCode;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ModifierlessKeybind;
import java.awt.event.KeyEvent;

@ConfigGroup("clickmapping")
public interface AlternativeClickConfig extends Config
{
	@ConfigItem(
			keyName = "click",
			name = "Alternative click key",
			description = "The key which will simulate a mouse click"
	)
	default ModifierlessKeybind click()
	{
		return new ModifierlessKeybind(KeyEvent.VK_SPACE, 0);
	}
}
