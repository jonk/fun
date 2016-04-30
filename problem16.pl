use strict;
use warnings;
use bigint;

my $str = 2**1000;
my @arr = split('', $str);

my $sum = 0;
$sum += $_ for @arr;

print "$sum\n";