package com.alternativeclick;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class AlternativeClickTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(AlternativeClickPlugin.class);
		RuneLite.main(args);
	}
}