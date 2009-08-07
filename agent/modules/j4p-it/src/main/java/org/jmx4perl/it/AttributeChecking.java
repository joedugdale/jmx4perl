package org.jmx4perl.it;

import javax.management.MBeanRegistration;
import javax.management.ObjectName;
import javax.management.MBeanServer;

/*
 * jmx4perl - WAR Agent for exporting JMX via JSON
 *
 * Copyright (C) 2009 Roland Huß, roland@cpan.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 * A commercial license is available as well. Please contact roland@cpan.org for
 * further details.
 */

/**
 * @author roland
 * @since Aug 7, 2009
 */
public class AttributeChecking implements AttributeCheckingMBean, MBeanRegistration {


    private String name;
    private boolean state = false;
    private int idx = 0;
    private String strings[] = {
            "Started",
            "Stopped"
    };

    public AttributeChecking(String pName) {
        name = pName;
        reset();
    }

    public void reset() {
        state = false;
        idx = 0;
    }

    public boolean getState() {
        // Alternate
        state = !state;
        return state;
    }

    public String getString() {
        return strings[idx++ % 2];
    }

    public ObjectName preRegister(MBeanServer pMBeanServer, ObjectName pObjectName) throws Exception {
        return new ObjectName(name);
    }

    public void postRegister(Boolean pBoolean) {
    }

    public void preDeregister() throws Exception {
    }

    public void postDeregister() {
    }
}
