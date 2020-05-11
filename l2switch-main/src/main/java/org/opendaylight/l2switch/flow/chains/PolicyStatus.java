/*
 * Copyright © 2018 slab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.l2switch.flow.chain;

import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.yang.types.rev130715.MacAddress;

public class PolicyStatus {
    //    public MacAddress destMac;
    public String destMac;
    public boolean setup;
    public String[] states;
    public String curState;
    public boolean canTransition;
    public int devNum;
    private int stateNum;
    private int stateMax;

    public PolicyStatus(String destMac, String[] states, int devNum) {
	this.destMac=destMac;
	this.states=states;
	this.devNum=devNum;
	this.stateMax=this.states.length;		
	this.setup=false;
	this.stateNum=0;
	curState=states[stateNum];
	if (this.stateMax >1){
	    this.canTransition=true;
	}else{
	    this.canTransition=false;
	}
    }

    public void updateSetup(boolean newSetupVal){
	this.setup=newSetupVal;
    }

    public String getCurState(void){
	return this.curState;
    }

    public boolean getCanTransition(void) {
	return this.canTransition;
    }

    public void transitionState(void){
	if (!this.canTransition){
	    return;
	}
	this.stateNum++;
	this.curState=this.states[stateNum];
	if (this.stateNum>=this.stateMax){
	    this.canTransition=false;
	}
    }   
	
}
