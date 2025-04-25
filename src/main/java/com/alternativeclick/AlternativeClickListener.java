package com.alternativeclick;

import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.input.KeyListener;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class AlternativeClickListener implements KeyListener {
    @Inject
    private AlternativeClickPlugin plugin;

    @Inject
    private AlternativeClickConfig config;

    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    private final Set<Character> blockedChars = new HashSet<>();

    @Override
    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();
        if(keyChar != KeyEvent.CHAR_UNDEFINED && blockedChars.contains(keyChar)){
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char keyChar = e.getKeyChar();
        if(config.click().matches(e) && !blockedChars.contains(keyChar)){
            e.consume();
            plugin.Click();
            blockedChars.add(keyChar);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        final char keyChar = e.getKeyChar();
        if (keyChar != KeyEvent.CHAR_UNDEFINED)
        {
            blockedChars.remove(keyChar);
        }
    }
}
