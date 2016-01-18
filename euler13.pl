use strict;
use warnings;
use bigint;

open(NUM_FILE, 'numbers.txt');
my $total = 0;

while (<NUM_FILE>) {
    chomp;
    $total += $_;
}
close(NUM_FILE);

my $ans = substr($total, 0, 10);
print "$ans\n";