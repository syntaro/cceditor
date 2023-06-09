/*
 * Copyright 2023 Syntarou YOSHIDA.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jp.synthtarou.cceditor.common;

import java.util.ArrayList;

/**
 *
 * @author Syntarou YOSHIDA
 */
public class CCGlobalTimer {
    static class Item {
        long tick;
        Runnable action;
    }
    
    ArrayList<Item> _pending;
    
    public static CCGlobalTimer _timer;
    
    static {
        _timer = new CCGlobalTimer();
        Thread t = new Thread() {
            public void run() {
                _timer.mysticLoop();
            }
        };
        t.setDaemon(true);
        t.start();
    }
    
    protected CCGlobalTimer() {
        _pending = new ArrayList<Item>();
    }
    
    public static void letsCountdown(long time, Runnable action) {
        Item i = new Item();
        i.tick = System.currentTimeMillis() + time;
        i.action = action;
        synchronized(_timer._pending) {
            _timer._pending.add(i);
            _timer._pending.notify();
        }
    }
    
    public void mysticLoop() {
        while(true) {
            Item pop = null;
            long current = System.currentTimeMillis();
            long nextTick = 60 * 1000 + current;
            synchronized(_pending) {
                for (Item i : _pending) {
                    if (i.tick <= current) {
                        pop = i;
                        _pending.remove(i);
                        break;
                    }
                }
                for (Item i : _pending) {
                    if (i.tick <= nextTick) {
                        nextTick = i.tick;
                    }
                }
                if (pop == null) {
                    try {
                        _pending.wait(nextTick - current);
                    }catch(InterruptedException e) {
                    }
                }
            }
            if (pop != null) {
                try {
                    pop.action.run();
                }catch(Throwable e) {
                    e.printStackTrace();
                }            
            }
        }
    }
}            