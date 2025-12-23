package com.adventofcode2025.dec01;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SafeTest {

    @Test
    public void newSafeHasNoZeroPositionCounts() {
        Safe safe = new Safe( 0 );

        assertThat( safe.zeroPositionCount() )
            .isZero();
        assertThat( safe.zeroPositionEndCount() )
            .isZero();
    }

    @Test
    public void endingAtZeroFromTheLeftRecordsOneZeroPositionEndCount() {
        Safe safe = new Safe( 98 );

        safe.rotateRight( 2 );

        assertThat( safe.zeroPositionEndCount() )
            .isOne();
    }

    @Test
    public void endingAtZeroFromTheRightRecordsOneZeroPositionEndCount() {
        Safe safe = new Safe( 5 );

        safe.rotateLeft( 5 );

        assertThat( safe.zeroPositionEndCount() )
            .isOne();
    }

    @Test
    public void endingAtZeroFromTheLeftRecordsOneZeroPositionCount() {
        Safe safe = new Safe( 93 );

        safe.rotateRight( 7 );

        assertThat( safe.zeroPositionCount() )
            .isOne();
    }

    @Test
    public void endingAtZeroFromTheRightRecordsOneZeroPositionCount() {
        Safe safe = new Safe( 12 );

        safe.rotateLeft( 12 );

        assertThat( safe.zeroPositionCount() )
            .isOne();
    }

    @Test
    public void startingAtZeroAndRotatingRightDoesNotRecordZeroPositionCount() {
        Safe safe = new Safe( 0 );

        safe.rotateRight( 27 );

        assertThat( safe.zeroPositionCount() )
            .isZero();
    }

    @Test
    public void startingAtZeroAndRotatingLeftDoesNotRecordZeroPositionCount() {
        Safe safe = new Safe( 0 );

        safe.rotateLeft( 39 );

        assertThat( safe.zeroPositionCount() )
            .isZero();
    }

    @Test
    public void rotatingPastZeroFromTheLeftRecordsOneZeroPositionCount() {
        Safe safe = new Safe( 99 );

        safe.rotateRight( 2 );

        assertThat( safe.zeroPositionCount() )
            .isOne();
    }

    @Test
    public void rotatingPastZeroFromTheRightRecordsOneZeroPositionCount() {
        Safe safe = new Safe( 7 );

        safe.rotateLeft( 8 );

        assertThat( safe.zeroPositionCount() )
            .isOne();
    }

    @Test
    public void rotating100RightFromZeroRecordsOneZeroPositionAndOneZeroPositionEndCount() {
        Safe safe = new Safe( 0 );

        safe.rotateRight( 100 );

        assertThat( safe.zeroPositionCount() )
            .isOne();
        assertThat( safe.zeroPositionEndCount() )
            .isOne();
    }

    @Test
    public void rotating100LeftFromZeroRecordsOneZeroPositionAndOneZeroPositionEndCount() {
        Safe safe = new Safe( 0 );

        safe.rotateLeft( 100 );

        assertThat( safe.zeroPositionCount() )
            .isOne();
        assertThat( safe.zeroPositionEndCount() )
            .isOne();
    }

    @Test
    public void rotating100RightNotStartingFromZeroRecordsOneZeroPosition() {
        Safe safe = new Safe( 83 );

        safe.rotateRight( 100 );

        assertThat( safe.zeroPositionCount() )
            .isOne();
        assertThat( safe.zeroPositionEndCount() )
            .isZero();
    }

    @Test
    public void rotating100LeftNotStartingFromZeroRecordsOneZeroPosition() {
        Safe safe = new Safe( 46 );

        safe.rotateLeft( 100 );

        assertThat( safe.zeroPositionCount() )
            .isOne();
        assertThat( safe.zeroPositionEndCount() )
            .isZero();
    }

    @Test
    public void rotatingOver100RightAndLandingOnZeroRecordsTwoZeroPositionAndOneZeroPositionEndCount() {
        Safe safe = new Safe( 83 );

        safe.rotateRight( 117 );

        assertThat( safe.zeroPositionCount() )
            .isEqualTo( 2 );
        assertThat( safe.zeroPositionEndCount() )
            .isOne();
    }

    @Test
    public void rotatingOver100LeftAndLandingOnZeroRecordsTwoZeroPositionAndOneZeroPositionEndCount() {
        Safe safe = new Safe( 23 );

        safe.rotateLeft( 123 );

        assertThat( safe.zeroPositionCount() )
            .isEqualTo( 2 );
        assertThat( safe.zeroPositionEndCount() )
            .isOne();
    }

    @Test
    public void rotatingOver100RightStartingFromZeroRecordsOneZeroPositionCount() {
        Safe safe = new Safe( 0 );

        safe.rotateRight( 123 );

        assertThat( safe.zeroPositionCount() )
            .isOne();
        assertThat( safe.zeroPositionEndCount() )
            .isZero();
    }
}
