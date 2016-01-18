#!/usr/bin/perl

use strict;
use warnings;

sub cross {
    my @result;
    my $mid = @_ / 2;
    for (my $i = 0; $i < @_ / 2; $i++) {
        push(@result, $_[$i] . $_[$mid]);
        $mid++;
    }
    return @result;
}

my @cols = qw(1 2 3 4 5 6 7 8 9);
my @rows = qw(A B C D E F G H I);

my @crossed = cross(@rows, @cols);

print $crossed[0];
print $crossed[1];

###### HOLY SHIT THIS IS COMPLICATED!!!! #########