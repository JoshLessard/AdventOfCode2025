package com.adventofcode2025.dec01;

class Safe {

    private static final int NUMBER_OF_POSITIONS = 100;

    private int currentPosition;
    private int zeroPositionCount = 0;
    private int zeroPositionEndCount = 0;

    Safe( int startingPosition ) {
        this.currentPosition = startingPosition;
    }

    void rotateLeft( int numberOfClicks ) {
        int startingPosition = currentPosition;
        zeroPositionCount += numberOfClicks / NUMBER_OF_POSITIONS;
        numberOfClicks %= NUMBER_OF_POSITIONS;
        currentPosition -= numberOfClicks;
        if ( currentPosition < 0 ) {
            currentPosition += NUMBER_OF_POSITIONS;
            if ( startingPosition != 0 ) {
                ++zeroPositionCount;
            }
        } else if ( currentPosition == 0 ) {
            ++zeroPositionEndCount;
            if ( startingPosition != 0 ) {
                ++zeroPositionCount;
            }
        }
    }

    void rotateRight( int numberOfClicks ) {
        int startingPosition = currentPosition;
        zeroPositionCount += numberOfClicks / NUMBER_OF_POSITIONS;
        numberOfClicks %= NUMBER_OF_POSITIONS;
        currentPosition += numberOfClicks;
        if ( startingPosition != 0 && currentPosition > NUMBER_OF_POSITIONS ) {
            ++zeroPositionCount;
        }
        currentPosition %= NUMBER_OF_POSITIONS;
        if ( currentPosition == 0 ) {
            ++zeroPositionEndCount;
            if ( startingPosition != 0 ) {
                ++zeroPositionCount;
            }
        }
    }

    int zeroPositionCount() {
        return zeroPositionCount;
    }

    int zeroPositionEndCount() {
        return zeroPositionEndCount;
    }
}
