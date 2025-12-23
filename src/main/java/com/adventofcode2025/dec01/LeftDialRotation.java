package com.adventofcode2025.dec01;

class LeftDialRotation implements DialRotation {

    private final int numberOfClicks;

    LeftDialRotation( int numberOfClicks ) {
        this.numberOfClicks = numberOfClicks;
    }

    @Override
    public void applyTo( Safe safe ) {
        safe.rotateLeft( numberOfClicks );
    }
}
