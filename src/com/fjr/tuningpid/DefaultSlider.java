/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fjr.tuningpid;

import javax.swing.BoundedRangeModel;
import javax.swing.event.ChangeListener;

/**
 *
 * @author mamat
 */
public class DefaultSlider implements BoundedRangeModel{
    
    int extent ;

    public DefaultSlider() {
    }
    
    @Override
    public int getMinimum() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setMinimum(int newMinimum) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getMaximum() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setMaximum(int newMaximum) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setValue(int newValue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setValueIsAdjusting(boolean b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean getValueIsAdjusting() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getExtent() {
       // throw new UnsupportedOperationException("Not supported yet.");
        return this.extent;
    }

    @Override
    public void setExtent(int newExtent) {
     //   throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setRangeProperties(int value, int extent, int min, int max, boolean adjusting) {
      //  throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addChangeListener(ChangeListener x) {
     //   throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeChangeListener(ChangeListener x) {
    //    throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
