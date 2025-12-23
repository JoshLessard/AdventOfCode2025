package com.adventofcode2025.dec01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern ROTATION_PATTERN = Pattern.compile( "^([LR])(\\d+)$" );

    public static void main( String[] args ) throws Exception {
        Safe safe = new Safe( 50 );
        parseInput().forEach( r -> r.applyTo( safe ) );
        System.out.println( "The password for Part One is " + safe.zeroPositionEndCount() );
        System.out.println( "The password for Part Two is " + safe.zeroPositionCount() );
    }

    private static List<DialRotation> parseInput() throws IOException {
        try ( BufferedReader reader = new BufferedReader( new FileReader( "src/main/resources/dec01/input.txt" ) ) ) {
            return reader
                .lines()
                .map( ROTATION_PATTERN::matcher )
                .filter( Matcher::matches )
                .map( Main::parseRotation )
                .toList();
        }
    }

    private static DialRotation parseRotation( Matcher matcher ) {
        char direction = matcher.group( 1 ).charAt( 0 );
        int numberOfClicks = Integer.parseInt( matcher.group( 2 ) );
        return switch ( direction ) {
            case 'L' -> new LeftDialRotation( numberOfClicks );
            case 'R' -> new RightDialRotation( numberOfClicks );
            default -> throw new IllegalArgumentException();
        };
    }
}
