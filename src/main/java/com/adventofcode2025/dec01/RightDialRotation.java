package com.adventofcode2025.dec01;

class RightDialRotation implements DialRotation {

    private final int numberOfClicks;

    RightDialRotation( int numberOfClicks ) {
        this.numberOfClicks = numberOfClicks;
    }

    @Override
    public void applyTo( Safe safe ) {
        safe.rotateRight( numberOfClicks );
    }
}
